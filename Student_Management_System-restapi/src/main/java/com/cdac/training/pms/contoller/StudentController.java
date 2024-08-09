package com.cdac.training.pms.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.training.pms.exception.ResourceNotFoundException;

//import com.cdac.training.pms.exception.ResponseNotFoundException;

import com.cdac.training.pms.model.Student;
import com.cdac.training.pms.service.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService stuservice;
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@Validated @RequestBody Student student){
		try {
			
			Student st = stuservice.saveStudent(student);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(st);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent(){
		try {
			
			List<Student> st = stuservice.listAll();
			return ResponseEntity.ok(st);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			
		}
		
	}
	
	 @DeleteMapping("/student/{id}")
	    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable(value = "id") Long stId) 
	    		throws ResourceNotFoundException {
	        stuservice.getSinglebyId(stId).orElseThrow(() -> new ResourceNotFoundException("Student Not Found for this Id: " + stId));
	        
	        stuservice.deletebyId(stId);
	        
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("Deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
	    }
	 
	 
	@PutMapping("/employee/{id}")
	public ResponseEntity<Student> updateEmployee(@PathVariable(value="id")long stId, @Validated @RequestBody Student stud) throws ResourceNotFoundException{
		Student st = stuservice.getSinglebyId(stId).orElseThrow(()-> new ResourceNotFoundException("Student Not Found For this Id: " +stId));
		st.setName(stud.getName());
		st.setPhoneNo(stud.getPhoneNo());
		st.setEmail(stud.getEmail());
		
		final Student updatedEmployee=stuservice.saveStudent(stud);
		return ResponseEntity.ok().body(updatedEmployee);
		
}
		


}
	
	
	
	


