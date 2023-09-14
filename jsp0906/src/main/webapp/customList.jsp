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
    <section id="itemList" class="pb-md-5 pb-3 pt-3">
      <div class="container">
        <div class="row justify-content-center">
          <div class="card text-center">
            <h2 class="card-title p-3">고객 정보 (총:${totCnt}명)</h2>
            <div class="card-body">
              <table id="customTable" class="table table-bordered table-hover">
                <thead class="table-primary">
                  <tr>
                    <th>코드</th>
                    <th>이름</th>
                    <th>전화</th>
                    <th>구분</th>
                    <th>대표</th>
                  </tr>
                </thead>
                <tbody>
                  <c:if test="${totCnt > 0}">
                    <c:forEach var="custom" items="${customList}">
                      <tr>
                        <td>${custom.cust_code}</td>
                        <td>
                          <a href="customContent.do?cust_code=${custom.cust_code}">
                            ${custom.cust_name}
                          </a>
                        </td>
                        <td>${custom.cust_tel}</td>
                        <td>${custom.cust_gubun}</td>
                        <td>${custom.cust_ceo}</td>
                      </tr>
                      <c:set var="startNum" value="${startNum - 1 }"></c:set>
                    </c:forEach>
                  </c:if>
                </tbody>
              </table>
              <ul class="pagination d-flex justify-content-center">
                <c:if test="${startPage > blockSize }">
                  <li class="page-item">
                    <a
                      class="page-link bg-primary text-white"
                      href="customList.do?pageNum=${startPage-blockSize}"
                      >이전</a
                    >
                  </li>
                </c:if>
                <c:forEach var="i" begin="${startPage}" end="${endPage}">
                  <li class="page-item">
                    <a class="page-link" href="customList.do?pageNum=${i}"
                      >${i }</a
                    >
                  </li>
                </c:forEach>
                <c:if test="${endPage < pageCnt }">
                  <li class="page-item">
                    <a
                      class="page-link bg-primary text-white"
                      href="customList.do?pageNum=${startPage + blockSize}"
                      >다음</a
                    >
                  </li>
                </c:if>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <%@ include file="component/footer.jsp" %>
  </body>
</html>
