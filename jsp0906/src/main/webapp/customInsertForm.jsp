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
    <section id="customInsert" class="p-5  m-5"">
      <div class="container">
        <div class="row justify-content-center">
          <div class="card col-md-4 col-lg-5 text-center">
            <h2 class="card-title p-3">고객 등록</h2>
            <form action="customInsertPro.do" method="post">
              <div class="form-group p-2 justify-content-center">
                <input type="hidden" name="cust_code" value="${custom.cust_code}" />
                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span
                      class="input-group-text"
                      id="inputGroup-sizing-default"
                      >고객 이름</span
                    >
                  </div>
                  <input
                    type="text"
                    name="cust_name"
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
                      >전화</span
                    >
                  </div>
                  <input
                    type="tel"
                    name="cust_tel"
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
                      >구분</span
                    >
                  </div>
                  <select name="cust_gubun" class="form-select" aria-label="Default select example" required="required">
					  <option value="0">0</option>
					  <option value="1">1</option>
					</select>
                </div>
                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span
                      class="input-group-text"
                      id="inputGroup-sizing-default"
                      >대표</span
                    >
                  </div>
                  <input
                    type="text"
                    name="cust_ceo"
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
