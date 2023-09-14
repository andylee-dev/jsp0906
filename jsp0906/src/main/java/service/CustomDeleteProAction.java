package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.CustomDao;

public class CustomDeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			int cust_code = Integer.parseInt(request.getParameter("cust_code"));

			CustomDao customDao = CustomDao.getInstance();
			int result = customDao.delete(cust_code);
			request.setAttribute("result", result);
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		}
		return "customDeletePro.jsp";
	}

}
