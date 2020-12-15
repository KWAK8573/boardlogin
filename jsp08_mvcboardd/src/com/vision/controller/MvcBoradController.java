package com.vision.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.vision.bean.MvcBoard;
import com.vision.common.MBUtils;
import com.vision.dao.MvcBoardDAO;

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
		
		if(command.equals("/write.do")) {
			String mId = request.getParameter("mId");
			String bTitle = request.getParameter("bTitle");
			String bContent = request.getParameter("bContent");
			// 마이바티스가 다오 부리는 작업
			SqlSession mysession = MBUtils.getSession();
			MvcBoardDAO dao = mysession.getMapper(MvcBoardDAO.class);
			MvcBoard bean = new MvcBoard();
			bean.setmId(mId);
			bean.setbTitle(bTitle);
			bean.setbContent(bContent);
			dao.write(bean);
			// DB 작업끝내고 다른화면 전환
			String viewPage = "list.do";
			// 교통순경( 배차계)
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
		}else if (command.equals("/list.do")) {
			SqlSession mysession = MBUtils.getSession();
			MvcBoardDAO dao = mysession.getMapper(MvcBoardDAO.class);
			List<MvcBoard> beans = dao.list();
			request.setAttribute("list", beans);
			String viewPage = "list.jsp";
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		System.out.println("개발중 ");
	}
}
