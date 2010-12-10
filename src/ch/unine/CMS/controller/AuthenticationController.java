package ch.unine.CMS.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ch.unine.CMS.model.*;



/**
 * Servlet implementation class AuthenticationController
 */
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String getUserLogin(String login, String password) {
		return "FROM UserBean u WHERE u.login = " + login + " AND  u.passwd = " + password;
	}

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
			
			if(aCal.before(Calendar.getInstance()) ){
				System.out.println(aCal);
				response.sendRedirect(LOGIN_PAGE);
				return;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get current session
		HttpSession session = request.getSession();
		//Result (login) declaration
		boolean result 		= false;
		//capturing parameters (login and password)
		String login 		= request.getParameter("login");
		String password 	= request.getParameter("passwd");
		
		//Get hibernate session
		Session sessionHibernate =  SessionFactoryUtil.getInstance().getCurrentSession();
		//Begin transaction
		Transaction tx = sessionHibernate.beginTransaction();
		//Create query
		Criteria crit = sessionHibernate.createCriteria(UserBean.class);
		crit.add( Restrictions.eq( "login", login ) );
		crit.add( Restrictions.eq( "passwd", password ) );
		crit.setMaxResults(1);
		List cats = crit.list();
		//end transaction
		tx.commit();
		//Iterate answer
        for (Iterator it = cats.iterator(); it.hasNext();) {
        	UserBean user = (UserBean) it.next();
        	//Session inscription
    		session.setAttribute(LOGIN_NAME, login);
    		session.setAttribute(LOGIN_TS, new Date());
    		PrintWriter out = response.getWriter();
    		out.print("OK");
    		out.close();
    		return;
        }
		
        
	}


}