package com.naresh.example.springbootrestapiandroid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.example.springbootrestapiandroid.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
