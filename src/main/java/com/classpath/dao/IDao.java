package com.classpath.dao;

import java.util.List;

import com.classpath.model.Person;

public interface IDao {

	void insert(String firstName, String lastName);

	List<Person> select(String firstname, String lastname);

	List<Person> selectAll();

	void deleteAll();

	void delete(String firstName, String lastName);

	void update(int id, String firstName, String lastName);

}
