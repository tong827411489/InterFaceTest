package com.java.cn;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;

public class httpJsoup {
	
	/**
	 * get请求，参数直接加在url后面，调用
	 * @param url
	 * @return
	 */
	 
	public Document httpGet(String url){
		
		Document doc = null;
		try {
			Connection con = Jsoup.connect(url);
			doc = con.get();
			return doc;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * post方法，参数名及参数值需要后续填写
	 * 
	 */
	public Document httpPost(String url,String param){
		Connection con = Jsoup.connect(url);
		con.data(param, param);
		return null;
	}
	
	public Document httpPost(String url,String param,String name){
		Connection con = Jsoup.connect(url);
		con.data(param, param);
		return null;
	}
	
	public static void main(String[] agrs){
		httpJsoup h = new  httpJsoup();
		String name =h.httpGet("http://www.baidu.com").toString();
		System.out.println(name);
		if (name.contains("百度一下")) {
			System.out.println("断言成功");
		}else{
			System.out.println("断言失败");
		}
		Assert.assertEquals(name.contains("百度一下"), true);
	}
}
