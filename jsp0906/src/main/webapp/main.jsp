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
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <%@ include file="component/header.jsp" %>
    <section
      id="slider"
      class="carousel slide carousel-fade"
      data-bs-ride="carousel"
      data-bs-touch="true"
    >
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="images/rio.png" alt="" class="d-block w-100" />
        </div>
        <div class="carousel-item">
          <img src="images/naples.png" alt="" class="d-block w-100" />
        </div>
        <div class="carousel-item">
          <img src="images/sydney.png" alt="" class="d-block w-100" />
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#slider"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon"></span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#slider"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon"></span>
      </button>
    </section>
    <section id="content">
      <div class="container bg-primary">
        <h1>MAIN Body</h1>
        <p>메인페이지 공사중</p>
      </div>
    </section>
    <%@ include file="component/footer.jsp" %>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
