package pj.xuanbao.controllers;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pj.xuanbao.models.UserModel;
import pj.xuanbao.services.IUserServices;
import pj.xuanbao.services.impl.UserServicesImpl;
import pj.xuanbao.ultis.Constant;

@WebServlet(urlPatterns = {"/login"})

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserServices service = new UserServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * HttpSession session = req.getSession(false); if (session != null &&
		 * session.getAttribute("account") != null) {
		 * resp.sendRedirect(req.getContextPath() + "/waiting"); return; } // Check
		 * cookie Cookie[] cookies = req.getCookies(); if (cookies != null) { for
		 * (Cookie cookie : cookies) { if (cookie.getName().equals("username")) {
		 * session = req.getSession(true); session.setAttribute("username",
		 * cookie.getValue()); resp.sendRedirect(req.getContextPath() + "/waiting");
		 * return; } } }
		 */
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// mã hóa UTF-8
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		// lấy tham số từ view
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("rememberme");

		// Xử lý bài toán
		String alertMsg = "";
		boolean isRememberMe = false;
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		UserModel user = service.login(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);

		}
	}

	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}
}