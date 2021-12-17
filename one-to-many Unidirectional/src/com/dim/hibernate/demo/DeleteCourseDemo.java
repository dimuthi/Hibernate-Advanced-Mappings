package com.dim.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Course;
import com.dim.hibernate.demo.entity.Instructor;
import com.dim.hibernate.demo.entity.InstructorDetail;


public class DeleteCourseDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Course course = session.get(Course.class, 10);
			session.delete(course);
			session.getTransaction().commit();
		
		}finally{
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
