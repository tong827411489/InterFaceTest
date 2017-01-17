package com.java.cn;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class Httpclient {
	
	
	public String getHttpClient(String url){
		HttpClient httpclient = new HttpClient();
		GetMethod getmethod = new GetMethod(url);
		 getmethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
		try {
			int status = httpclient.executeMethod(getmethod);
			if (status == HttpStatus.SC_OK) {
				return getmethod.getResponseBodyAsString();
			}else{
				return null;
			}
		} catch (Exception e) {
			throw  new RuntimeException();
		}
	}
		
	public String getHttpClient(String url,String param){
		HttpClient httpclient = new HttpClient();
		GetMethod getmethod = new GetMethod(url+"?"+param);
		 getmethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
		try {
			int status = httpclient.executeMethod(getmethod);
			if (status == HttpStatus.SC_OK) {
				return getmethod.getResponseBodyAsString();
			}else{
				return null;
			}
		} catch (Exception e) {
			throw  new RuntimeException();
		}
	}
	
	@SuppressWarnings("deprecation")
	public String postHttpClient(String url,String param){
		HttpClient httpclient = new HttpClient();
		PostMethod pm = new PostMethod(url);
		pm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
		pm.setRequestBody(param);
		
		try {
			int status = httpclient.executeMethod(pm);
			return pm.getResponseBodyAsString();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args){
		Httpclient h = new Httpclient();
//		String n = h.getHttpClient("http://www.baidu.com");
//		System.out.println(n);
		String n = h.postHttpClient("http://192.168.0.186:9092/login/doLogin.html", "account=18867149072&password=96e79218965eb72c92a549dd5a330112");
		System.out.println(n);
	}
}
