package com.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rest.models.Student;
import com.rest.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	// Get All Students
	public Iterable<Student> getAllStudents()
	{ 
		return studentRepository.findAll();
	}
	
	// Create Student
	public Student createStudent(Student student)
	{
		Student inserted_student= studentRepository.save(student);
		return inserted_student;
	}
		
	// Get Student by Id
	public Student getStudentById(int id)
	{
		Student founded_student= studentRepository.findById(id).orElseThrow ( ()-> {		
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no student of this id");
			});
		return founded_student;
	}
		
	// Update Student by Id
	public Student updateStudentById(int id, Student student)
	{
		Student founded_student= getStudentById(id);
		student.setId(founded_student.getId());
		Student updated_student = studentRepository.save(student);
		return updated_student;
	}
		
	// Delete Student by Id
	public void deleteStudentById(int id)
	{
		getStudentById(id);
		studentRepository.deleteById(id);
	}
	
}
