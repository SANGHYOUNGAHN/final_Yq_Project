<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Vo.ViewUseVO"%>
<%@ page import="final_Project_Dao.AdminTotForuseDAO"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>


<%
	request.setCharacterEncoding("utf-8");

	String date = request.getParameter("date");
	

	String chain = request.getParameter("chain");

%>


<%
	AdminTotForuseDAO vDao = AdminTotForuseDAO.getInstance();
	List<ViewUseVO> adGetList = vDao.appGetAward(date, chain);

	JSONArray jArr = new JSONArray();
	for (int i = 0; i < adGetList.size(); i++) {

		JSONObject totObj = new JSONObject();
		totObj.put("mn_name", adGetList.get(i).getMn_name());
		totObj.put("getAward", adGetList.get(i).getGetAward());
		jArr.add(totObj);
	}
	
	out.print(jArr);
%>