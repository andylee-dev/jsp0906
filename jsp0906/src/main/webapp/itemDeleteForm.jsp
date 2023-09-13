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
    <section id="itemDelete" class="pb-md-5 pb-3">
      <div class="container">
        <div class="row justify-content-center">
          <div class="card col-md-4 col-lg-5 text-center">
            <h4 class="card-title p-3">
              ${item.item_code}번의 "${item.item_name}" 제품을 삭제하시겠습니까?
            </h4>
            <form action="itemDeletePro.do" method="post">
              <input type="hidden" name="item_code" value="${item.item_code}" />
              <input type="submit" value="삭제" class="btn btn-danger" />
              <input
                type="button"
                value="취소"
                class="btn btn-primary"
                onclick="location.href='itemContent.do?sabun=${item.item_code}'"
              />
            </form>
          </div>
        </div>
      </div>
    </section>

    <%@ include file="component/footer.jsp" %>
  </body>
</html>
