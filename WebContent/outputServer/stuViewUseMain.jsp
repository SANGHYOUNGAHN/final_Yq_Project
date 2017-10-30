<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Dao.ViewUseDAO"%>
<%@ page import="final_Project_Vo.appViewUseVO"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page%>




<%
	request.setCharacterEncoding("UTF-8");
	String and_id = request.getParameter("stu_id");
	System.out.println(and_id);

	ViewUseDAO viewDao = ViewUseDAO.getInstance();
	List<appViewUseVO> stuMainLastList = viewDao.appMainCheckUse(and_id);
	JSONArray useMainArray = new JSONArray();

	for (int i = 0; i < stuMainLastList.size(); i++) {

		JSONObject stuMainObj = new JSONObject();
		stuMainObj.put("date", stuMainLastList.get(i).getDate());
		stuMainObj.put("chain", stuMainLastList.get(i).getChain());
		stuMainObj.put("mn_name", stuMainLastList.get(i).getMn_name());
		stuMainObj.put("mn_price", stuMainLastList.get(i).getMn_price());
		stuMainObj.put("stu_id", stuMainLastList.get(i).getStu_id());
		stuMainObj.put("f_use", stuMainLastList.get(i).getF_use());
		useMainArray.add(stuMainObj);

	}

	out.print(useMainArray);
%>


