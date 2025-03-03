package com.bmolc.dao;

import com.bmolc.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(PEOPLE_COUNT++ , "Tom"));
        people.add(new Person(PEOPLE_COUNT++ , "Ivan"));
        people.add(new Person(PEOPLE_COUNT++ , "Olga"));
        people.add(new Person(PEOPLE_COUNT++ , "Kristina"));
        people.add(new Person(PEOPLE_COUNT++ , "Sregey"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
