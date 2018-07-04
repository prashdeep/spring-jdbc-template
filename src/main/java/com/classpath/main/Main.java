package com.classpath.main;

import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.classpath.dao.PersonDAOImpl;
import com.classpath.model.Person;

public final class Main {
	public static void main(String[] args) {

		// Initialize the datasource, could /should be done of Spring
		// configuration
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/students?autoReconnect=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("welcome");
		// Inject the datasource into the dao
		PersonDAOImpl dao = new PersonDAOImpl(dataSource);

		dao.insert("Pradeep", "Kumar");
		dao.insert("Naveen", "Krishna");
		System.out.println("Now select and list all persons");
		List<Person> list = dao.selectAll();
		for (Person myPerson : list) {
			System.out.print(myPerson.getFirstName() + " ");
			System.out.println(myPerson.getLastName());
		}
		System.out.println("Now select and list all persons with have the firstname Pradeep and lastname Kumar");
		list = dao.select("Pradeep", "Kumar");
		for (Person myPerson : list) {
			System.out.print(myPerson.getFirstName() + " ");
			System.out.println(myPerson.getLastName());
		}

		// Clean-up
		//dao.deleteAll();
	}
}
