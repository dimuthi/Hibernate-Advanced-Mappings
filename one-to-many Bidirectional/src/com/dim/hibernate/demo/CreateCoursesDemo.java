package com.dim.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Course;
import com.dim.hibernate.demo.entity.Instructor;
import com.dim.hibernate.demo.entity.InstructorDetail;


public class CreateCoursesDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			Course course1 = new Course("Maths");
			Course course2 = new Course("English");
			Course course3 = new Course("Science");
			
			//start transaction
			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			instructor.add(course1);
			instructor.add(course2);
			instructor.add(course3);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally{
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
