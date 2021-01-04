package com.naviya.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.naviya.demo.Model.Employee;
import com.naviya.demo.Repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private Repository repo;

	public Service(Repository repo) {
		super();
		this.repo = repo;
	}
	
	public void saveEmployee(Employee emp)
	{
		repo.save(emp);
	}
}
