package com.classpath.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.classpath.mapper.PersonRowMapper;
import com.classpath.model.Person;

public class PersonDAOImpl implements IDao {

	private JdbcTemplate jdbcTemplate;

	public PersonDAOImpl(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public void insert(String firstName, String lastName) {

		jdbcTemplate.update("INSERT INTO PERSON (FIRSTNAME, LASTNAME) VALUES(?,?)",
				new Object[] { firstName, lastName });
	}

	public List<Person> select(String firstname, String lastname) {

		return jdbcTemplate.query("select  FIRSTNAME, LASTNAME from PERSON where FIRSTNAME = ? AND LASTNAME= ?",
				new Object[] { firstname, lastname }, new PersonRowMapper());
	}

	public List<Person> selectAll() {

		return jdbcTemplate.query("select FIRSTNAME, LASTNAME from PERSON", new PersonRowMapper());
	}

	public void deleteAll() {

		jdbcTemplate.update("DELETE from PERSON");
	}

	public void delete(String firstName, String lastName) {

		jdbcTemplate.update("DELETE from PERSON where FIRSTNAME= ? AND LASTNAME = ?",
				new Object[] { firstName, lastName });
	}

	public void update(int id, String firstName, String lastName) {

		jdbcTemplate.update("Update employee set firstname=? and lastname=? where id= ? ",
				new Object[] { firstName, lastName, id });

	}
}
