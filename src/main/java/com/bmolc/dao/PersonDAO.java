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
        people.add(new Person(PEOPLE_COUNT++ , "Sergey"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
