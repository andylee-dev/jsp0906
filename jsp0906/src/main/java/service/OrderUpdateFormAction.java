package service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.ItemDao;
import dao.Order1Dao;
import dao.Order1DetailDao;
import dto.Item;
import dto.Order1;
import dto.Order1Detail;

public class OrderUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName() + "-requestPro Start");
		try {
			String order_date = request.getParameter("order_date");
			int    cust_code   = Integer.parseInt(request.getParameter("cust_code"));
			
			Order1Dao orderDao = Order1Dao.getInstance();
			Order1 order = orderDao.select(order_date, cust_code);
			

			Order1DetailDao order1DetailDao = Order1DetailDao.getInstance();
			List<Order1Detail> orderDetailList = order1DetailDao.list(order_date, cust_code);

			
	        ItemDao itemDao = ItemDao.getInstance();
            List<Item> itemList = itemDao.list(0,-1);

//			/* Set Attribute */
			request.setAttribute("order_date"          , order_date);
			request.setAttribute("cust_code"            , cust_code);
			request.setAttribute("order"              , order);		
			request.setAttribute("itemList"            , itemList);		
			request.setAttribute("orderDetailList"     , orderDetailList);		
			
		} catch (Exception e) {
			System.out.println("[ERROR]" + getClass().getName() + ":" + e.getMessage());
		} finally {
			System.out.println(getClass().getName() + "-requestPro end");
		}
		return "orderDetailList.jsp";
	}

}
