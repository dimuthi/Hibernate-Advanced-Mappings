package com.dim.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dim.hibernate.demo.entity.Course;
import com.dim.hibernate.demo.entity.Instructor;
import com.dim.hibernate.demo.entity.InstructorDetail;
import com.dim.hibernate.demo.entity.Review;
import com.dim.hibernate.demo.entity.Student;


public class AddCoursesForDimuthi {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//start transaction
			
			session.beginTransaction();
			
			Course course1 = new Course("English");

			Course course2 = new Course("Game Development");
			Student student = session.get(Student.class, 1);
			course1.addStudent(student);
			course2.addStudent(student);
			
			session.save(course1);
			session.save(course2);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally{
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
