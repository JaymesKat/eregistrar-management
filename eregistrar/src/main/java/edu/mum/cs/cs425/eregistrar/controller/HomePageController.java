package edu.mum.cs.cs425.eregistrar.controller;

import edu.mum.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value={"/", "/eregistrar", "/eregistrar/home"})
    public String displayHomePage(Model model){
        model.addAttribute("students");
        return "public/home/index";
    }
}
