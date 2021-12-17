package com.dim.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Course;
import com.dim.hibernate.demo.entity.Instructor;
import com.dim.hibernate.demo.entity.InstructorDetail;


public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);
			List<Course> courses = instructor.getCousrses();
			for(Course course:courses) {
				System.out.println(course);
			}
			session.getTransaction().commit();
		
		}finally{
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
