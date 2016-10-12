package com.hwh.utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

import com.hwh.model.Article;

public class Atc2DocConv {
	
	public static Document atc2Doc(Article article) {
		Document doc = new Document();
		doc.add(new StringField("id", String.valueOf(article.getId()),
				Field.Store.YES));
		doc.add(new StringField("name", article.getName(), Field.Store.YES));
		doc.add(new TextField("context", article.getContext(), Field.Store.YES));
		return doc;
	}
	
	public static Article doc2Atc(Document doc){
		Article article = new Article();
		article.setId(Integer.parseInt(doc.get("id")));
		article.setName(doc.get("name"));
		article.setContext(doc.get("context"));
		return article;
	}

}
