package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

public interface CommandProcess {
	public String requestPro(HttpServletRequest request, 
							HttpServletResponse response
							)
							throws SerialException,IOException;
}
//System.out.println(getClass().getName()+"-requestPro Start");
//try {
//
//
//} catch (Exception e) {
//	System.out.println("[ERROR]"+getClass().getName()+":"+e.getMessage());
//}