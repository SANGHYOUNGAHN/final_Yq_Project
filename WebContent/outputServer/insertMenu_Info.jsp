<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="final_Project_Dao.AdminInsertMenuDAO"%>


<%
	request.setCharacterEncoding("UTF-8");

	String mn_id = request.getParameter("mn_id");
	System.out.println(mn_id);
	
	String mn_date = request.getParameter("mn_date");
	System.out.println(mn_date);
	
	String mn_name = request.getParameter("mn_name");
	System.out.println(mn_name);
	
	String mn_price = request.getParameter("mn_price");
	System.out.println(mn_price);
	
	String chain = request.getParameter("chain");
	System.out.println(chain);
	
	String mn_type = request.getParameter("mn_type");
	System.out.println(mn_type);
	
	String mn_sold= "";
%>

<%
	AdminInsertMenuDAO adminDAO = AdminInsertMenuDAO.getInstance();
	adminDAO.AppInsertMenu(mn_id, mn_date, mn_name, mn_price, chain, mn_type, mn_sold);
%>




