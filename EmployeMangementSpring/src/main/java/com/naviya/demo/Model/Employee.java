package com.naviya.demo.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private long phone;
	
	@Column(name="Designation")
	private String Designation;
	
	@Column(name="salary")
	private long salary;
	
	@Column(name="email",unique = true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	private boolean isEnabled;
	
	@OneToOne(mappedBy = "employee")
	@Cascade(CascadeType.DELETE)
	private ConfirmationToken confirmationToken;
	
	public Employee() {}

	public Employee(int id, String name, long phone, String designation, long salary, String email, String password,
			boolean isEnabled) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		Designation = designation;
		this.salary = salary;
		this.email = email;
		this.password = password;
		this.isEnabled = isEnabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	
}
