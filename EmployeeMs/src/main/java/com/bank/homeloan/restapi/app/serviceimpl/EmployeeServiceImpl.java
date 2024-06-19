package com.bank.homeloan.restapi.app.serviceimpl;

import java.util.List;

import org.hibernate.loader.ast.internal.SingleIdEntityLoaderProvidedQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bank.homeloan.restapi.app.exception.EmployeeNotFoundException;
import com.bank.homeloan.restapi.app.model.Employee;
import com.bank.homeloan.restapi.app.repository.EmployeeRepository;
import com.bank.homeloan.restapi.app.servicei.EmployeeServiceI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{

	@Autowired EmployeeRepository er;
	
	@Autowired private JavaMailSender jmsender;
	
	@Autowired @Value("$spring.mail.username") String myMail;

	@Override
	public Employee saveEmployee(Employee e) {
		
		String sub="Welcome to Apna Finance Corp Ltd!\\n\\n";       
		String msg=
	               "Dear " + e.getEmployeeName() + ",\n\n" +
	               "We are thrilled to welcome you to the Apna Finance Corp Ltd. family! We are excited about the skills and experience you bring to our team,"
	               + " and we look forward to achieving great things together.\n\n" +
	               "As a valued member of our team, you will have access to our internal systems and resources. Below are your login credentials:\n\n" +
	               "Username: " + e.getUsername() + "\n" +
	               "Password: " + e.getPassword() + "\n\n" +
	               "We are confident that you will make significant contributions to our company, and we are here to support you every step of the way.\n\n" +
	               "Once again, welcome to Apna Finance Corp Ltd. We are excited to have you on board.\n\n" +
	               "Best regards,\n" +
	               "Admin Team\n" +
	               "Apna Finance Corp Ltd";
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(myMail);
		message.setTo(e.getEmployeeEmail());
		message.setSubject(sub);
		message.setText(msg);
		
		jmsender.send(message);
		
		return er.save(e);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> elist=er.findAll();
		
		if(!elist.isEmpty()) {
			
		return elist;
		}
		else {
			throw new EmployeeNotFoundException("no employee");
		}
	}

	@Override
	public Employee getByUsernameAndPassword(String username, String password) {
		 Employee emp = er.getByUsernameAndPassword(username,password);
		 if(emp!=null) {
			 return emp;
		 }
		 else {
			 throw new EmployeeNotFoundException("no employee found on this username and password..!!");
		 }
	}
	
	

	
}
