package com.cdac.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.training.pms.model.Student;
import com.cdac.training.pms.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository strepo;
	
	
	public Student saveStudent(Student std) {
		return strepo.save(std);
	}
	
	public List<Student> listAll(){
		return strepo.findAll();
	}
	
	public Optional<Student>getSinglebyId(Long Id){
		return strepo.findById(Id);
	}
	
	public void deletebyId(Long Id) {
		strepo.deleteById(Id);
	}
	

}
