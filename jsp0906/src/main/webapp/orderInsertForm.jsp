<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <%@ include file="component/header.jsp" %>
    <section id="orderInsert" class="p-5  m-5"">
      <div class="container">
        <div class="row justify-content-center">
          <div class="card col-md-4 col-lg-5 text-center">
            <h2 class="card-title p-3">주문 등록</h2>
            <form action="orderInsertPro.do" method="post">
              <div class="form-group p-2 justify-content-center">
                <input type="hidden" name="order_date" value="${order_date}" />
                <table class="table table-bordered table-hover align-middle">
                  <tr>
                    <th>주문일자</th>
                    <td>${order_date}</td>
                  </tr>
                  <tr>
                    <th>거래처명</th>
                    <td>
	                  <select 
	                    class="form-select" 
	                    name="custom"  
	                    required="required" 
	                    aria-label="Default select example"
	                  >
                        <c:forEach var="custom" items="${customList}">
					     	<option 
					     	  value='{"cust_name":${custom.cust_name},"cust_code":${custom.cust_code}}'>${custom.cust_name}</option>
					    </c:forEach>
	                  </select>
                    </td>
                  </tr>
                  <tr>
                    <th>거래요청내역</th>
                    <td>
	                  <input
	                    type="text"
	                    name="order_desc"
	                    required="required"
	                    class="form-control"
	                    aria-label="Default"
	                    aria-describedby="inputGroup-sizing-default"
	                  />
                    </td>
                  </tr>
                  <tr>
                    <th>담당사원(접수사원)</th>
                    <td>
	                  <select 
	                  	class="form-select" 
	                  	name="sawon"  
	                  	required="required" 
	                  	aria-label="Default select example">
                       <c:forEach var="sawon" items="${sawonList}">
					      <option value='{"sawon_name":${sawon.name},"sabun":${sawon.sabun}}'
					      >${sawon.name}</option>
					    </c:forEach>
	                  </select>
                    </td>
                  </tr>
                  </table>
                <input type="submit" value="확인" class="btn btn-primary" />
                <input type="reset" value="다시작성" class="btn btn-danger" />
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <%@ include file="component/footer.jsp" %>
  </body>
</html>
