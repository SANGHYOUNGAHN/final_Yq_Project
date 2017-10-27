<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Dao.MenuWeekDAO"%>
<%@ page import="final_Project_Vo.MenuWeekVO"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>


<%
	MenuWeekDAO mDao = MenuWeekDAO.getInstance();
	List<MenuWeekVO> menuWeekList = mDao.selectWeekMenu();

	JSONArray menuArray = new JSONArray();

	for (int i = 0; i < menuWeekList.size(); i++) {

		JSONObject menuObj = new JSONObject();
		menuObj.put("mn_date", menuWeekList.get(i).getMn_date());
		menuObj.put("chain", menuWeekList.get(i).getChain());
		menuObj.put("mn_type", menuWeekList.get(i).getMn_type());
		menuObj.put("mn_name", menuWeekList.get(i).getMn_name());
		menuObj.put("mn_price", menuWeekList.get(i).getMn_price());
		menuArray.add(menuObj);

	}

	out.print(menuArray);
%>
