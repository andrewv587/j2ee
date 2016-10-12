package com.hwh.test;

import static org.junit.Assert.*;

import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.hwh.model.Group;
import com.hwh.model.User;



public class ORMTest {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

	@Test
	public void schemaExport() {
		// 默认读取hibernate.cfg.xml文件    
		Configuration cfg = new Configuration().configure();
		SchemaExport schemaExport= new SchemaExport(cfg);
		schemaExport.create(false, false);

/*		Session session=sessionFactory.openSession();
		
		session.beginTransaction();

		session.getTransaction().commit();
		session.close();*/
	}
	
	@Test
	public void testManyToOne(){
		User user=new User();
		user.setName("abcd");
		Group group=new Group();
		group.setId(7);
		group.setName("ddddd");
		user.setGroup(group);
		Session session=sessionFactory.openSession();
		session.save(group);
		session.save(user);
		session.beginTransaction();

		session.getTransaction().commit();
		session.close();
	}
	

	
}
