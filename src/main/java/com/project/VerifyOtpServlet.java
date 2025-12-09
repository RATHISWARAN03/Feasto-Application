package com.project;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/verifyOtp")
public class VerifyOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userOtp = request.getParameter("otp");
		HttpSession session = request.getSession();
		String realOtp = (String) session.getAttribute("otp");

		if (userOtp.equals(realOtp)) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("invalidOtp.jsp");
		}
	}
}
