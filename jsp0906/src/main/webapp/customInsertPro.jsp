<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <c:if test="${result > 0 }">
      <script type="text/javascript">
        alert("입력완료 ^^");
        location.href = "main.do?pageNum=${pageNum}";
      </script>
    </c:if>
    <c:if test="${result == 0 }">
      <script type="text/javascript">
        alert("오류야 T.T");
        location.href = "custInsertForm.do?cust_code=${cust_code}&pageNum=${pageNum}";
      </script>
    </c:if>
  </body>
</html>