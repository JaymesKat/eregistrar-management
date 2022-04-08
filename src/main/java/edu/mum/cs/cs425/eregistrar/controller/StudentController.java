package edu.mum.cs.cs425.eregistrar.controller;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/eregistrar/students/list")
    public ModelAndView findAllStudents(){
        List<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("secured/students/list");
        return modelAndView;
    }

    @GetMapping("/eregistrar/students/new")
    public ModelAndView displayNewStudentForm(){
        Student student = new Student();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("secured/students/new");
        return modelAndView;
    }

    @GetMapping("/eregistrar/students/edit/{studentId}")
    public String displayEditStudentForm(@PathVariable Long studentId, Model model){
        Student student = studentService.getStudent(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "secured/students/edit";
        }
        return "redirect:/eregistrar/students/list";
    }

    @PostMapping("/eregistrar/students/save")
    public String processAddStudent(@Valid @ModelAttribute("student") Student student,
                                          BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/students/new";
        }
        studentService.addStudent(student);
        return "redirect:/eregistrar/students/list";
    }

    @GetMapping("/eregistrar/students/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/eregistrar/students/list";
    }
}
