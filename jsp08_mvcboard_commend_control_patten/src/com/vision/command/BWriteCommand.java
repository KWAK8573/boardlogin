package com.vision.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.vision.bean.MvcBoard;
import com.vision.common.MBUtils;
import com.vision.dao.MvcBoardDAO;

public class BWriteCommand implements bCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
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
		mysession.close();
		

	}

}
