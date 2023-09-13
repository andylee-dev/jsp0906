package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.ItemDao;
import dto.Item;

public class ItemUpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			request.setCharacterEncoding("utf-8");
			
			Item item = new Item();
			item.setItem_code(Integer.parseInt(request.getParameter("item_code")));
			item.setItem_name(request.getParameter("item_name"));
			item.setItem_price(Integer.parseInt(request.getParameter("item_price")));		
			item.setItem_kind(request.getParameter("item_kind"));
			item.setItem_desc(request.getParameter("item_desc"));
			
			ItemDao itemDao = ItemDao.getInstance();
			int result = itemDao.update(item);
			request.setAttribute("item_code", item.getItem_code());
			request.setAttribute("result", result);
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		} finally{
			System.out.println(getClass().getName()+"-requestPro end");
		}
		return "itemUpdatePro.jsp";
	}

}
