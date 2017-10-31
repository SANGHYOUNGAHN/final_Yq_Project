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
	String and_mid = request.getParameter("stu_id");
	System.out.println(and_mid);

	ViewRcgDAO viewDao = ViewRcgDAO.getInstance();
	List<appViewRcgVO> stuMonthLastList = viewDao.appMonthCheckRcg(and_mid);
	JSONArray useMonthArray = new JSONArray();

	for (int i = 0; i < stuMonthLastList.size(); i++) {

		JSONObject stuMthObj = new JSONObject();
		stuMthObj.put("date", stuMonthLastList.get(i).getDate());
		stuMthObj.put("chain", stuMonthLastList.get(i).getChain());
		stuMthObj.put("mn_name", stuMonthLastList.get(i).getMn_name());
		stuMthObj.put("mn_price", stuMonthLastList.get(i).getMn_price());
		stuMthObj.put("stu_id", stuMonthLastList.get(i).getStu_id());
		stuMthObj.put("f_use", stuMonthLastList.get(i).getF_use());
		useMonthArray.add(stuMthObj);

	}

	out.print(useMonthArray);
%>
