package com.dim.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Course;
import com.dim.hibernate.demo.entity.Instructor;
import com.dim.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Susan","Public","susa@gmail.com");
			InstructorDetail insdetail = new InstructorDetail("http//youtube/love2code","Stamps");
			instructor.setInstructorDetail(insdetail);
			//start transaction
			
			session.beginTransaction();
			
			session.save(instructor);
			System.out.println("commiting");
			//commit transaction
			session.getTransaction().commit();
			
		}finally{
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
