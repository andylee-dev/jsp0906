package control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

/**
 * Servlet implementation class Controller
 */
//@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, Object> commandMap = new HashMap<String, Object>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어온다.
		String props = config.getInitParameter("config");
		System.out.println("1. init String props=> "+ props);
		Properties pr = new Properties();
		FileInputStream f = null;
		try {
			String configFilePath = config.getServletContext().getRealPath(props);
			System.out.println("2. init String configFilePath=> " + configFilePath);			
			f = new FileInputStream(configFilePath);
			
			// Memory Up
			pr.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( f != null )
				try {
					f.close();
				}catch (IOException ex) {}
		}
		Iterator keyIter = pr.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String className = pr.getProperty(command);
			System.out.println("3. init Command=>"+ command);
			System.out.println("4. init className=>"+ className);

			try {
				// 문자열 -> service.ListAction가 class로 변신
				Class<?> commandClass = Class.forName(className);
				// service.ListAction가 Instance로 변신
				CommandProcess commandInstance = 
						(CommandProcess) commandClass.getDeclaredConstructor().newInstance();
				commandMap.put(command, commandInstance);
			} catch (Exception e) {
				e.printStackTrace();
			}//해당 문자열을 클래스로 만든다.
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		requestServletPro(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void requestServletPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandProcess com = null;
		String command = request.getRequestURI();
		System.out.println("1. requestServletPro command=> " +command);
		command = command.substring(request.getContextPath().length());
		System.out.println("2. requestServletPro command substring=> " + command);
		
		try {
			// service.ListAction Instance
			com = (CommandProcess) commandMap.get(command);
			System.out.println("3.requestServletPro command =>" + command);
			System.out.println("4.requestServletPro com =>" + com);
			// com --> service.ListAction@32a22787
			view = com.requestPro(request, response);
			System.out.println("5.requestServletPro view=> " + view);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		// Ajax Or NOT Ajax
		// 1.Ajax이면 
		if (command.contains("ajaxGet")) {
			System.out.println("ajaxGet String->"+command);
			String writer = (String)request.getAttribute("writer");
			PrintWriter pw = response.getWriter();
			pw.write(writer);
			pw.flush();
		// 2. Ajax 아닐때.
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
		
	}	
}
