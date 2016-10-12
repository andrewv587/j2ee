package com.hwh.utils;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class ArticleDocumentUtils {
	private static Analyzer analyzer = new StandardAnalyzer();
	private static Directory dir = null;

	static {
		try {
			dir = FSDirectory.open(Paths.get("./index"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static Analyzer getAnalyzer() {
		return analyzer;
	}


	public static void setAnalyzer(Analyzer analyzer) {
		ArticleDocumentUtils.analyzer = analyzer;
	}


	public static Directory getDir() {
		return dir;
	}


	public static void setDir(Directory dir) {
		ArticleDocumentUtils.dir = dir;
	}
	


}
