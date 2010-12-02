package ch.unine.CMS.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthenticationController
 */
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private String LOGIN_PAGE = "login.jsp";
	 
	 private String LOGIN_NAME = "loginName";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN_NAME) == null){
			response.sendRedirect(LOGIN_PAGE);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login 	= request.getParameter("login");
		String password = request.getParameter("passwd");
		
		//TODO user and password verification
		
		//Session inscription
		session.setAttribute(LOGIN_NAME, login);
		
		//response.sendError(0);
		PrintWriter out = response.getWriter();
		out.print("OK");
		out.close();
	}

}