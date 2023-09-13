package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.ItemDao;
import dao.SawonDao;
import dto.Item;
import dto.Sawon;

public class ItemListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		System.out.println(getClass().getName()+"-requestPro Start");
		try {
			ItemDao itemDao = ItemDao.getInstance();
			int totCnt = itemDao.getTotalCnt();
			request.setAttribute("totCnt", totCnt);
	
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null || pageNum.equals("")) { pageNum = "1";}
			int currentPage = Integer.parseInt(pageNum);
			int pageSize = 10, blockSize = 10;
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int startNum = totCnt - startRow + 1;
			
			//조회
			List<Item> itemList = itemDao.list(startRow,endRow);
			int pageCnt = (int)Math.ceil((double)totCnt/pageSize);
			int startPage = (int)(currentPage - 1 )/blockSize*blockSize + 1;
			int endPage = startPage + blockSize -1;
			// 공갈 Page방지 10 > 4
			if (endPage > pageCnt) endPage = pageCnt;
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("itemList", itemList);
		
		} catch (Exception e) {
			System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
		} finally{
			System.out.println(getClass().getName()+"-requestPro end");
		}
		return "itemList.jsp";
	}

}
