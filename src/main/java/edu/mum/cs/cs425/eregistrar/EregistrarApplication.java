package edu.mum.cs.cs425.eregistrar;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EregistrarApplication implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(EregistrarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student("000-61-3480", "James", "", "Katarikawe",4.00, LocalDate.of(2021,8,12), true);
        Student student2 = new Student("000-61-3430", "Anna", "M.", "Smith",3.90, LocalDate.of(2021,11,05), false);
        Student student3 = new Student("000-60-0030", "Bob", "A.", "Jones",3.40, LocalDate.of(2022,02,03), false);
        Student student4 = new Student("000-62-1030", "John", "W.", "Doe",3.20, LocalDate.of(2021,05,11), true);

        var students = new Student[]{student1, student2, student3};
        Arrays.stream(students).forEach(student -> studentService.addStudent(student));
    }
}
