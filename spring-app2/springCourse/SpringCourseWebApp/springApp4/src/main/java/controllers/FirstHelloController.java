package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstHelloController {

    @GetMapping("/hi")
    public String sayHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                           Model model) {

        //System.out.println("Received name: " + name + ", surname: " + surname);
        model.addAttribute("message",  "Hi " + name + " " + surname);
        return "first/hello_from_spring";
    }

}
