<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="final_Project_Vo.StudentVO" %>
<%@ page import="final_Project_Dao.StudentDAO" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.List" %>


<% 

request.setCharacterEncoding("UTF-8");

String and_id =request.getParameter("stu_id"); 
System.out.println(and_id);
%>
	
	

<% 
	
	StudentDAO sDao = StudentDAO.getInstance();
	List<StudentVO>loginList = sDao.appLoginList(and_id);
	
	
	JSONArray jArr = new JSONArray();
	
	
	for(int i=0; i<loginList.size(); i++){
		
		JSONObject userObject = new JSONObject();
		userObject.put("stu_id",loginList.get(i).getStu_id());
		userObject.put("stu_pw",loginList.get(i).getStu_pw());
		userObject.put("stu_name",loginList.get(i).getStu_name());
		userObject.put("stu_change",loginList.get(i).getStu_change());
		jArr.add(userObject);
		
		
	
	}
	out.print(jArr);

	%>
	


