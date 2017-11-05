<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Vo.appViewUseVO"%>
<%@ page import="final_Project_Dao.ViewUseDAO"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>


<%
	request.setCharacterEncoding("UTF-8");
	String and_id = request.getParameter("stu_id");
	System.out.println(and_id);
%>
<%
	ViewUseDAO vuDAO = ViewUseDAO.getInstance();
    List<appViewUseVO> appfindList = vuDAO.appfindUse(and_id);
    
    
	JSONArray jArr = new JSONArray();

	for (int i = 0; i < appfindList.size(); i++) {

		JSONObject adminObj = new JSONObject();
		adminObj.put("date", appfindList.get(i).getDate());
		adminObj.put("chain", appfindList.get(i).getChain());
		adminObj.put("mn_name", appfindList.get(i).getMn_name());
		adminObj.put("mn_price",appfindList.get(i).getMn_price());
		adminObj.put("f_use", appfindList.get(i).getF_use());
		jArr.add(adminObj);
	}

	out.print(jArr);



%>

