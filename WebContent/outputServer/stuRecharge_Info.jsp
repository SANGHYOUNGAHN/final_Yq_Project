<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="final_Project_Dao.ForuseDAO"%>

    
    
    <%
	request.setCharacterEncoding("UTF-8");
	String and_mid = request.getParameter("stu_id");
	System.out.println(and_mid);
	
	
	String and_rcgPrice = request.getParameter("mn_price");
	System.out.println(and_rcgPrice);
	%>
	
	<%ForuseDAO fDao = ForuseDAO.getInstance(); 
	  fDao.appStuRecharge(and_mid, and_rcgPrice);
	 
	%>
	
	
	