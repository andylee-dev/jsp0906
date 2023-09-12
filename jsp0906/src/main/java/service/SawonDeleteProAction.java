package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.SawonDao;

public class SawonDeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			int sabun = Integer.parseInt(request.getParameter("sabun"));

			SawonDao sd = SawonDao.getInstance();
			int result = sd.delete(sabun);
			request.setAttribute("result", result);
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		}
		return "sawonDeletePro.jsp";
	}

}
