package com.project;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sendOtp")
public class SendOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email"); // email from form

		// Generate OTP
		String otp = OTPUtil.generateOtp();

		// Store OTP in session
		HttpSession session = request.getSession();
		session.setAttribute("otp", otp);

		// Send OTP to user email
		EmailSender.sendOtp(email, otp);

		response.sendRedirect("enterOtp.jsp");
	}
}
