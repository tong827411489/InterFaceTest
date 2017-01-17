package com.java.cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class httpjsoupCookies {
	
	public Map<String,String> httpCookies(String account,String password){
		try {
			Connection conn = Jsoup.connect("http://192.168.0.186:9092/login/doLogin.html");
			conn.data("account",account);
			conn.data("password",password);
			conn.timeout(30000);
			conn.method(Method.POST);
			Response response = conn.execute();
			Map<String, String> cookies = response.cookies(); 
			System.out.println(cookies);
			String b = cookies.toString();
			return cookies;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Cookie","com.ceair.cesso="+param);
            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            Map<String, List<String>> map = conn.getHeaderFields();
            // 遍历所有的响应头字段
            List<String> b = null;
            for (String key : map.get("Set-Cookie")) {
//    			System.out.println(key.substring(0, 42));
    			b = map.get("Set-Cookie");
    		}
            
            return b.get(0) ;
           
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
            return null;
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
	}
	public static void main(String[] args){
		httpjsoupCookies h =new httpjsoupCookies();
		Map<String,String> nn = h.httpCookies("18867149072", "96e79218965eb72c92a549dd5a330112");
		System.out.println(nn);
		
	}
}
