package com.naviya.demo.Controller;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.naviya.demo.Model.ConfirmationToken;
import com.naviya.demo.Model.Employee;
import com.naviya.demo.Repository.ConfirmationTokenRepository;
import com.naviya.demo.Repository.Repository;
import com.naviya.demo.Service.EmailService;
import com.naviya.demo.Service.Service;

@RestController
public class Controller {

	@Autowired
	Repository repo;
	
	@Autowired
	ConfirmationTokenRepository tokenRepo;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	Service service;
	
	@PostMapping("/add")
	@CrossOrigin
	@Transactional
	public String saveEmployee(@RequestBody Employee emp)
	{
		Employee exist = repo.findByEmailIgnoreCase(emp.getEmail());
		if(exist!=null)
		{
			return "This email already exist!";
		}
		else
		{
		service.saveEmployee(emp);
				
		ConfirmationToken confirmationToken = new ConfirmationToken(emp);
		tokenRepo.save(confirmationToken);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(emp.getEmail());
		mailMessage.setSubject("Complete Registration!");
		mailMessage.setText("Dear "+ emp.getName()+"\nwe are happy to be with you,\n to confirm your account, please click here : "
				+ "http://localhost:4200/verify/?token=" + confirmationToken.getConfirmationToken());
		emailService.sendEmail(mailMessage);
		}
		return "Employee "+emp.getName()+" inserted Successfully  \n Please Check Your Email To Verify Your Account";
	}
	
	@RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
	@CrossOrigin
	public String confirmUserAccount(@RequestParam("token") String confirmationToken) {
		ConfirmationToken token = tokenRepo.findByConfirmationToken(confirmationToken);

		if (token != null) {
			Employee emp = repo.findByEmailIgnoreCase(token.getEmployee().getEmail());
			emp.setEnabled(true);
			repo.save(emp);
			return "Congratulations\nyour email successfully\nverified";
		} 
		else {
			return"The link is invalid or broken!";
		}
	}
	
	@GetMapping("/get")
	@CrossOrigin
	public Iterable<Employee> getEmployeeDetails()
	{
		return repo.findAll();
	}
	
	@GetMapping("/delete/{id}")
	@CrossOrigin
	@Transactional
	public Iterable<Employee> removeEmp(@PathVariable int id)
	{
		repo.deleteById(id);
		return repo.findAll();
	}
	
	@GetMapping("/find/{name}")
	@CrossOrigin
	public List<Employee> findUser(@PathVariable String name)
	{
		return repo.findByName(name);
	}
}
