<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%><%@page import="dto.Sawon"%> <%@page import="java.util.List"%> <%@page
import="dao.SawonDao"%>  <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
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
  <body bgcolor="yellow">
    <%@ include file="component/header.jsp" %>
    <section id="orderContent" class="p-5  m-5">
      <div class="container">
        <div class="row justify-content-center">
          <div class="card col-md-4 col-lg-5 text-center">
            <h2 class="card-title p-3">주문 상세내역</h2>
            <table class="table table-bordered table-hover align-middle">
              <tr><td>주문일자</td><td>${order.order_date}</td></tr>
              <tr><td>거래처</td><td>${order.cust_code} ${order.cust_name}</td></tr>
              <tr><td>주문요청내역</td><td>${order.order_desc}</td></tr>
              <tr><td>접수사원</td><td>${order.sabun} ${order.sawon_name}</td></tr>
              <tr><td>접수상태</td><td>${order.order_status}</td></tr>
              <tr>
                <td colspan="2">
                        <div
                          class="btn-group"
                          role="group"
                          aria-label="Basic example"
                        >			  
                  <c:if test="${order.order_status=='0'}">
                    <input type="button" value="주문제품추가" class="btn btn-primary"
                            onclick="location.href='orderUpdateForm.do?order_date=${order.order_date}&cust_code=${order.cust_code}'">
                    <input type="button" value="주문거래처삭제" class="btn btn-danger"
                            onclick="location.href='orderDeleteForm.do?order_date=${order.order_date}&cust_code=${order.cust_code}'">
                  </c:if>
                  <input type="button" class="btn btn-success" value="주문거래처목록"
                      onclick="location.href='orderList.do'">
                </div>
                </td>
              </tr>  
            </table>
          </div>
        </div>
      </div>
    </section>
    <%@ include file="component/footer.jsp" %>
  </body>
</html>
