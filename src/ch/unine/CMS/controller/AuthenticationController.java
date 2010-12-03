package ch.unine.CMS.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch.unine.CMS.model.SessionFactoryUtil;
import ch.unine.CMS.model.UserBean;

/**
 * Servlet implementation class AuthenticationController
 */
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String LOGIN_TS = "loginTS";
	
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
			return;
		}else{
			Calendar aCal = Calendar.getInstance();
			aCal.setTime((Date)session.getAttribute(LOGIN_TS));
			aCal.add(Calendar.SECOND,10);
			aCal.toString();
			
			if(aCal.before(new Date())){
				response.sendRedirect(LOGIN_PAGE);
				return;
			}
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
		Transaction tx;
		Session sessionHibernate =  SessionFactoryUtil.getInstance().getCurrentSession();
		
		tx = sessionHibernate.beginTransaction();
		List<UserBean> userList = sessionHibernate.createQuery("select h from Honey as h").list();
		
		//Session inscription
		session.setAttribute(LOGIN_NAME, login);
		session.setAttribute(LOGIN_TS, new Date());
		//response.sendError(0);
		PrintWriter out = response.getWriter();
		out.print("OK");
		out.close();
	}

}