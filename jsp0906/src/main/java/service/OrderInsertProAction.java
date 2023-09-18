package service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.tomcat.util.json.JSONParser;

import com.mysql.cj.xdevapi.JsonParser;

import dao.CustomDao;
import dao.Order1Dao;
import dto.Custom;
import dto.Order1;

public class OrderInsertProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName() + "-requestPro Start");
		try {
			request.setCharacterEncoding("utf-8");

			/* Date to String */
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // ("yyyy-MM-dd HH:mm:ss");
			String order_date = format.format(date);

			/* Set Order */
			Order1 order = new Order1();
			order.setOrder_date(order_date);
			order.setCust_code(Integer.parseInt(request.getParameter("cust_code")));
			order.setOrder_desc((request.getParameter("order_desc")));
			order.setSabun(Integer.parseInt(request.getParameter("sabun")));
			order.setOrder_status(request.getParameter("order_status"));

			/* Insert Process */
			Order1Dao orderDao = Order1Dao.getInstance();
			int result = orderDao.insert(order);

			/* Set Attribute */
			request.setAttribute("result", result);

		} catch (Exception e) {
			System.out.println("[ERROR]" + getClass().getName() + ":" + e.getMessage());
		} finally {
			System.out.println(getClass().getName() + "-requestPro end");
		}
		return "orderInsertPro.jsp";
	}

}
