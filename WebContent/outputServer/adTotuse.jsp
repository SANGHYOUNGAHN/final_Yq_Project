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
	System.out.println(date);
	
	
	String chain = request.getParameter("chain");
	System.out.println(chain);
%>


<% 
	AdminTotForuseDAO vDao = AdminTotForuseDAO.getInstance();
	List<ViewUseVO> adTotList = vDao.appGetTot(date, chain);
	
	JSONArray jArr = new JSONArray();
	
	for (int i =0; i<adTotList.size(); i++){
		
		JSONObject totObj = new JSONObject();
		totObj.put("adTot" , adTotList.get(i).getAppTot());
		jArr.add(totObj);
	}
	
	
	out.print(jArr);
	
	
%>