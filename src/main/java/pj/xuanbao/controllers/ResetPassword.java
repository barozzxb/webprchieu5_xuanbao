package pj.xuanbao.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pj.xuanbao.services.IUserServices;
import pj.xuanbao.services.impl.UserServicesImpl;

@WebServlet(urlPatterns= {"/resetpassword"})
public class ResetPassword extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUserServices service = new UserServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// mã hóa UTF-8
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		// lấy tham số từ view
		String email = req.getParameter("email");
		String password = req.getParameter("newpass");
		String repassword = req.getParameter("re-newpass");
		// Xử lý bài toán
		String alertMsg = "";
				
		if (email.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
			alertMsg = "Please fill out the fields!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
			return;
		}
		if (!password.equals(repassword)) {
			alertMsg = "The password you re-entered is not match!";
			req.setAttribute("alert", alertMsg);
		}
		if (service.checkExistEmail(email)) {
			//HttpSession session = req.getSession(true);
			service.resetPassword(email, password);
		} else {
			alertMsg = "The email does not exist";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);

		}
	}
}
