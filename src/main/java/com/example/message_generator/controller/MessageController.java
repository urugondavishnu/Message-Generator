package com.example.message_generator.controller;

import com.example.message_generator.service.OpenAIService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    private final OpenAIService openAIService;

    public MessageController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    // Show the form
    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    // Handle form submission
    @PostMapping("/generate")
    public String generateMessage(@RequestParam("prompt") String prompt, Model model) {
        String message = openAIService.generateMessage(prompt);
        model.addAttribute("prompt", prompt);
        model.addAttribute("generatedMessage", message);
        return "index";
    }
}