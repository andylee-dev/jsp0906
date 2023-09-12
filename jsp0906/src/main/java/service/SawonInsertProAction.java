package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.SawonDao;
import dto.Sawon;

public class SawonInsertProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			request.setCharacterEncoding("utf-8");

			Sawon sawon = new Sawon();
			sawon.setName(request.getParameter("name"));
			sawon.setSal(Integer.parseInt(request.getParameter("sal")));
			sawon.setHandphone(request.getParameter("handphone"));
			
			SawonDao sd = SawonDao.getInstance();
			int result = sd.insert(sawon);

			request.setAttribute("sabum", sawon.getSabun());
			request.setAttribute("result", result);

			
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		}
		return "sawonInsertPro.jsp";
	}

}
