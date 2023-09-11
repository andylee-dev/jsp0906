package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.SawonDao;
import dto.Sawon;

public class SawonListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			SawonDao sd = SawonDao.getInstance();
			List<Sawon> sawonList = sd.list();
			
			request.setAttribute("sawonList", sawonList);
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		}
		return "sawonList.jsp";
	}

}
