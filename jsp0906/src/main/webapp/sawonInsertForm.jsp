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
    <section id="sawonInsert" class="pb-md-5 pb-3">
      <div class="container">
        <div class="row justify-content-center">
          <div class="card col-md-4 col-lg-5 text-center">
            <h2 class="card-title p-3">회원 등록</h2>
            <form action="sawonInsertPro.do" method="post">
              <div class="form-group p-2 justify-content-center">
                <input type="hidden" name="sabun" value="${sawon.sabun}" />
                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span
                      class="input-group-text"
                      id="inputGroup-sizing-default"
                      >이름</span
                    >
                  </div>
                  <input
                    type="text"
                    name="name"
                    required="required"
                    class="form-control"
                    aria-label="Default"
                    aria-describedby="inputGroup-sizing-default"
                  />
                </div>
                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span
                      class="input-group-text"
                      id="inputGroup-sizing-default"
                      >급여</span
                    >
                  </div>
                  <input
                    type="number"
                    name="sal"
                    required="required"
                    class="form-control"
                    aria-label="Default"
                    aria-describedby="inputGroup-sizing-default"
                  />
                </div>
                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span
                      class="input-group-text"
                      id="inputGroup-sizing-default"
                      >핸드폰번호</span
                    >
                  </div>
                  <input
                    type="tel"
                    name="handphone"
                    required="required"
                    class="form-control"
                    aria-label="Default"
                    aria-describedby="inputGroup-sizing-default"
                  />
                </div>
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
