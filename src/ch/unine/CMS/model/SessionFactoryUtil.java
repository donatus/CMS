package ch.unine.CMS.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import org.hibernate.tool.hbm2ddl.SchemaExport;



@SuppressWarnings("deprecation")
public class SessionFactoryUtil {
	
	static {
        try {
            // Create the SessionFactory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            //log.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

  /** The single instance of hibernate SessionFactory */
  public static org.hibernate.SessionFactory sessionFactory;

	/**
	 * disable contructor to guaranty a single instance
	 */

	public SessionFactoryUtil(){
// Annotation and XML
//		AnnotationConfiguration config = new AnnotationConfiguration();
//		config.addAnnotatedClass(EventBean.class);
//		config.addAnnotatedClass(EventHasMachineBean.class);
//		config.addAnnotatedClass(MachineBean.class);
//		config.addAnnotatedClass(MachineKindBean.class);
//		config.addAnnotatedClass(UserBean.class);
//		config.configure();
//		new SchemaExport(config).create(true, true);
//		sessionFactory = config.buildSessionFactory();
// XML only
		//sessionFactory = new Configuration().configure().buildSessionFactory();
  }
	
	public static final ThreadLocal session = new ThreadLocal();
    
    public static Session currentSession() {
        Session s = (Session) session.get();
        // Open a new Session, if this Thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }
    
    public static void closeSession() {
        Session s = (Session) session.get();
        if (s != null)
            s.close();
        session.set(null);
    }
    
	public static SessionFactory getInstance() {
		return sessionFactory;
	}

  /**
   * Opens a session and will not bind it to a session context
   * @return the session
   */
	public Session openSession() {
		return sessionFactory.openSession();
	}

	/**
   * Returns a session from the session context. If there is no session in the context it opens a session,
   * stores it in the context and returns it.
	 * This factory is intended to be used with a hibernate.cfg.xml
	 * including the following property <property
	 * name="current_session_context_class">thread</property> This would return
	 * the current open session or if this does not exist, will create a new
	 * session
	 * 
	 * @return the session
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

  /**
   * closes the session factory
   */
	public static void close(){
		if (sessionFactory != null)
			sessionFactory.close();
		sessionFactory = null;
	}
}
