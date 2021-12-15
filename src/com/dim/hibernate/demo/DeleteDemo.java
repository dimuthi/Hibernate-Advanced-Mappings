package com.dim.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Instructor;
import com.dim.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			
			int id = 1;
			//start transaction
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, id);
			session.delete(instructor);
			System.out.println("commiting");
			//commit transaction
			session.getTransaction().commit();
		}finally{
			sessionFactory.close();
		}
		
	}

}
