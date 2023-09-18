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
    <section id="customUpdate" class="pb-md-5 pb-3 pt-3">
      <div class="container">
        <div class="row justify-content-center">
          <div class="card col-md-4 col-lg-5 text-center">
            <h2 class="card-title p-3">고객 정보 수정</h2>
            <form action="customUpdatePro.do" method="post">
              <div class="form-group">
                <input
                  type="hidden"
                  name="cust_code"
                  value="${custom.cust_code}"
                />
                <table class="table table-bordered table-hover align-middle">
                  <tr>
                    <th>사번</th>
                    <td>${custom.cust_code}</td>
                  </tr>
                  <tr>
                    <th>이름</th>
                    <td>
                      <input
                        type="text"
                        name="cust_name"
                        required="required"
                        class="form-control"
                        aria-label="Default"
                        aria-describedby="inputGroup-sizing-default"
                        value="${custom.cust_name}"
                      />
                    </td>
                  </tr>
                  <tr>
                    <th>전화</th>
                    <td>
                      <input
                        type="tel"
                        name="cust_tel"
                        required="required"
                        class="form-control"
                        aria-label="Default"
                        aria-describedby="inputGroup-sizing-default"
                        value="${custom.cust_tel}"
                      />
                    </td>
                  </tr>
                  <tr>
                    <th>구분</th>
                    <td>
                      <input
                        type="text"
                        name="cust_gubun"
                        required="required"
                        class="form-control"
                        aria-label="Default"
                        aria-describedby="inputGroup-sizing-default"
                        value="${custom.cust_gubun}"
                      />
                    </td>
                  </tr>
                  <tr>
                    <th>대표</th>
                    <td>
                      <input
                        type="text"
                        name="cust_ceo"
                        required="required"
                        class="form-control"
                        aria-label="Default"
                        aria-describedby="inputGroup-sizing-default"
                        value="${custom.cust_ceo}"
                      />
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2">
                      <div
                        class="btn-group"
                        role="group"
                        aria-label="Basic example"
                      >
                        <input
                          type="submit"
                          value="확인"
                          class="btn btn-primary"
                        />
                        <input
                          type="reset"
                          value="다시작성"
                          class="btn btn-danger"
                        />
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
