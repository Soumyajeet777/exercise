package com.group.exercise.repository;

import com.group.exercise.model.Person;

import java.util.List;

public interface PersonRepoInterface {

    void savePerson(Person person);

    void savePeople(List<Person> people);

    Person getPerson(String id);

    List<Person> getPeopleInZipCode(int zipCode);

    List<Person> getPeopleWithAge(int age);

    Person getYoungestPerson();

}
