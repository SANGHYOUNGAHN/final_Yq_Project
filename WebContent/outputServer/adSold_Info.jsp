<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="final_Project_Dao.AdminSoldDAO"%>



<%
	request.setCharacterEncoding("UTF-8");

	String mn_name = request.getParameter("mn_name");
	System.out.println(mn_name);
	String chain = request.getParameter("chain");
	System.out.println(chain);
	String mn_sold = request.getParameter("mn_sold");
	System.out.println(mn_sold);
%>

<% 

	AdminSoldDAO asDao = AdminSoldDAO.getInstance();
	asDao.appSold(mn_name, chain, mn_sold);

%>
