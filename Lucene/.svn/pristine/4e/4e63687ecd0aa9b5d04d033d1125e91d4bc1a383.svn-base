package com.hwh.test;


import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.hwh.dao.ArticleIndexDao;
import com.hwh.dao.Impl.ArticleIndexDaoImpl;
import com.hwh.model.Article;

public class IndexCRUDTest {
	private static ArticleIndexDao atdao = new ArticleIndexDaoImpl();
	
	@Test
	public void testSave(){
		Article article = new Article();
		article.setId(3);
		article.setName("hehad");
		article.setContext("this is our home home");
		atdao.save(article);
	
		this.testSearch();
	}
	
	@Test
	public void testDelete(){
		int id =2;
		atdao.delete(id);
		
		this.testSearch();
	}
	
	@Test
	public void testUpdate(){
		Article article = new Article();
		article.setId(13);
		article.setName("hehe");
		article.setContext("this is our asdfsfd home");
		atdao.update(article);
		
		this.testSearch();
	}
	
	@Test
	public void testSearch(){
		List<Article> articles = atdao.search("home");
		for(int i=0;i<articles.size();i++){
			System.out.println(articles.get(i));
		}
	}
	
}
