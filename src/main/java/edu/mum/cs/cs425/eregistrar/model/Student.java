package edu.mum.cs.cs425.eregistrar.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Long studentId;

    @NotBlank
    @Column(name="student_number", nullable=false, unique=true)
    private String studentNumber;

    @NotBlank
    @Column(nullable = false)
    private String firstName;
    private String middleName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;
    private double cgpa;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date_enrolled", nullable = false)
    private LocalDate enrollmentDate;

    @NotNull
    @Column(nullable = false)
    private boolean isInternational;

    public Student(String studentNumber, String firstName,
                   String middleName, String lastName,
                   double cgpa, LocalDate enrollmentDate, boolean isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public void setIsInternational(String value) {
        Boolean isInternational = null;
        if("true".equals(value)){ 
            isInternational = true; }
        if("false".equals(value)){ 
            isInternational = false; 
        }
        this.isInternational = isInternational;
    }
}
