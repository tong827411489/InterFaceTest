package com.java.cn;

import java.util.logging.Logger;

import org.apache.commons.httpclient.URI;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class httpClientJson {
	
	
	public <JSON> JSON getApi(java.net.URI uri){
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet get = new HttpGet(uri);
//			log.info("执行API请求" + get.getRequestLine());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
