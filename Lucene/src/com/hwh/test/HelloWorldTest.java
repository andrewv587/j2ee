package com.hwh.test;

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import com.hwh.model.Article;

/**
 * 对Lucene进行测试
 * 
 * @author andrew
 * 
 */

public class HelloWorldTest {

	//private static Analyzer analyzer = new StandardAnalyzer(); //只能分单个词
	private static Analyzer analyzer = new CJKAnalyzer();//连续两个词　可以使用IKAnalyzer
	
	@Test
	public void createIndex() throws Exception {
		
		// indexWrite add document
		Directory dir = FSDirectory.open(Paths.get("./index"));
		// Directory dir = new RAMDirectory(); 可保存在内存中
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		//当dir不存在时，会创建索引库
		IndexWriter iw = new IndexWriter(dir, iwc);

		for (int i = 40; i < 50; i++) {
			// create context
			Article article = new Article();
			article.setId(i);
			article.setName("检索 ");
			article.setContext("这里我们采用了全文检索，检索内容无所谓，能用就行");

			// context --> document
			//对于需要分词的内容我们使用TextField，对于像id这样不需要分词的内容我们使用StringField
			Document doc = new Document();
			doc.add(new StringField("id", String.valueOf(article.getId()),
					Field.Store.YES));
			doc.add(new StringField("name", article.getName(), Field.Store.YES));
			doc.add(new TextField("context", article.getContext(),
					Field.Store.YES));
			
			iw.addDocument(doc);
			iw.commit();
		}
		
		iw.close();

	}

	@Test
	public void search() throws Exception {
		// query
		this.createIndex();
		String querystr = "检索";
		Query query = new QueryParser("context", analyzer).parse(querystr);

		// searcher
		Directory dir = FSDirectory.open(Paths.get("./index"));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);

		// index
		int maxDoc=200;
		//sort 加true表示为降序
		TopDocs topDoc = searcher.search(query, maxDoc); // 2表示查询的最大数
		ScoreDoc[] docs = topDoc.scoreDocs;
		int topDocLength= (maxDoc>topDoc.totalHits)? topDoc.totalHits:maxDoc;
		// get document --> article
		System.out.println("Found " + topDocLength + " hits.");
		
		//add highlight function
		Formatter formatter = new SimpleHTMLFormatter("<b>","<b>"); //前缀和后缀,默认<B></B>
		Scorer scorer = new QueryScorer(query);//查询条件
		Highlighter highLighter=new Highlighter(formatter, scorer );
		
		Fragmenter fragmenter = new SimpleFragmenter(15); //查询单词的数量　默认100
		highLighter.setTextFragmenter(fragmenter);
		
		for (int i = 0; i < topDocLength; ++i) {
			int docId = docs[i].doc;
			Document doc = searcher.doc(docId);
			String text = highLighter.getBestFragment(analyzer, "context", doc.get("context"));
			Article article = new Article();
			article.setId(Integer.parseInt(doc.get("id")));
			article.setName(doc.get("name"));
			//article.setContext(doc.get("context"));
			article.setContext(text);
			// 打印内容和编号
			System.out.println(article + " scores: " + docs[i].score);
		}
		reader.close();
	}
}
