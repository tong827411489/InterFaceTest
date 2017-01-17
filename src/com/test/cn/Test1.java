package com.test.cn;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.java.cn.HttpRequest;

public class Test1 {
	
	long data1;
	long data2;
	
	  /**
	   * 初始时间获得
	   */
	  @BeforeClass
	  public void beforeClass() {
		  data1 = System.currentTimeMillis();
	  }
	
  @Test(dataProvider = "dp")
  public void f(String s) {
	  HttpRequest hp = new HttpRequest();
	  String m = hp.sendPost("http://192.168.0.186:8080/approval/initAuditOpinionToJson.html","orderNo="+s,
				"http://192.168.0.186:8080/login/doLogin.html", "account=zrjbr1&password=96e79218965eb72c92a549dd5a330112");
	  if (!m.equals("")&&!m.equals(200)){
		  if (s.equals("zrdb2016120710543408")) {
				Assert.assertEquals(m.contains("王莹莹"), true);
			  }else{
				Assert.assertEquals(m.contains("王莹莹"), false);
			  }
	}else{
		 System.out.println("调用接口失败"+s);
		 Assert.assertEquals(true, false);
	}
	  Reporter.log(m);
	  System.out.println(m);
	  
  }
  
//  @Test
  public void test2(){
	  HttpRequest hp = new HttpRequest();
	  String mm = hp.sendPost("http://192.168.0.186:8080/loanOrder/loanMaterialList.html","loanOrderMaterial.backStatus=4&pageNum=1&loanOrderMaterial.idCard=&loanOrderMaterial.realName=&loanOrderMaterial.orderNo=",
				"http://192.168.0.186:8080/login/doLogin.html", "account=zrjbr1&password=96e79218965eb72c92a549dd5a330112");
	  System.out.println(mm);
  }
  

  @DataProvider(name = "dp")
  public Object[][] dp() {
    return new Object[][] {
        new Object[] { "zrdb2016120110381705" },
    	new Object[] { "zrdb2016102420463409" },
        new Object[] { "zrdb2016120710543408" },//z这个订单被银行退回
        new Object[] { "zrdb2016112817544192" }
    };
  }
  


  /**
   * 结束时间获得
   */
  @AfterClass
  public void afterClass() {
	  data2 = System.currentTimeMillis();
	  long n = data2-data1;
	  System.out.println("时间："+n/1000+"秒");
  }

}
