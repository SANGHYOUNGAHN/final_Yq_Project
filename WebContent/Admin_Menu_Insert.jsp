<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 메뉴등록</title>
</head>
<body>
<form method="post" action="Admin_Main_Page.jsp">
<input type="submit" value="뒤로">
</form>
<form method="post" action="InsertMenu.do">
<br>
<br>
<table>
  <h2>메뉴 등록</h2>
  <tr>
		<td>일련번호</td>
		<td><input type="text" name="mn_id" value="" size=""></td>
	</tr>
	<tr>
		<td>날짜</td>
		<td><input type="text" name="mn_date" size=""></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="mn_name" size=""></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input type="text" name="mn_price" size=""></td>
	</tr>
	<tr>
		<td>장소 </td>
		<td><input type="text" name="chain" size=""></td>
	</tr>
	<tr>
		<td>타입</td>
		<td><input type="text" name="mn_type" size=""></td>
	</tr>
</table>
<br>
<br>
<br>
<input type="submit" value="등록">

</form>
</body>
</html>