package com.vision.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface bCommand {
	public void excute(HttpServletRequest request, HttpServletResponse response);
}
