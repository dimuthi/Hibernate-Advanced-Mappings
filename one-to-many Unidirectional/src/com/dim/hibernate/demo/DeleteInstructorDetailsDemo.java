package com.dim.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Instructor;
import com.dim.hibernate.demo.entity.InstructorDetail;


public class DeleteInstructorDetailsDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			//start transaction
			session.beginTransaction();
			int theId= 5;
			InstructorDetail tempInstrdetail = session.get(InstructorDetail.class, theId);
		
			System.out.println(tempInstrdetail.getInstructor());
			session.delete(tempInstrdetail);
			//commit transaction
			session.getTransaction().commit();
		}finally{
			sessionFactory.close();
		}
		
	}

}
