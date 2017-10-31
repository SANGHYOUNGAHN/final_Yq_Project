<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Dao.RechargeDAO"%>
<%@ page import="final_Project_Vo.ForuseVO"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page%>

<%
	request.setCharacterEncoding("UTF-8");
	String and_id = request.getParameter("stu_id");
	System.out.println(and_id);
	
	String date = request.getParameter("date");
	System.out.println(date);

	RechargeDAO viewDao = RechargeDAO.getInstance();
	List<ForuseVO> totRcgList = viewDao.appSearchRecharge(and_id,date);
	JSONArray totRcgArray = new JSONArray();

	for (int i = 0; i < totRcgList.size(); i++) {

		JSONObject totRcgObj = new JSONObject();
		
		
		totRcgObj.put("sumRcgTot", totRcgList.get(i).getSumRcgTot());
		totRcgArray.add(totRcgObj);

	}

	out.print(totRcgArray);
%>





