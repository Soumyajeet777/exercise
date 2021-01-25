package com.group.exercise.model;

public class Person {

    private String id;
    private String name;
    private int age;
    private int zipCode;

    public Person(String id, String name, int age, int zipCode) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.zipCode = zipCode;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getZipCode() {
        return this.zipCode;
    }

}
