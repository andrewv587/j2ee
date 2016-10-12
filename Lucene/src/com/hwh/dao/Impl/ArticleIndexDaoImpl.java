package com.hwh.dao.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import com.hwh.dao.ArticleIndexDao;
import com.hwh.model.Article;
import com.hwh.utils.ArticleDocumentUtils;
import com.hwh.utils.Atc2DocConv;

/**
 * һ��Ҫ�ڷ�����������iwc���������close�������޷�����д��
 * @author andrew
 *
 */

public class ArticleIndexDaoImpl implements ArticleIndexDao {
	
	
	public void save(Article article) {
		IndexWriterConfig iwc = new IndexWriterConfig(ArticleDocumentUtils.getAnalyzer());
		IndexWriter iw=null;

		try {
			iw = new IndexWriter(ArticleDocumentUtils.getDir(), iwc);
			iw.addDocument(Atc2DocConv.atc2Doc(article));
			iw.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(iw!=null){
				try {
					iw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void delete(int id) {
		
		IndexWriterConfig iwc = new IndexWriterConfig(ArticleDocumentUtils.getAnalyzer());
		IndexWriter iw=null;
		Term term = new Term("id", String.valueOf(id));
		try {
			iw = new IndexWriter(ArticleDocumentUtils.getDir(), iwc);
			iw.deleteDocuments(term);
			iw.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(iw!=null){
				try {
					iw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void update(Article article) {
		
		IndexWriterConfig iwc = new IndexWriterConfig(ArticleDocumentUtils.getAnalyzer());
		IndexWriter iw=null;
		int id=article.getId();
		Term term = new Term("id", String.valueOf(id));
		try {
			iw = new IndexWriter(ArticleDocumentUtils.getDir(), iwc);
			iw.updateDocument(term, Atc2DocConv.atc2Doc(article));
			iw.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(iw!=null){
				try {
					iw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	}

	public List<Article> search(String queryString) {
		return this.search(queryString,Integer.MAX_VALUE);
	}

	public List<Article> search(String queryString, int maxDoc) {
		IndexReader reader=null;
		try {
			reader = DirectoryReader.open(ArticleDocumentUtils.getDir());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		IndexSearcher searcher = new IndexSearcher(reader);

		Query query=null;;
		TopDocs topDoc=null;
		try {
			query = new QueryParser("context", ArticleDocumentUtils.getAnalyzer()).parse(queryString);
			topDoc = searcher.search(query, maxDoc); 
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ScoreDoc[] docs = topDoc.scoreDocs;
		List<Article> articles=new ArrayList<Article>();
		int topDocLength= (maxDoc>topDoc.totalHits)? topDoc.totalHits:maxDoc;
		System.out.println(topDocLength);
		for (int i = 0; i < topDocLength; ++i) {
			int docId = docs[i].doc;
			Document doc=null;
			try {
				doc = searcher.doc(docId);
			} catch (IOException e) {
				e.printStackTrace();
			}
			articles.add(Atc2DocConv.doc2Atc(doc));
		}
		System.out.println(articles.size());
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return articles;
	}

}
