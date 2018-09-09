package com.example.coursemanagement.neo4j.dao;

import com.example.coursemanagement.neo4j.entity.Student;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public interface StudentDao extends Neo4jRepository<Student,String> {
    Student save(Student student);
}
