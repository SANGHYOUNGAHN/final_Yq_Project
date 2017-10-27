<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="final_Project_Dao.MenuDAO"%>
<%@ page import="final_Project_Vo.MenuVO"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.List"%>


<%
	MenuDAO mDao = MenuDAO.getInstance();
	List<MenuVO> menuServerList = mDao.serverMenu();

	JSONArray menuArray = new JSONArray();

	for (int i = 0; i < menuServerList.size(); i++) {

		JSONObject menuObj = new JSONObject();
		menuObj.put("mn_date", menuServerList.get(i).getMn_date());
		menuObj.put("chain", menuServerList.get(i).getChain());
		menuObj.put("mn_type", menuServerList.get(i).getMn_type());
		menuObj.put("mn_name", menuServerList.get(i).getMn_name());
		menuObj.put("mn_price", menuServerList.get(i).getMn_price());
		menuObj.put("mn_sold", menuServerList.get(i).getMn_sold());
		menuArray.add(menuObj);

	}

	out.print(menuArray);
%>
