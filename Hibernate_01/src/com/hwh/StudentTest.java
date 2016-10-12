package com.hwh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentTest {
	public static void main(String[] args){
		Student student = new Student();
		student.setId(1);
		student.setAge(5);
		student.setName("abc");
		
		Teacher teacher=new Teacher();
		teacher.setId(4);
		teacher.setName("hwh");
		teacher.setTitle("normal");
		
		Configuration cfg = new Configuration(). //.addResource("hibernate.cfg.xml").
				configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(teacher);
		session.getTransaction().commit();
		session.close();
	}
}
