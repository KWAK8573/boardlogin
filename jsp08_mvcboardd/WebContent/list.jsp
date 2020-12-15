<%@page import="java.util.List"%>
<%@page import="com.vision.dao.MvcBoardDAO"%>
<%@page import="com.vision.common.MBUtils"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.vision.bean.MvcBoard"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h1>게시글 목록</h1>
	
	<hr>
<%
	List<MvcBoard> list = (List<MvcBoard>)request.getAttribute("list");
	if(list==null){
		SqlSession mysession = MBUtils.getSession();
		MvcBoardDAO dao = mysession.getMapper(MvcBoardDAO.class);
		list = dao.list();
		request.setAttribute("list", list);
		mysession.close();
	}
		for(MvcBoard x:list){
			out.println(x);
		}
%>
<a href= "write_view.do">글작성</a>
</body>
</html>