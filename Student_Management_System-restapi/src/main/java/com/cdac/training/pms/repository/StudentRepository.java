package com.cdac.training.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.training.pms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
