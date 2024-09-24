package pj.xuanbao.controllers;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pj.xuanbao.models.UserModel;
import pj.xuanbao.services.IUserServices;
import pj.xuanbao.services.impl.UserServicesImpl;

@WebServlet(urlPatterns= {"/myaccount"})
public class MyAccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserServices service = new UserServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) 
        	{
            req.getRequestDispatcher("/views/myaccount.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
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
				String fullname = req.getParameter("fullname");
				String image = req.getParameter("image");
				String email = req.getParameter("email");
				String phone = req.getParameter("phone");
				int roleid = Integer.parseInt(req.getParameter("role"));
				

				UserModel user = new UserModel(username, password, fullname, image, email, phone, roleid);
				// Xử lý bài toán
				String alertMsg = "";
				boolean updated = service.update(user);
				if (updated == true) {
					alertMsg = "Cap nhat thanh cong";
					req.setAttribute("alert", alertMsg);
					//req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
					resp.sendRedirect("home");
				}
	}
}
