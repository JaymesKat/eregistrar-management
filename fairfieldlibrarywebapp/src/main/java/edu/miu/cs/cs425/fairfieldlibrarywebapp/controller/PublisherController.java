package edu.miu.cs.cs425.fairfieldlibrarywebapp.controller;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"", "/fairfieldlibrarywebapp"})
public class PublisherController {

    private PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
    @GetMapping(value = {"/", "/publishers/list"})
    public ModelAndView listPublishers() {
        var modelAndView = new ModelAndView();
        var publishers = publisherService.getAllPublishers();
        modelAndView.addObject("publishers", publishers);
        modelAndView.setViewName("secured/publisher/list");
        return modelAndView;
    }
}
