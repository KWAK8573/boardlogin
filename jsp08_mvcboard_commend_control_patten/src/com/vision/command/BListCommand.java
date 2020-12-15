package com.vision.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.vision.bean.MvcBoard;
import com.vision.common.MBUtils;
import com.vision.dao.MvcBoardDAO;

public class BListCommand implements bCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		SqlSession mysession = MBUtils.getSession();
		MvcBoardDAO dao = mysession.getMapper(MvcBoardDAO.class);
		List<MvcBoard> beans = dao.list();
		request.setAttribute("list", beans);

	}

}
