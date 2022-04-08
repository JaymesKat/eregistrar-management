package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> findAll();
    public abstract Student addStudent(Student student);
    public abstract void deleteStudent(Long studentId);
    public abstract Student getStudent(Long studentId);
}
