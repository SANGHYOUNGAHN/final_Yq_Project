<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="final_Project_Dao.ForuseDAO"%>

    

    
     <%
	request.setCharacterEncoding("UTF-8");
	String buy_id = request.getParameter("buy_id");
	System.out.println(buy_id);
	
	String mn_chain = request.getParameter("mn_chain");
	System.out.println(mn_chain);
	
	String mn_name =request.getParameter("mn_name");
	System.out.println(mn_name);
	
	String and_rcgPrice = request.getParameter("mn_price");
	System.out.println(and_rcgPrice);
	%>
	
	<%ForuseDAO fDao = ForuseDAO.getInstance(); 
	  fDao.appBuyMenu(buy_id, mn_name, mn_chain, and_rcgPrice);
	 %>
	