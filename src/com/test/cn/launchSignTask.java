package com.test.cn;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.java.cn.HttpRequest;

public class launchSignTask {
	private final Logger logger = Logger.getLogger(launchSignTask.class);
	/**
	 * 发起会签，选择对象为初审
	 */
	
	
//	@Test(priority = 0)
	public void nnn(){
		
		 HttpRequest hr = new HttpRequest();
		String m = hr.sendPost("http://192.168.0.186:9092/service/RealNameAuthentication.html", "orderNo=zrdb2016122715143780&materialsId=1",
				  "http://192.168.0.186:9092/login/doLogin.html", "account=zrjbr1&password=96e79218965eb72c92a549dd5a330112");
		  if (m != null&& m !="") {
			  Assert.assertEquals(m.contains("success"), true);
			  Assert.assertEquals(m.contains("一致"), true);
		}else{
			  System.out.println("调用失败，返回错误");
			  Assert.assertTrue(m.contains("当前账号无权发起会签。"));
			 
		  }
	}
//	@Test
	public void nn(){
		 HttpRequest hr = new HttpRequest();
		String m = hr.sendPost("http://192.168.0.186:9092/approval/launchSignTask.html", "orderNo=zrdb2016102421325165&prevFlowNodeId=1644&signUserIds=13464&opinion=该笔订单需要会签，请审批。&operatorId=13464",
				  "http://192.168.0.186:9092/login/doLogin.html", "account=zrjbr1&password=96e79218965eb72c92a549dd5a330112");
		  if (m != null&& m !="") {
			  Assert.assertTrue(m.contains("当前账号无权发起会签。"));
		  }else{
			  System.out.println("调用失败，返回错误");
			  Assert.assertTrue(m.contains("当前账号无权发起会签。"));
			  logger.error("促我");
		  }
	}
//  @Test(priority = 0)
  public void f() {
	  HttpRequest hr = new HttpRequest();
	  String m = hr.sendPost("http://192.168.0.186:9092/approval/launchSignTask.html", "orderNo=zrdb2016120817315475&prevFlowNodeId=1644&signUserIds=13464&opinion=该笔订单需要会签，请审批。&operatorId=13464",
			  "http://192.168.0.186:9092/login/doLogin.html", "account=zrjbr1&password=96e79218965eb72c92a549dd5a330112");
	  if (m != null&& m !="") {
		  Assert.assertTrue(m.contains("success"));
	  }else{
		  System.out.println("调用失败，返回错误");
	  }
	  
	  String mm = hr.sendPost("http://192.168.0.186:9092/approval/launchSignTask.html", "orderNo=zrdb2016120817315475",
			  "http://192.168.0.186:9092/login/doLogin.html", "account=zrjbr1&password=96e79218965eb72c92a549dd5a330112");
	  
	  if (m != null&& m !="") {
		  Assert.assertEquals(mm.contains("会签正在进行，请等待会签结果。"), true);
	  }else{
		  System.out.println("调用失败，返回错误");
	  }
  }
  /**
   * 不同意会签退回订单
   */
//  @Test(priority = 1)
  public void n(){
	  HttpRequest hr = new HttpRequest();
	  String m = hr.sendPost("http://192.168.0.186:9092/approval/signTaskAudit.html", "orderNo=zrdb2016122715143780&auditStatus=1&auditOpinion=",
			  "http://192.168.0.186:9092/login/doLogin.html", "account=zrcs1&password=96e79218965eb72c92a549dd5a330112");
	  
  }
  
  /**
   * 同意会签退回订单
   */
//  @Test(priority = 1)
  public void nnn1(){
	  HttpRequest hr = new HttpRequest();
	  String m = hr.sendPost("http://192.168.0.186:9092/approval/signTaskAudit.html", "orderNo=zrdb2016120817315475&auditStatus=2&auditOpinion=",
			  "http://192.168.0.186:9092/login/doLogin.html", "account=zrcs1&password=96e79218965eb72c92a549dd5a330112");
	  Assert.assertEquals(m.contains("success"), true);
  }
//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
  
  
  /**
   * 发起会签
   */
  
  @Test(priority = 0)
  public void launchSignTask(){
	  HttpRequest hr = new HttpRequest();
	  String orderNo = "zrdb2016121415125074";
	  String signUserIds = "13464";
	  String opinion = "该笔订单需要会签，请审批。";
	  String operatorId = "13464";
	  String prevFlowNodeId = "1644";
	  String m = hr.sendPost("http://192.168.0.186:9092/approval/launchSignTask.html", 
			  "orderNo="+orderNo+"&signUserIds="+signUserIds+"&opinion="+opinion+"&operatorId="+operatorId+"&prevFlowNodeId="+prevFlowNodeId, "http://192.168.0.186:9092/login/doLogin.html", 
			  "account=zrcs1&password=96e79218965eb72c92a549dd5a330112");
  }
  
  /**
   * 不同意会签
   */
  
//  @Test(priority = 1)
  public void signTaskAuditNo(){
	  HttpRequest hr = new HttpRequest();
	  String m = hr.sendPost("http://192.168.0.186:9092/approval/signTaskAudit.html", "orderNo=zrdb2016121415125074&auditStatus=1&auditOpinion=",
			  "http://192.168.0.186:9092/login/doLogin.html", "account=zrcs1&password=96e79218965eb72c92a549dd5a330112");
	  System.out.println(m);
  }
  /**
   * 同意会签
   */
  @Test(priority = 1)
  public void signTaskAuditYes(){
	  HttpRequest hr = new HttpRequest();
	  String m = hr.sendPost("http://192.168.0.186:9092/approval/signTaskAudit.html", "orderNo=zrdb2016121415125074&auditStatus=2&auditOpinion=",
			  "http://192.168.0.186:9092/login/doLogin.html", "account=zrcs1&password=96e79218965eb72c92a549dd5a330112");
	  System.out.println(m);
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
