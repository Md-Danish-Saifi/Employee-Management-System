package com.naviya.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naviya.demo.Model.Employee;
import java.lang.String;
import java.util.List;
public interface Repository extends JpaRepository<Employee, Integer>{
	List<Employee> findByName(String name);
	List<Employee> findByEmail(String email);
	Employee findByEmailIgnoreCase(String email);
}
