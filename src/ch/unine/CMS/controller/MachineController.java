package ch.unine.CMS.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch.unine.CMS.model.MachineKindBean;
import ch.unine.CMS.model.SessionFactoryUtil;

/**
 * Servlet implementation class MachineController
 */
public class MachineController extends HttpServlet {
	private static final long serialVersionUID 			= 1L;
	private static final String CREATE_MACHINE_KIND_FCT = "createMachineKind";
	private static final Object CREATE_MACHINE_FCT 		= "createMachine";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MachineController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//capuring operation 
		String op = request.getParameter("fct");
		
		if(op.equals(CREATE_MACHINE_KIND_FCT)){
			String name 		= request.getParameter("name");
			String description 	= request.getParameter("description");
			
			//Get hibernate session
			Session sessionHibernate =  SessionFactoryUtil.getInstance().getCurrentSession();
			//Begin transaction
			Transaction tx = sessionHibernate.beginTransaction();
		      
			MachineKindBean m	= new MachineKindBean();
			m.setName(name);
			m.setDescription(description);
			sessionHibernate.save(m);
			//close transaction
			tx.commit();
			
			PrintWriter out = response.getWriter();
			
    		out.print("OK");
    		out.close();
    		return;
    		
		}else if(op.equals(CREATE_MACHINE_FCT)){
			
		}
		
	}
}
