package com.uyghur.ruzi;

import java.util.List;
import java.util.Map;

import com.uyghur.ruzi.dao.userdao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class json {
	private String goodname;
	private String goodprice;
	private String goodpic;
	private Map<String, Object> requestMap;
	
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public String getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(String goodprice) {
		this.goodprice = goodprice;
	}
	public String getGoodpic() {
		return goodpic;
	}
	public void setGoodpic(String goodpic) {
		this.goodpic = goodpic;
	}
	
	public json() {

	}
	
	

	 JSONObject jo = new JSONObject();
	 
	 public  String readJson() throws Exception {

	        // JSON��ʽ���ݽ�������
	       
	        
	        userdao ud=new userdao();
	        List l1=ud.rd();
	
	        JSONArray ja3 = JSONArray.fromObject(l1);
	        
	       // JSONObject jso=JSONObject.fromObject(l1);
	       
	        // ��Beanת��ΪJSONArray����

	        System.out.println("JSONArray�������ݸ�ʽ��");
	        
	        System.out.println(ja3.toString());

	        // ����Json���ݣ�����һ��map��һ��Employee����
	        jo.put("items", ja3);
	        //jo.put("AAA", ja3);
	        jo.put("info", "json_test");
	        jo.put("success", true);
	        jo.put("tablename", "userinfo");
	        
	        
	        System.out.println("\n���չ����JSON���ݸ�ʽ��");
	        System.out.println(jo.toString());
	        
	        
	        
	      
	       
	       return "success";//jo;
	        
	        
	        
	        
	        
	        
	        
	        
	    }
	 
	  

	 
	 
	 
	 
	
	
}