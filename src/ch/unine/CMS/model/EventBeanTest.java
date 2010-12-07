package ch.unine.CMS.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class EventBeanTest {
	
	public static void main(String[] args){
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(EventBean.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		EventBean event1 = new EventBean();
		event1.setDescription("Hello");
		event1.setId(100);
		event1.setName("first");
		session.save(event1);
		session.getTransaction().commit();
	}
}
