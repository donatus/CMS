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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import ch.unine.CMS.model.EventBean;
import ch.unine.CMS.model.EventBeanTest;
import ch.unine.CMS.model.EventHasMachineBean;
import ch.unine.CMS.model.MachineBean;
import ch.unine.CMS.model.MachineKindBean;
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
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(EventBean.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session sess = factory.getCurrentSession();
		sess.beginTransaction();
		EventBean event1 = new EventBean();
		event1.setDescription("Hello");
		event1.setId(100);
		event1.setName("first");
		sess.save(event1);
		sess.getTransaction().commit();
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
		//Session sessionHibernate =  SessionFactoryUtil.getInstance().getCurrentSession();
		
		
		//Session inscription
		session.setAttribute(LOGIN_NAME, login);
		session.setAttribute(LOGIN_TS, new Date());
		//response.sendError(0);
		PrintWriter out = response.getWriter();
		out.print("OK");
		out.close();
	}

}