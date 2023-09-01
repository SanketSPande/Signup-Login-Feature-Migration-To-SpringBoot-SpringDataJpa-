package com.project.SignupLoginFeatureSpringBoot.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.SignupLoginFeatureSpringBoot.entity.UserEntity;

@Component  //This will declare the class as spring bean, no need to configure using xml
public class LoginDAO {
	
	@Autowired
	UserRepository userRepository;
	
	public UserEntity save(UserEntity user) {
		UserEntity useFromDB = userRepository.save(user);
		return useFromDB;
	}
	
	public UserEntity getUserByUsername(String Username) {
		List<UserEntity> user = userRepository.findByUserName(Username);
		System.out.println("DAO   = "+user);
		return user.get(0);
	}
	
//	@Transactional
//	public int save(UserEntity user) {
//		Integer i =(Integer) hibernateTemplate.save(user);
//		return i; //this is number of rows affected or added
//	}
//	
//	public UserEntity getUserByUsername(String Username) {
//		 List<UserEntity> user = (List<UserEntity>) hibernateTemplate.findByNamedParam("FROM UserEntity WHERE userName = :username","username",Username);		
//		 //System.out.println("DAO   = "+user.get(0));
//		return user.get(0);
//	}
//	
//	@Transactional
//	public void update(UserEntity user) {
//		hibernateTemplate.update(user);
//		//System.out.println("DAO    = "+user);
//	}
	
	

}

