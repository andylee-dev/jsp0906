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
            <h2 class="card-title p-3">주문 정보</h2>
            <div class="card-body">
	            <div id="content1">
	              <table id="orderTable" class="table table-bordered table-hover">
	                <thead class="table-primary">
	                  <tr>
	                    <th>주문일자</th>
	                    <th>거래처명</th>
	                    <th>주문내용</th>
	                    <th>접수사원</th>
	                  </tr>
	                </thead>
	                <tbody>
					  <tr><td>${order.order_date}</td> 
				        <td>${order.cust_code} ${order.cust_name}</td> 
				        <td>${order.order_desc}</td> 
				        <td>${order.sabun} ${order.sawon_name}</td> 
					  </tr>
	                </tbody>
	              </table>
	            </div>
	            <div id="content2">
		            <h3>주문 상세 추가 입력</h3>
		            <form action="orderDetailWritePro.do" method="post">
	      			  <input type="hidden" name="order_date" value="${order.order_date}">
					  <input type="hidden" name="cust_code"   value="${order.cust_code}">
	            	  <input type="hidden" name="order_status" value="0">
		              <div class="form-group p-2 justify-content-center">
			              <table id="orderTable" class="table table-bordered table-hover">
			                <thead class="table-primary">
			                  <tr>
								<th>제품</th><th>제품주문내용</th><th>제품수량</th><th>상세 추가 입력</th>
			                  </tr>
			                </thead>
			                <tbody>
								<tr>
								  <td class="left">
								     <select name="item_code" required="required">
									    <c:forEach var="item" items="${itemList }">
				                           <option value="${item.item_code}">${item.item_name}</option>						
				                        </c:forEach>
									 </select>
								   </td>
				   				   <td class="left"><input type="text" name="item_order_desc" value="" required="required"></td>
								   <td class="left"><input type="text" name="item_count"      value="1" required="required"></td>
						           <td class="left"><input type="submit" value="거래처제품 추가등록"></td>
								</tr>
			                </tbody>
			              </table>						
		              </div>
	                </form>	
	            </div>
	            <div id="content3">
	  	    <h3>주문 상세 리스트</h3>
            <table id="orderTable" class="table table-bordered table-hover">
               <thead class="table-primary">
		 		<tr>
					<th>제품코드</th><th>제품명</th><th>제품주문내용</th><th>제품수량</th>
				</tr>
				</thead>
                <tbody>
				
				    <c:forEach var="orderDetail" items="${orderDetailList }">
				        <tr>
						    <td class="left">${orderDetail.item_code }</td>  
							<td class="left">
								 <a href='orderDetailContent.do?order_date=${orderDetail.order_date}&cust_code=${orderDetail.cust_code}'>
									${orderDetail.item_name }</a>
							</td>
							<td class="left">${orderDetail.item_order_desc}</td>
							<td class="left">${orderDetail.item_count}</td>
						</tr>
					</c:forEach>
					</tbody>
		    </table>	
	            </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <%@ include file="component/footer.jsp" %>
  </body>
</html>
