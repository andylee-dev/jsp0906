package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.CustomDao;
import dto.Custom;

public class CustomInsertProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			request.setCharacterEncoding("utf-8");

			Custom custom = new Custom();
			custom.setCust_name(request.getParameter("cust_name"));
			custom.setCust_tel(request.getParameter("cust_tel"));
			custom.setCust_gubun(request.getParameter("cust_gubun"));
			custom.setCust_ceo(request.getParameter("cust_ceo"));
			
			CustomDao customDao = CustomDao.getInstance();
			int result = customDao.insert(custom);

			request.setAttribute("cust_code", custom.getCust_code());
			request.setAttribute("result", result);		
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		} finally{
			System.out.println(getClass().getName()+"-requestPro end");
		}		
		return "customInsertPro.jsp";
	}

}
