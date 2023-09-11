<%@page import="dto.Sawon"%>
<%@page import="java.util.List"%>
<%@page import="dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	tr{text-align: center;}
</style>
 <title>Insert title here</title>
</head>
<body bgcolor="yellow">
<%
	SawonDao sd = SawonDao.getInstance();
	List<Sawon> sawonList = sd.list();

%>
	<div id="header">
		<%@ include file="component/header.jsp" %>
	</div>
	<div id="content">
		<h1>사원 정보</h1>		
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th>사번</th><th>이름</th><th>급여</th><th>핸드폰번호</th>
				</tr>	
			</thead>
			<tbody>
			<c:forEach var="sawon" items="${sawonList}">
				<tr>
					<td>${sawon.sabun}</td>
					<td>${sawon.name}</td>
					<td>${sawon.sal}</td>
					<td>${sawon.handphone}</td>
				</tr>
			</c:forEach>

			</tbody>
		</table>
	</div>
	<div id="footer">
		<h4>저작권 침해시 법적처벌대상 유의</h4>
		<h5>중앙정보(주) 02-1234-5678</h5>
	</div>


</body>
</html>