
package com.rest.repositories;

import org.springframework.data.repository.CrudRepository;
import com.rest.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
}
