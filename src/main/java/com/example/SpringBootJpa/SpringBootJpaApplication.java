package com.example.SpringBootJpa;

import com.example.SpringBootJpa.Entity.User;
import com.example.SpringBootJpa.dao.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
		UserRepo userrepo = context.getBean(UserRepo.class);

//		save single user Object
		User user1=new User();
		user1.setName("Oli Chowdhury");
		user1.setCountry("Canada");
		//it returns user object
//		User userResult = userrepo.save(user1);
//		System.out.println(userResult);

		//I want to delete object
		//delete
//		userrepo.deleteById(2);



//		create multiple user collection
		User user2=new User();
		user2.setName("Oli3");
		user2.setCountry("India");


		User user3=new User();
		user3.setName("Oli4");
		user3.setCountry("South africa");
		User user4=new User();
		user4.setName("Oli5");
		user4.setCountry("South canada");


		List<User> users=new ArrayList<User>();
		users.add(user2);
		users.add(user3);

//		Iterable<User> userList=List.of(user2,user3);
//		userrepo.saveAll(users);


		//update
		Optional<User> optional=userrepo.findById(203);
		User userupdated = optional.get();
//		userupdated.setName("Updated Name oli2");
//		userrepo.save(userupdated);
//		userrepo.delete(userDeleted);

		//fetch User
//		Iterable<User> allUser = userrepo.findAll();
//		allUser.forEach(e-> System.out.println("List....................: "+e));
//
//
//		//customFinder Methods Use
//		List<User> userByName = userrepo.findByName("Oli Chowdhury");
//		userByName.forEach(e-> System.out.println("Find By Name :...."+e));
		List<User> allUser = userrepo.getUserByNameAndCountry("Oli Chowdhury","Canada");
		allUser.forEach(e-> System.out.println("user :..."+e));


		List<User> oliChowdhury = userrepo.getUserByNameNativeQuery("Oli Chowdhury");
		oliChowdhury.forEach(us-> System.out.println("hey : " + us));
	}

}
