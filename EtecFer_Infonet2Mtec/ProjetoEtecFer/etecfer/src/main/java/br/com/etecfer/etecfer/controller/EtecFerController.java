package br.com.etecfer.etecfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/etecfer")
public class EtecFerController {
    
    @GetMapping
    public String index(Model model) {
        return "index";
    }
    
    
}
