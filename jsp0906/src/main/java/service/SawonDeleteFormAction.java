package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.SawonDao;
import dto.Sawon;

public class SawonDeleteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			int sabun = Integer.parseInt(request.getParameter("sabun"));
			SawonDao sd = SawonDao.getInstance();
			Sawon sawon =sd.select(sabun);
			request.setAttribute("sawon", sawon);
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		}
		return "sawonDeleteForm.jsp";
	}

}
