package controllers;

import DAO.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("second/people")

public class SecondPeopleController {
    private final PersonDAO personDAO;

    public SecondPeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    //спринг сам внедрит объект через конструктор

    @GetMapping()
    public String index(Model model){
        //получить всех людей из ДАО и передать на отображение в представление
        model.addAttribute("people", personDAO.index());
        return "second/people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        //получим одного человека по ID из ДАО и передадим  на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "second/people/show";
    }


}
