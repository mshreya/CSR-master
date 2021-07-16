package com.csr;

import com.csr.model.*;
import com.csr.service.EventService;
import com.csr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CsrserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;

	public static void main(String[] args) {
		SpringApplication.run(CsrserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Starting code");
	/*
		User user=new User();
		user.setEmployeeId("224");
		user.setPassword("abc");
		user.setEmail("komal.popli@clarivate.com");

		Role role=new Role();
		role.setRoleId(1L);
		role.setRoleName("Admin");

		Set<UserRole> userroles=new HashSet<>();
		UserRole userrole=new UserRole();
		userrole.setRole(role);
		userrole.setUser(user);
		userroles.add(userrole);
		User user1=this.userService.createUser(user,userroles);
		System.out.println(user1.getEmployeeId());*/

		System.out.println("starting");
	/*	Event event = new Event();
		event.setEventName("Uniform distribution at schools");
		event.setDescription("Distribution of uniform at school");
		event.setMaxTeamSize(6L);

		Activity activity1 = new Activity();
		activity1.setMaxNumber(3L);
		activity1.setRoleName("Buy uniforms");

		Activity activity2 = new Activity();
		activity2.setMaxNumber(4L);
		activity2.setRoleName("Arrange Logistics");


		Set<EventActivity> eventActivitySet = new HashSet<>();
		EventActivity eventActivity = new EventActivity();
		eventActivity.setActivity(activity1);
		eventActivity.setActivity(activity2);
		eventActivity.setEvent(event);
		eventActivitySet.add(eventActivity);


		Event event1= this.eventService.createEvent(event,eventActivitySet);
		System.out.println(event1.getEventName());
*/



	}
}
