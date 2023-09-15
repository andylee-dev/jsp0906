package service;

import java.io.IOException;

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
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			request.setCharacterEncoding("utf-8");

			Order1 order = new Order1();
			order.setOrder_date(request.getParameter("order_date"));
			order.setCust_name(request.getParameter("cust_name"));
			order.setOrder_desc((request.getParameter("order_desc")));
//			order.setCust_code(Integer.parseInt(request.getParameter("cust_code")));
//			order.setSabun(Integer.parseInt(request.getParameter("sabun")));
			order.setSawon_name(request.getParameter("sawon_name"));
			order.setOrder_status(request.getParameter("order_statu"));
			
			Order1Dao orderDao = Order1Dao.getInstance();
			int result = orderDao.insert(order);

//			request.setAttribute("cust_code", custom.getCust_code());
			request.setAttribute("result", result);		
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		} finally{
			System.out.println(getClass().getName()+"-requestPro end");
		}		
		return "orderInsertPro.jsp";
	}

}
