package com.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
