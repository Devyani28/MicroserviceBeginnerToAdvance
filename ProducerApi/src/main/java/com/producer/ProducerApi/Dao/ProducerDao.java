package com.producer.ProducerApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producer.ProducerApi.Entity.Employee;

public interface ProducerDao extends JpaRepository<Employee, String>{

}
