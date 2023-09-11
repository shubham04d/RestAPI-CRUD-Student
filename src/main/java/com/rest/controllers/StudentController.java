package com.rest.controllers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rest.models.Student;
import com.rest.services.StudentService;
import com.rest.helper.StudentResponseWrapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("")
	public ResponseEntity<?> getAllStudents() {
		Iterable<Student> student = studentService.getAllStudents();
		Iterator<Student> all_student = student.iterator();
		if (all_student.hasNext()) {
			StudentResponseWrapper srw = new StudentResponseWrapper();
			srw.setMessage("Student data found successfully");
			srw.setData(all_student);
			return new ResponseEntity<>(srw, HttpStatus.FOUND);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"There is no student data available. Please add some.");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable int id) {
		Student founded_student = studentService.getStudentById(id);
		StudentResponseWrapper srw = new StudentResponseWrapper();
		srw.setMessage("Student data found successfully");
		srw.setData(founded_student);
		return new ResponseEntity<>(srw, HttpStatus.FOUND);
	}

	@PostMapping("")
	public ResponseEntity<?> creatstudent(@RequestBody @Valid Student student) {
		Student created_student = studentService.createStudent(student);
		StudentResponseWrapper srw = new StudentResponseWrapper();
		srw.setMessage("Student data created succesfully");
		srw.setData(created_student);
		return new ResponseEntity<>(srw, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudentById(@PathVariable int id, @RequestBody @Valid Student student) {
		Student updated_student = studentService.updateStudentById(id, student);
		StudentResponseWrapper srw = new StudentResponseWrapper();
		srw.setMessage("Student data updated by Id successfully");
		srw.setData(updated_student);
		return new ResponseEntity<>(srw, HttpStatus.FOUND);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable int id) {
		studentService.deleteStudentById(id);
		StudentResponseWrapper srw = new StudentResponseWrapper();
		srw.setMessage("Student data deleted by Id successfully");
		return new ResponseEntity<>(srw, HttpStatus.OK);

	}

}
