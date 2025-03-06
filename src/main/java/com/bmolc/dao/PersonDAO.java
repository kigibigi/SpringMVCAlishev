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

        people.add(new Person(PEOPLE_COUNT++ , "Tom", 24, "tom@mail.ru"));
        people.add(new Person(PEOPLE_COUNT++ , "Ivan", 52, "ivanovich@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++ , "Olga", 31, "olysha1993@mail.ru"));
        people.add(new Person(PEOPLE_COUNT++ , "Kristina", 22, "krisipisi@rambler.ru"));
        people.add(new Person(PEOPLE_COUNT++ , "Sergey", 62, "sergey.62@yandex.ru"));
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
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
