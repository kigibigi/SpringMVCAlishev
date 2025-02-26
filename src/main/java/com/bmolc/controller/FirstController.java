package com.bmolc.controller;

import com.bmolc.mathMethods.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.printf("Hello %s %s!", name, surname);
//        System.out.println();
        String answer = String.format("Hello %s %s!", name, surname);
        model.addAttribute("message", answer);

        return "/first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "/first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") int a,
                                 @RequestParam(value = "b") int b,
                                 @RequestParam(value = "action") String action,
                                 Model model) {
        double answer = 0;
        Calculator calculator = new Calculator(a, b);

        switch (action) {
            case "multiplication": answer = calculator.multiplication(); break;
            case "addition": answer = calculator.addition(); break;
            case "subtraction": answer = calculator.subtraction();break;
            case "division": answer = calculator.division();break;
        }

        String resultStr = String.format("Your result = %d", answer);
        model.addAttribute("result", resultStr);

        return "/first/calculator";
    }
}
