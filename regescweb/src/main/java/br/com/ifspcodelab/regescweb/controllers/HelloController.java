package br.com.ifspcodelab.regescweb.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        request.setAttribute("nome", "Beatriz");
        return "hello"; //o Spring vai renderizar o arquivo templates/hello.html
    }
}

