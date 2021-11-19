package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstCalculatorController {

    double result;

//    @GetMapping("/calculator")
//    public String goToCalculator() {
//        return "first/calc";
//    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b, @RequestParam(value = "action") String action,
                            Model model) {
        double result;
        switch (action) {
            case "multiply":
                result = a * b;
                break;
            case "add":
                result = a + b;
                break;
            case "substract":
                result = a - b;
                break;
            case "divide":
                result = b == 0 ? 0 : (double) a / (double) b;
                break;
            default:
                result = 0;

        }
        model.addAttribute("result", result);

        return "first/calc";

    }


}
