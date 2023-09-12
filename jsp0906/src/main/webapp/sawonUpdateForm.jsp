<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@ include file="component/header.jsp" %>
	<section id="sawonUpdate" class="pb-md-5 pb-3">
		<div class="container">
			<div class="row justify-content-center">
				<div class="card col-md-4 col-lg-5 text-center">
					<h2 class="card-title p-3 ">회원 수정</h2>
					<form  action="sawonUpdatePro.do" method="post">
						 <div class="form-group">
							<input type="hidden" name="sabun" value="${sawon.sabun}">	
							<table class="table table-bordered table-hover align-middle">
								<tr><th>사번</th><td>${sawon.sabun}</td></tr>
								<tr><th>이름</th>
									<td><input type="text" name="name" required="required" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"
															value="${sawon.name}"></td></tr>
								<tr><th>급여</th>	
									<td><input type="number" name="sal" required="required" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"
															value="${sawon.sal}"></td></tr> 
								<tr><th>핸드폰번호</th>
									<td><input type="tel" name="handphone" required="required" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"
															value="${sawon.handphone}"></td></tr>
								<tr><td colspan="2">
									<div class="btn-group" role="group" aria-label="Basic example">																
										<input type="submit" value="확인" class="btn btn-primary">
										<input type="reset" value="다시작성" class="btn btn-danger">
										</div>
									</td>
								</tr>
							</table>
						</div>
					</form>	
				</div>
			</div>
		</div>
	</section>


	
	<%@ include file="component/footer.jsp" %>
</body>
</html>