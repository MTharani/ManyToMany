package com.hiber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class Mainapp {

	public static void main(String[] args) 
	{
		Configuration con= new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);
		 ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		 SessionFactory factory= con.buildSessionFactory(reg);
		 Session sess= factory.openSession();
		 Transaction t= sess.beginTransaction();
		 Course c1=new Course(5,"JFD",2000);
		 sess.save(c1);
		 Course c2=new Course(6,"testing",12000);
		 sess.save(c2);
		 Course c3=new Course(7,"sql",22000);
		 sess.save(c3);
		 Course c4=new Course(9,"web design",11000);
		 sess.save(c4);
		 Set<Course>courses=new HashSet<Course>(Arrays.asList(c1,c2,c3));
		 Student s1=new Student(13,"dhivya",789456321);
		 s1.setCourselist(courses);
		 Set<Course>courses1=new HashSet<Course>(Arrays.asList(c2,c3,c4));
		 Student s2=new Student(14,"tharani",989456321);
		 s2.setCourselist(courses1);
		 sess.save(s1);
		 sess.save(s2);
		 t.commit();
		 sess.close();


	}

}
