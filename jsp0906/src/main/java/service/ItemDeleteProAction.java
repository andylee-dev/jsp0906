package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.ItemDao;

public class ItemDeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName() + "-requestPro Start");
		try {
			int item_code = Integer.parseInt(request.getParameter("item_code"));

			ItemDao itemDao = ItemDao.getInstance();
			int result = itemDao.delete(item_code);
			request.setAttribute("result", result);

		} catch (Exception e) {
			System.out.println("[ERROR]" + getClass().getName() + ":" + e.getMessage());
		}
		return "itemDeletePro.jsp";
	}

}
