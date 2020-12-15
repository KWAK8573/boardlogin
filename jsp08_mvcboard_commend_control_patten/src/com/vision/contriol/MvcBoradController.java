package com.vision.contriol;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.vision.command.BListCommand;
import com.vision.command.BWriteCommand;
import com.vision.command.bCommand;


/**
 * Servlet implementation class MvcBoradController
 */
@WebServlet(description = "웹을컨트롤하는서블릿", urlPatterns = { "*.do" })
public class MvcBoradController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MvcBoradController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 주의
		String uri = request.getRequestURI(); // 프로토콜 + 도메인 + 기타
		String contextPath = request.getContextPath(); // 기타
		String command = uri.substring(contextPath.length()); // xxxxxx.do
		bCommand bcommand = null;
		String viewPage = null;
		
		
		if(command.equals("/write.do")) {
			bcommand = new BWriteCommand();
			bcommand.excute(request, response);
			// DB 작업끝내고 다른화면 전환
			viewPage = "list.do";
			
			
		}else if (command.equals("/list.do")) {
			bcommand = new BListCommand();
			bcommand.excute(request, response);
			viewPage = "list.jsp";
			
		}
		
		// 교통순경(배차계)
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
