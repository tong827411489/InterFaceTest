package submitCredit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Decoder.BASE64Encoder;

import com.java.cn.HttpRequest;
import com.java.cn.httpJsoup;

public class submitCreditTest {
	
	private static final Logger logger = Logger.getLogger(submitCreditTest.class);
	HttpRequest hp = new HttpRequest();
	httpJsoup j = new httpJsoup();
	
	
//	@Test
	public void downLoadTemplate(){
//		String m = hp.sendPost("http://112.74.99.75:8090/credit/downLoadTemplate.html", "key=fc43a6a0141a1661b84746207b4cc0b9");
//		System.out.println(m);
	}
//	@Test
//	public void submitCredit() throws UnsupportedEncodingException{
//		
//		Map<String, Object> n = subdata();
//		String m = hp.sendPost("http://112.74.99.75:8090/credit/submitCredit.html", n);
//		System.out.println(m);
//			Map<String, String> map = new LinkedHashMap<String, String>();
//	map.put("key", "fc43a6a0141a1661b84746207b4cc0b9");
//	map.put("accreditCode", "20015137001001201612150001");
//	map.put("identity", "410802198404280010");
//	map.put("userName", "王兴霖");
//	map.put("sex", "1");
//	map.put("mobile", "18268207165");
//	map.put("national", "汉");
//	map.put("valid", "2001.01.01");
//	map.put("validEnd", "2021.01.01");
//	map.put("issued", "焦作市解放区公安局");
//	map.put("address", "河南省焦作市解放区军民街2号院12号楼309室");
//	
//	map.put("pic1", getImageBase64(new File("D:/征信材料/11111.jpg")));
//	map.put("pic2", getImageBase64(new File("D:/征信材料/22222.jpg")));
//	map.put("pic3", getImageBase64(new File("D:/征信材料/33333.jpg")));
//	map.put("pic4", getImageBase64(new File("D:/征信材料/44444.jpg")));
//	map.put("pic5", getImageBase64(new File("D:/征信材料/55555.jpg")));
//	
//	logger.info(map.toString());
//	
//	String map1 = map.toString().replaceAll(",", "&");
//	String map2 = map1.replaceAll(" ", "");
	
//	}
	
//	@Test
	public void queryCreditStatus(){
		String m = hp.sendPost("http://114.55.55.41:8090/credit/queryCreditStatus.html", 
				"key=4aacccf46ea51761cf81a0caaa4f206d&accreditCode=20015137001001201612150103");
		System.out.println(m);
	}
	
//	@Test
	public void callBack(){
		String m = hp.sendPost("http://114.55.55.41:8090/credit/callBack.html", "key=4aacccf46ea51761cf81a0caaa4f206d&callBack=www.baidu.com");
		System.out.println(m);
	}
	
	
	
//	@Test
	public void downLoadCreditResult(){
		String m = hp.sendPost("http://114.55.55.41:8090/credit/downLoadCreditResult.html", "key=fc43a6a0141a1661b84746207b4cc0b9&accreditCode=20015137001001201612150001");
		System.out.println(m);
	}

	
	
	/**
	 * data 12-30
	 * 接口改变格式
	 * @throws IOException 
	 */
//	@Test
	public void subdata() throws IOException{
		
		String key = "4aacccf46ea51761cf81a0caaa4f206d";
		String accreditCode = "20015137001001201612150103";
		String identity = "410802198404280010";
		String userName = "王兴霖";
		String sex = "1";
		String mobile = "18268207165";
		String national = "汉";
		String valid = "2001.01.01";
		String validEnd = "2021.01.01";
		String issued = "焦作市解放区公安局";
		String address = "河南省焦作市解放区军民街2号院12号楼309室";
		String pic1 = getImageBase64(new File("D:/征信材料/11111.jpg"));
		String pic2 = getImageBase64(new File("D:/征信材料/22222.jpg"));
		String pic3 = getImageBase64(new File("D:/征信材料/33333.jpg"));
		String pic4 = getImageBase64(new File("D:/征信材料/44444.jpg"));
		String pic5 = getImageBase64(new File("D:/征信材料/55555.jpg"));
		
//		String mmm = "key="+key+"&accreditCode="+accreditCode+"&identity="+
//				identity+"&userName="+userName+"&sex="+sex+"&mobile="+mobile+"&national="+national+"&valid="+valid+"&validEnd="+validEnd+"&issued="+issued
//				+"&address="+address+"&pic1="+pic1+"&pic2="+pic2+"&pic3"+pic3+"&pic4="+pic4+"&pic5="+pic5;
//		logger.info(mmm);
		String m = hp.sendPost("http://114.55.55.41:8090/credit/submitCredit.html","key="+key+"&accreditCode="+accreditCode+"&identity="+
				identity+"&userName="+userName+"&sex="+sex+"&mobile="+mobile+"&national="+national+"&valid="+valid+"&validEnd="+validEnd+"&issued="+issued
				+"&address="+address+"&pic1="+pic1+"&pic2="+pic2+"&pic3="+pic3+"&pic4="+pic4+"&pic5="+pic5);
		System.out.println(m);
	} 
	
	
	/**
	 * 银行流水核查
	 */
//	@Test(dataProvider = "dp")
	public void valueAddedServer(String name,String idCard,String bankCard){
		String grantKey = "6800851613df97e034af387efc1aab99";
		String apiKey = "bankWater";
		String callBack = "/valueAdded/serviceUrlBankWater.html";
//		name = "孙卫东";
//		idCard = "330121197412210019";
//		bankCard = "6226095710054078";
		String pic1 = getImageBase64(new File("D:/征信材料/11111.jpg"));
		String pic2 = getImageBase64(new File("D:/征信材料/22222.jpg"));
		String pic3 = getImageBase64(new File("D:/征信材料/33333.jpg"));
		String pic4 = getImageBase64(new File("D:/征信材料/44444.jpg"));
		String pic5 = getImageBase64(new File("D:/征信材料/55555.jpg"));
		String pic6 = getImageBase64(new File("D:/征信材料/55555.jpg"));
		
		String mm = "grantKey="+grantKey+"&apiKey="+apiKey+"&callBack="+callBack+"&name="+name+"&idCard="+idCard+"&bankCard="+bankCard+"&pic1="+pic1+"&pic2="+pic2+"&pic3="+pic3+"&pic4="+pic4+"&pic5="+pic5+"&pic6="+pic6;

		String m = hp.sendPost("http://112.74.99.75:8090/valueAdded/valueAddedServe.html",mm);
		System.out.println(m);
	}
	
	

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] {"孙卫东", "330121197412210019","6226095710054078" },//正确
//	      new Object[] {"孙卫", "330121197412210019","6226095710054078" }, //姓名错误
//	      new Object[] {"孙卫东", "330121197412210018","6226095710054078" },//身份证错误
//	      new Object[] {"孙卫东", "330121197412210019","6226095710054079" },//银行卡错误
//	      new Object[] {"孙卫", "330121197412210018","62260957100540781" },//全错
	    };
	  }
	
	/**
	 * 银行流水核查结果
	 */
	
//	@Test
	public void valueAddedServe(){
		String grantKey = "6800851613df97e034af387efc1aab99";
		String apiKey = "queryBankWater";
		String reportId = "20170116BPW1OJU5";
		
		String mm = "grantKey="+grantKey+"&apiKey="+apiKey+"&reportId="+reportId;
		String m = hp.sendPost("http://112.74.99.75:8090/valueAdded/valueAddedServe.html", mm);
		System.out.println(m);
	}
	
	/**
	 *登记抵押
	 */
	
//	@Test
	public void valueAddedServePlateNumber(){
		String grantKey = "6800851613df97e034af387efc1aab99";
		String apiKey = "mortgage";
		String plateNumber = "LJDLAA194G0064645";
		String callBack = "/valueAdded/serviceUrl.html";
		
		String mm = "grantKey="+grantKey+"&apiKey="+apiKey+"&callBack="+callBack+"&plateNumber="+plateNumber;
//		String mm = "grantKey="+grantKey+"&apiKey="+apiKey+"&plateNumber="+plateNumber;
		String m = hp.sendPost("http://112.74.99.75:8090/valueAdded/valueAddedServe.html", mm);
		System.out.println(m);
	}
	
	/**
	 * 
	 * 查询抵押结果
	 */
//	@Test
	public void valueAddedServeLook(){
		String grantKey = "6800851613df97e034af387efc1aab99";
		String apiKey = "queryMortgage";
		String plateNumber = "LJDLAA194G0064645";
		String mortgageId = "371";
		
		String mm = "grantKey="+grantKey+"&apiKey="+apiKey+"&mortgageId="+mortgageId+"&plateNumber="+plateNumber;
//		String mm = "grantKey="+grantKey+"&apiKey="+apiKey+"&plateNumber="+plateNumber;
		String m = hp.sendPost("http://112.74.99.75:8090/valueAdded/valueAddedServe.html", mm);
		System.out.println(m);
	}
	/**
     * base64 把字符串转码为base64字符串
     * @Title: encoderStr
     * @param: @param param
     * @param: @return   
     * @return: String   
     * @throws
     */
    public static String encoderStr(String param){
    	String encoderStr = "";
    	try{
    		if(StringUtils.isNotBlank(param)){
    			BASE64Encoder encoder = new BASE64Encoder();
        		encoderStr = encoder.encode(param.getBytes());
    		}else{
    			return encoderStr;
    		}
    	}catch(Exception e){
    		encoderStr = "";
    		e.printStackTrace();
    	}
    	return encoderStr;
    }
    
    
    /**
     * 图片转化成base64字符串
     * @param file 文件对象
     * @return
     */
    public static String getImageBase64(File file) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        //String imgFile = "E:/image/001.png";//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Data = encoder.encode(data);
       
        return base64Data;//返回Base64编码过的字节数组字符串
    }
    
    /**
     * 身份证认证结果
     */
//    @Test
    public void valueAddedServeCard(){
    	String grantKey = "6800851613df97e034af387efc1aab99";
		String apiKey = "queryIdCard";
		String callBack = "http://112.74.99.75:8090/valueAdded/serviceUrlBankWater.html";
		String name = "孙卫东";
		String idCard = "330121197412210019";
		String Sfzphoto = getImageBase64(new File("D:/征信材料/11111.jpg"));
		String Qhzphoto = getImageBase64(new File("D:/征信材料/11111.jpg"));
		String mm = "grantKey="+grantKey+"&apiKey="+apiKey+"&callBack="+callBack+"&name="+name+"&idCard="+idCard+"&Sfzphoto="+Sfzphoto+"&Qhzphoto="+Qhzphoto;
		String m = hp.sendPost("http://112.74.99.75:8090/valueAdded/valueAddedServe.html", mm);
		System.out.println(m);
    }
    
    /**
     * 身份证认证网纹对比结果
     */
    @Test
    public void valueAddedServeidCard(){
    	String grantKey = "6800851613df97e034af387efc1aab99";
		String apiKey = "getReicnlbationResult";
		String reicnlbationId = "103";
		String mm = "grantKey="+grantKey+"&apiKey="+apiKey+"&reicnlbationId="+reicnlbationId;
		String m = hp.sendPost("http://112.74.99.75:8090/valueAdded/valueAddedServe.html", mm);
		System.out.println(m);
    }
}
