<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Vo.StudentVO"%>
<%@ page import="final_Project_Dao.StudentDAO"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>


<%
	request.setCharacterEncoding("UTF-8");

	String and_id = request.getParameter("stu_id");
	System.out.println(and_id);
%>


<%
	StudentDAO aDao = StudentDAO.getInstance();
	List<StudentVO> adPwList = aDao.appLoginList(and_id);

	JSONArray jArr = new JSONArray();

	for (int i = 0; i < adPwList.size(); i++) {

		JSONObject adminObj = new JSONObject();
		adminObj.put("stu_pw", adPwList.get(i).getStu_pw());
		adminObj.put("stu_name", adPwList.get(i).getStu_name());
		jArr.add(adminObj);

	}
	out.print(jArr);
%>