package service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.CustomDao;
import dao.SawonDao;
import dto.Custom;
import dto.Sawon;

public class OrderInsertFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			
			/* Date to String */
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // ("yyyy-MM-dd HH:mm:ss");
			String order_date = format.format(date);
			
			/* Select Custom Name as a List*/
			CustomDao cd = CustomDao.getInstance();
			List<Custom> customList = cd.list(0, -1);
			
			
			/* Select Sawon Name as a List*/
			SawonDao sd = SawonDao.getInstance();
			List<Sawon> sawonList = sd.list(0, -1);

			request.setAttribute("order_date", order_date);
			request.setAttribute("customList", customList);
			request.setAttribute("sawonList", sawonList);
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		} finally{
			System.out.println(getClass().getName()+"-requestPro end");
		}
		return "orderInsertForm.jsp";
	}

}
