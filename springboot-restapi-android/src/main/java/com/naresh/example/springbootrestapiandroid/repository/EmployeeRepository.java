package com.naresh.example.springbootrestapiandroid.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.naresh.example.springbootrestapiandroid.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}