package com.hwh.test;

import static org.junit.Assert.*;

import javax.persistence.*;

import org.junit.*;

import com.hwh.model.Student;

public class JpaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void createTable(){
		//������֤���ɱ��Ƿ���ȷ
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		factory.close();
	}

	@Test
	public void save(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = new Student(); //StudentΪnew״̬
		student.setName("zhang san");
		student.setAge(10);
		em.persist(student); //�־û�ʵ��
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	//new ���йܡ��ѹܡ�ɾ��
	@Test 
	public void update(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		student.setName("hmk"); //StudentΪ�й�״̬
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test
	public void update2(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		em.clear(); //��ʵ��������е�����ʵ���Ϊ�ѹ�״̬
		student.setName("hmk2");
		em.merge(student); //���ѹ�״̬��Ϊ�й�״̬,merge�����Զ�ѡ��insert or update ����
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test public void remove(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		em.remove(student); //ɾ��ʵ��
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test public void find(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		Student student = em.find(Student.class, 2); //������hibernate��get����,û�ҵ�����ʱ������null
		System.out.println(student.getName());
		em.close();
		factory.close();
	}
	@Test public void find2(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		Student student = em.getReference(Student.class, 2); //������hibernate��load����,�ӳټ���.û��Ӧ����ʱ������쳣
		System.out.println(student.getName()); //��������ʱ�Ų�������
		em.close();
		factory.close();
	}

}
