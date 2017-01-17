package com.java.cn;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;



public class HttpRequest {
	
	private final Logger logger = Logger.getLogger(HttpRequest.class);
    /**
     * 向指定URL发送GET方法的请求，使用多态
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param cookies
     * 			     调取方法，获得cookies
     * @return URL 所代表远程资源的响应结果
     */
   

    public String sendGet(String url) {
    	
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setReadTimeout(20000);
            connection.setConnectTimeout(20000);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"utf-8"));
            Integer responseCode = ((HttpURLConnection) connection).getResponseCode();
            if (responseCode == 200) {
            	String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                return result;
			}else{
				return "";
			}
            
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            logger.error(result);
            e.printStackTrace();
            return "";
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    
    public String sendGet(String url,String param) {
    	
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url+"?"+param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setReadTimeout(20000);
            connection.setConnectTimeout(20000);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"utf-8"));
            Integer responseCode = ((HttpURLConnection) connection).getResponseCode();
            if (responseCode == 200) {
            	String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                return result;
			}else{
				return "";
			}
           
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
            return "";
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
    }
    
public String sendGet(String url,String cookiesUrl,String cookiesParam) {
    	
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpjsoupCookies httpjsoupcookies = new httpjsoupCookies();
            connection.setRequestProperty("Cookie", httpjsoupcookies.sendPost(cookiesUrl, cookiesParam));
            connection.setReadTimeout(20000);
            connection.setConnectTimeout(20000);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"utf-8"));
            Integer responseCode = ((HttpURLConnection) connection).getResponseCode();
            if (responseCode == 200) {
            	String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                return result;
			}else{
				return "";
			}
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
            return "";
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
 
    
 public String sendGet(String url, String param,String cookiesUrl,String cookiesParam) {
    	
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpjsoupCookies httpjsoupcookies = new httpjsoupCookies();
            connection.setRequestProperty("Cookie", httpjsoupcookies.sendPost(cookiesUrl, cookiesParam));
            connection.setReadTimeout(20000);
            connection.setConnectTimeout(20000);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"utf-8"));
            Integer responseCode = ((HttpURLConnection) connection).getResponseCode();
            if (responseCode == 200) {
            	String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                return result;
			}else{
				return "";
			}
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
            return "";
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
 
    /**
     * 向指定 URL 发送POST方法的请求，使用多态
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param cookies
     * 			  调取方法，获得cookies
     * @return 所代表远程资源的响应结果
     */
    public String sendPost(String url, String param,String cookiesUrl,String cookiesParam) {
    	
    	
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
            httpjsoupCookies httpjsoupcookies = new httpjsoupCookies();
            conn.setRequestProperty("Cookie", httpjsoupcookies.sendPost(cookiesUrl, cookiesParam));
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
//            Map<String, List<String>> map = conn.getHeaderFields();
            // 遍历所有的响应头字段
//           for (String key : map.get("Set-Cookie")) {
//			System.out.println(key.substring(0, 42));
//		}
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"utf-8"));
            
            Integer responseCode = ((HttpURLConnection) conn).getResponseCode();
            if (responseCode == 200) {
            	String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                return result;
			}else{
				return ""+responseCode;
			}
           
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            logger.error("dgsdgds");
            e.printStackTrace();
            return "";
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
    
    
    public String sendPost(String url,String param) {
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
//            Map<String, List<String>> map = conn.getHeaderFields();
//            // 遍历所有的响应头字段
//           for (String key : map.get("Set-Cookie")) {
//			System.out.println(key.substring(0, 42));
//		}
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"utf-8"));
            Integer responseCode = ((HttpURLConnection) conn).getResponseCode();
            if (responseCode == 200) {
            	String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                return result;
			}else{
				return "";
			}
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
            return "";
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
    
    
    /**
     * 暂时不用的方法
     */
    public void cookieLogin(){
    	HttpServletRequest request = null ;
    	Cookie[] cookies = request.getCookies();
    	String usename = null;
    	String password = null;
    	
    	if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equalsIgnoreCase("account")) {
					usename = c.getValue();
					System.out.println(usename);
				}else if(c.getName().equalsIgnoreCase("loginInfo")){
					password = c.getValue();
					System.out.println(password);
				}
			}
		}
    }
    
    public static void main(String[] args){
    	HttpRequest hp = new HttpRequest();
//    	String n = hp.sendGet("http://192.168.0.186:9092/warningSetting/getWarningDetailsCount.html", "http://192.168.0.186:9092/login/doLogin.html", "account=zrjbr1&password=96e79218965eb72c92a549dd5a330112");
//    	System.out.println(n);
//    	String m = hp.sendPost("http://192.168.0.186:8080/approval/initAuditOpinionToJson.html", "orderNo=zrdb2016120710543408",
//    								"http://192.168.0.186:8080/login/doLogin.html", "account=zrjbr1&password=96e79218965eb72c92a549dd5a330112");
//    	System.out.println(m);
    	String m = hp.sendPost("http://192.168.0.186:8080/loanUser/queryCredit.html", "orderNo=zrdb2016120915415462",
				"http://192.168.0.186:8080/login/doLogin.html", "account=zrjbr1&password=96e79218965eb72c92a549dd5a330112");
    	System.out.println(m);
    }
}