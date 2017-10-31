<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Dao.ViewRcgDAO"%>
<%@ page import="final_Project_Vo.appViewRcgVO"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page%>




<%
	request.setCharacterEncoding("UTF-8");
	String and_id = request.getParameter("stu_id");
	System.out.println(and_id);

	ViewRcgDAO viewDao = ViewRcgDAO.getInstance();
	List<appViewRcgVO> stuThMonthLastList = viewDao.appThMonthCheckRcg(and_id);
	JSONArray useThMonthArray = new JSONArray();

	for (int i = 0; i < stuThMonthLastList.size(); i++) {

		JSONObject stuThMthObj = new JSONObject();
		stuThMthObj.put("date", stuThMonthLastList.get(i).getDate());
		stuThMthObj.put("chain", stuThMonthLastList.get(i).getChain());
		stuThMthObj.put("mn_name", stuThMonthLastList.get(i).getMn_name());
		stuThMthObj.put("mn_price", stuThMonthLastList.get(i).getMn_price());
		stuThMthObj.put("stu_id", stuThMonthLastList.get(i).getStu_id());
		stuThMthObj.put("f_use", stuThMonthLastList.get(i).getF_use());
		useThMonthArray.add(stuThMthObj);

	}

	out.print(useThMonthArray);
%>
