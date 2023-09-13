package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.ItemDao;
import dto.Item;

public class ItemContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			int item_code = Integer.parseInt(request.getParameter("item_code"));
			ItemDao itemDao = ItemDao.getInstance();
			Item item = itemDao.select(item_code);
			
			request.setAttribute("item", item);
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		}
		return "itemContent.jsp";
	}

}
