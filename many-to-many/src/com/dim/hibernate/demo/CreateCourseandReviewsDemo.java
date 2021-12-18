package com.dim.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Course;
import com.dim.hibernate.demo.entity.Instructor;
import com.dim.hibernate.demo.entity.InstructorDetail;
import com.dim.hibernate.demo.entity.Review;


public class CreateCourseandReviewsDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//start transaction
			
			session.beginTransaction();
			Course course = new Course("Piano");
			Review review1 = new Review ("Good");
			Review review2 = new Review("excellent");
			course.add(review1);
			course.add(review2);
			
			session.save(course);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally{
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
