package org.hy.commons.web.example.cookie.history;

import java.util.HashMap;
import java.util.Map;

public class BookDB {
	private static Map<String, Book> books = new HashMap<String, Book>();
	static{
		books.put("1", new Book("1", "葵花宝典", "侯茂绵", 5.00f, "欲练此功，必须练好基本功"));
		books.put("2", new Book("2", "辟邪剑法", "王冬冬", 4.00f, "欲练此功，必须练好基本功"));
		books.put("3", new Book("3", "金瓶梅", "杜佳瑞", 15.00f, "古代爱情小说"));
		books.put("4", new Book("4", "Java面向对象编程", "王昭珽", 85.00f, "Java入门经典书籍"));
		books.put("5", new Book("5", "红高粱", "程有愿", 7500000.00f, "买套房"));
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	public static Book findBookById(String id){
		return books.get(id);
	}
}
