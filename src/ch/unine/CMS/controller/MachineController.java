package ch.unine.CMS.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch.unine.CMS.model.MachineBean;
import ch.unine.CMS.model.MachineKindBean;
import ch.unine.CMS.model.SessionFactoryUtil;

/**
 * Servlet implementation class MachineController
 */
public class MachineController extends HttpServlet {
	private static final long serialVersionUID 			= 1L;
	private static final String CREATE_MACHINE_KIND_FCT = "createMachineKind";
	private static final String CREATE_MACHINE_FCT 		= "createMachine";
	private static final String START_MACHINE_FCT 		= "startMachine";
	private static final String STOP_MACHINE_FCT 		= "stopMachine";
       
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
		String o;
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
			Long machineKindId 	= new Long(request.getParameter("machineKind"));
			String ip			=  request.getParameter("ip");
			//Get hibernate session
			Session sessionHibernate =  SessionFactoryUtil.getInstance().getCurrentSession();
			
			//Begin transaction
			Transaction tx = sessionHibernate.beginTransaction();
		      
			MachineBean m	= new MachineBean();
			m.setIP(ip);
			m.setMachineKindId(machineKindId);
			sessionHibernate.save(m);
			//close transaction
			tx.commit();
			
			PrintWriter out = response.getWriter();
			
    		out.print("OK");
    		out.close();
		}else if(op.equals(START_MACHINE_FCT)){
			//TODO
		}else if(op.equals(STOP_MACHINE_FCT)){
			//TODO
		}
		
	}
}
