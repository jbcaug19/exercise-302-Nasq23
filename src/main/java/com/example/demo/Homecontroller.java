package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class Homecontroller {
    @Autowired
    TODORepository todoRepository;

    @RequestMapping("/")
    public String listJobs(Model model){
        model.addAttribute("jobs", todoRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String jobForm(Model model){
        model.addAttribute("todo", new TODO());
        return "todoform";
    }

    @PostMapping("/process")
    public String processForm(@Valid TODO todo, BindingResult result){
        if (result.hasErrors()){
            return "todoform";
        }
        todoRepository.save(todo);
        return "redirect:/";
    }
}
