package com.example.classification_text;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static java.lang.System.out;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String indexForm(Model model) {
        model.addAttribute("text", new Text());
        return "index";
    }

    @PostMapping("/index")
    public String textSubmit(@ModelAttribute Text text) {
        return "form";
    }



}