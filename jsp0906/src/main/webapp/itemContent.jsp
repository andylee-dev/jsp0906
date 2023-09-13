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
    <section id="itemContent" class="pb-md-5 pb-3">
      <div class="container">
        <div class="row justify-content-center">
          <div class="card col-md-4 col-lg-5 text-center">
            <h2 class="card-title p-3">아이템 상세내역</h2>
            <table class="table table-bordered table-hover">
              <tr>
                <th>코드</th>
                <td>${item.item_code }</td>
              </tr>
              <tr>
                <th>이름</th>
                <td>${item.item_name}</td>
              </tr>
              <tr>
                <th>가격</th>
                <td>${item.item_price}</td>
              </tr>
              <tr>
                <th>종류</th>
                <td>${item.item_kind}</td>
              </tr>
              <tr>
                <th>설명</th>
                <td>${item.item_desc}</td>
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
                      onclick="location.href='itemUpdateForm.do?item_code=${item.item_code}'"
                    />
                    <input
                      type="button"
                      value="삭제"
                      class="btn btn-danger"
                      onclick="location.href='itemDeleteForm.do?item_code=${item.item_code}'"
                    />
                    <input
                      type="button"
                      value="목록"
                      class="btn btn-success"
                      onclick="location.href='itemList.do?pageNum=${pageNum}'"
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
