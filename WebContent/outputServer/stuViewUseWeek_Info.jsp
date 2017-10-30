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
	List<appViewUseVO> stuWeekLastList = viewDao.appWeekCheckUse(and_id);
	JSONArray useWeekArray = new JSONArray();


	for (int i = 0; i < stuWeekLastList.size(); i++) {

		JSONObject stuWeekObj = new JSONObject();
		stuWeekObj.put("date", stuWeekLastList.get(i).getDate());
		stuWeekObj.put("chain", stuWeekLastList.get(i).getChain());
		stuWeekObj.put("mn_name", stuWeekLastList.get(i).getMn_name());
		stuWeekObj.put("mn_price", stuWeekLastList.get(i).getMn_price());
		stuWeekObj.put("stu_id", stuWeekLastList.get(i).getStu_id());
		stuWeekObj.put("f_use", stuWeekLastList.get(i).getF_use());
		useWeekArray.add(stuWeekObj);

	}
  out.print(useWeekArray);
%>



