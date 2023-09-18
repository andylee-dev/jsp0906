<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
    <section id="customContent" class="p-5 m-5">
      <div class="container">
        <div class="row justify-content-center">
          <div class="card col-md-4 col-lg-5 text-center">
            <h2 class="card-title p-3">고객 상세내역</h2>
            <table class="table table-bordered table-hover">
              <tr>
                <th>코드</th>
                <td>${custom.cust_code }</td>
              </tr>
              <tr>
                <th>이름</th>
                <td>${custom.cust_name}</td>
              </tr>
              <tr>
                <th>전화</th>
                <td>${custom.cust_tel}</td>
              </tr>
              <tr>
                <th>구분</th>
                <td>${custom.cust_gubun}</td>
              </tr>
              <tr>
                <th>대표</th>
                <td>${custom.cust_ceo}</td>
              </tr>

              <tr>
                <td colspan="2">
                  <div
                    class="btn-group"
                    role="group"
                    aria-label="Basic example"
                  >
                    <input
                      type="button"
                      value="수정"
                      class="btn btn-primary"
                      onclick="location.href='customUpdateForm.do?cust_code=${custom.cust_code}'"
                    />
                    <input
                      type="button"
                      value="삭제"
                      class="btn btn-danger"
                      onclick="location.href='customDeleteForm.do?cust_code=${custom.cust_code}'"
                    />
                    <input
                      type="button"
                      value="목록"
                      class="btn btn-success"
                      onclick="location.href='customList.do?pageNum=${pageNum}'"
                    />
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
