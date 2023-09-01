package com.project.SignupLoginFeatureSpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SignupLoginFeatureSpringBoot.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	public List<UserEntity> findByUserName(String name);

}
