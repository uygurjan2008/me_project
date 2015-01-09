package com.uyghur.ruzi;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.uyghur.ruzi.dao.userdao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class useraction {
	private String goodname;
	private int goodprice;
	private String goodpic;
	private Map<String, Object> requestMap;

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public int getGoodprice() {
		return goodprice;
	}

	public void setGoodprice(int goodprice) {
		this.goodprice = goodprice;
	}

	public String getGoodpic() {
		return goodpic;
	}

	public void setGoodpic(String goodpic) {
		this.goodpic = goodpic;
	}

	public useraction() {

	}

	JSONObject jo = new JSONObject();

	public String readJson() throws Exception {

		// JSON��ʽ���ݽ�������
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out;
		out = response.getWriter();
		// ��Ҫ�����ص��ͻ��˵Ķ���

		userdao ud = new userdao();
		List l1 = ud.rd();

		JSONArray ja3 = JSONArray.fromObject(l1);

		// JSONObject jso=JSONObject.fromObject(l1);

		// ��Beanת��ΪJSONArray����

		System.out.println("JSONArray�������ݸ�ʽ��");

		System.out.println(ja3.toString());

		// ����Json���ݣ�����һ��map��һ��Employee����

		// jo.put("AAA", ja3);
		jo.put("info", "json_test");
		jo.put("success", true);
		jo.put("tablename", "userinfo");

		jo.put("items", ja3);

		jo.write(out);

		System.out.println("\n���չ����JSON���ݸ�ʽ��");
		System.out.println(jo.toString());

		out.flush();
		out.close();

		return "success";// jo;

	}

	public String goods_I() throws Exception {
			
		String status;
		// JSON��ʽ���ݽ�������
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out;
		out = response.getWriter();

		userdao ud = new userdao();
		boolean ad = ud.good_insert(getGoodname(), getGoodprice(), getGoodpic());
		JSONObject o = new JSONObject();

		if (ad == true) {
			o.put("success", ad);
			o.put("good name", getGoodname());
			o.put("good price", getGoodprice());
			o.put("good pic", getGoodpic());
			o.write(out);
			out.flush();
			out.close();
			status="success";
			
		}else{
			
			status="fail";
			o.put("success", status);
			o.put("info","operation has failed");
			o.write(out);
			out.flush();
			out.close(); 
		}

		return status;

	}

}
