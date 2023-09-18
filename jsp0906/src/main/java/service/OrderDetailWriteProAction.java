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
import dao.Order1DetailDao;
import dto.Custom;
import dto.Order1;
import dto.Order1Detail;

public class OrderDetailWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName() + "-requestPro Start");
		try {
			request.setCharacterEncoding("utf-8");

			String order_date      = request.getParameter("order_date");
			int    cust_code        = Integer.parseInt(request.getParameter("cust_code"));
			int    item_code       = Integer.parseInt(request.getParameter("item_code"));
			String item_order_desc = request.getParameter("item_order_desc");
			int    item_count       = Integer.parseInt(request.getParameter("item_count"));
//			System.out.println("OrderDetailWritePro order_date->"+order_date);
//			System.out.println("OrderDetailWritePro custcode->"+cust_code);
//			System.out.println("OrderDetailWritePro item_code->"+item_code);
//			System.out.println("OrderDetailWritePro item_order_desc->"+item_order_desc);
//			System.out.println("OrderDetailWritePro item_count->"+item_count);
			
			// 2. Order1DetailDao (DTO) 생성하고 Value Setting
			Order1Detail order1_detail = new Order1Detail();
			order1_detail.setOrder_date(order_date);
			order1_detail.setCust_code(cust_code);
			order1_detail.setItem_code(item_code);
			order1_detail.setItem_order_desc(item_order_desc);
			order1_detail.setItem_count(item_count);

			Order1DetailDao orderDetailDao = Order1DetailDao.getInstance();
			int result = orderDetailDao.insert(order1_detail);
	        request.setAttribute("result", result);
	        request.setAttribute("order_date", order_date);
	        request.setAttribute("cust_code", cust_code);


		} catch (Exception e) {
			System.out.println("[ERROR]" + getClass().getName() + ":" + e.getMessage());
		} finally {
			System.out.println(getClass().getName() + "-requestPro end");
		}
		return "orderUpdateForm.do";
	}

}
