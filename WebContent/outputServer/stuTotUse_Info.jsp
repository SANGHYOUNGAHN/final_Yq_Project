<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Dao.ForuseDAO"%>
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

	ForuseDAO viewDao = ForuseDAO.getInstance();
	List<ForuseVO> totUseList = viewDao.appSearchForuse(and_id, date);
	JSONArray totUseArray = new JSONArray();

	for (int i = 0; i < totUseList.size(); i++) {

		JSONObject totUseObj = new JSONObject();

		totUseObj.put("sumTot", totUseList.get(i).getSumTot());
		totUseArray.add(totUseObj);

	}

	out.print(totUseArray);
%>
