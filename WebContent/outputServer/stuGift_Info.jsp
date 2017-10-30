<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="final_Project_Dao.ForuseDAO"%>


 
    <%
	request.setCharacterEncoding("UTF-8");
	String send_id = request.getParameter("send_id");
	System.out.println(send_id);
	
	String receive_id = request.getParameter("re_id");
	System.out.println(receive_id);
	
	String and_rcgPrice = request.getParameter("mn_price");
	System.out.println(and_rcgPrice);
	%>
	
	
	<% ForuseDAO fDao = ForuseDAO.getInstance();
	   fDao.appStuGift(send_id,receive_id,and_rcgPrice);%>