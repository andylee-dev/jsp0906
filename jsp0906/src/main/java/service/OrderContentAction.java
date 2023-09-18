package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.Order1Dao;
import dto.Order1;

public class OrderContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			String order_date = request.getParameter("order_date");
			int    cust_code   = Integer.parseInt(request.getParameter("cust_code"));			

			Order1Dao orderDao = Order1Dao.getInstance();
			Order1 order = orderDao.select(order_date, cust_code);

			request.setAttribute("order", order);		
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		} finally{
			System.out.println(getClass().getName()+"-requestPro end");
		}
		return "orderContent.jsp";
	}

}
