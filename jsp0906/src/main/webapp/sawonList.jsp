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
 <title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
</head>
<body bgcolor="yellow">
	<%@ include file="component/header.jsp" %>
	<section id=sawonList class="pb-md-5 pb-3">
		<div class="container">
			<div class="row justify-content-center">
				<div class="card text-center">
					<h2 class="card-title p-3 ">사원 정보</h2>
					<div class="card-body">
						<table id="sawonTable" class="table table-bordered table-hover">
							<thead class="table-primary">
								<tr>
									<th>사번</th><th>이름</th><th>급여</th><th>핸드폰번호</th>
								</tr>	
							</thead>
							<tbody>
							<c:forEach var="sawon" items="${sawonList}">
								<tr>
								
									<td>${sawon.sabun}</td>
									<td><a href="sawonContent.do?sabun=${sawon.sabun}">
									${sawon.name}
									</a>
									</td>
									<td>${sawon.sal}</td>
									<td>${sawon.handphone}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>	
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="component/footer.jsp" %>


</body>
</html>