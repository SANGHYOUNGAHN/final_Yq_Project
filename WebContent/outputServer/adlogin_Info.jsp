<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Vo.AdminVO"%>
<%@ page import="final_Project_Dao.AdminDAO"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>


<%
	request.setCharacterEncoding("UTF-8");

	String and_id = request.getParameter("ad_id");
	System.out.println(and_id);
%>


<%
	AdminDAO aDao = AdminDAO.getInstance();
	List<AdminVO> adLoginList = aDao.appLoginList(and_id);

	JSONArray jArr = new JSONArray();

	for (int i = 0; i < adLoginList.size(); i++) {

		JSONObject adminObj = new JSONObject();
		adminObj.put("ad_id", adLoginList.get(i).getAd_id());
		adminObj.put("ad_pw", adLoginList.get(i).getAd_pw());
		adminObj.put("ad_name", adLoginList.get(i).getAd_name());
		jArr.add(adminObj);

	}
	out.print(jArr);
%>