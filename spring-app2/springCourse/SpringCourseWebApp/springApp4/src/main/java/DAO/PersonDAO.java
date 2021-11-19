package DAO;

import models.Person;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    { //блок инициализации
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ivan"));
        people.add(new Person(++PEOPLE_COUNT, "Stepan"));
        people.add(new Person(++PEOPLE_COUNT, "Volfram"));
    }

    public List<Person> index(){
        return people;
    }
    //получить list

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
