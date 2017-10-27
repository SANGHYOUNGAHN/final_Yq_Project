<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="org.json.simple.JSONArray" %>
    <%@ page import="final_Project_Dao.MenuWeekDAO"%>
    <%@ page import="final_Project_Vo.MenuWeekVO" %>
	<%@ page import="org.json.simple.JSONObject" %>
	<%@ page import="java.util.List" %>

<%  MenuWeekDAO mDao = MenuWeekDAO.getInstance(); 
	List<MenuWeekVO>menuWeekList = mDao.selectWeekMenu();
	
	JSONArray jWeekArray = new JSONArray();
	
	
	for(int i=0; i<menuWeekList.size(); i++){
		
		JSONObject jWeekObject = new JSONObject();
		jWeekObject.put("mn_date", menuWeekList.get(i).getMn_date());
		jWeekObject.put("chain", menuWeekList.get(i).getChain());
		jWeekObject.put("mn_type", menuWeekList.get(i).getMn_type());
		jWeekObject.put("mn_name", menuWeekList.get(i).getMn_name());
		jWeekObject.put("mn_price", menuWeekList.get(i).getMn_price());
		jWeekArray.add(jWeekObject);
		
		
	}
	System.out.println(jWeekArray);
	
	%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="Student_Menu.jsp">
<input type="submit" value="뒤로"></form>

<form method="post" action="MenuWeek.do">
<center><h1>주간 메뉴</h1>
   	<table style="width:2000; table-layout:fixed; text-align:center;" borderColor=#000000  cellSpacing=0 cellPadding=0 border=1 align="center">
    			<tr height=50>
            	 <th>일자</th>
            	 <th>위치</th>
            	 <th>종류</th>
            	 <th>메뉴명</th>
            	 <th>가격</th>
				 </tr>
            	 <c:forEach var="menu" items="${menuWeekList}">		
				 <tr height=50>
				 <td width=100>${menu.mn_date}</td>
				 <td width=100>${menu.chain}</td>
				 <td width=100>${menu.mn_type}</td>
				 <td width=100>${menu.mn_name}</td>
				 <td width=100>${menu.mn_price}</td>
				 </tr>
				 </c:forEach>
				 </table>
</center>
</form>
</body>
</html>