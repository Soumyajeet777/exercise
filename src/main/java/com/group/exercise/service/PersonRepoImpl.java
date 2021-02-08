package com.group.exercise.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.group.exercise.model.Person;
import com.group.exercise.repository.PersonRepoInterface;

public class PersonRepoImpl implements PersonRepoInterface {
	

	
	public static List<Person> personList = new ArrayList<>();
	
	static{
		
		personList.add(new Person("121","Soumya",27,713304));
		personList.add(new Person("122","Jeet",28,713307));
		personList.add(new Person("123","Kar",30,713301));
		
		
	}
	
		
	

	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		
		personList.forEach((p) -> {
			
			
			if( p.equals(person)) {
				
				System.out.print("Person is already added");
				throw new Exception e;  //custom exception
			}
			else {
				
				personList.add(person);
			}
			
		});
		
		
		}

	@Override
	public void savePeople(List<Person> people) {
		// TODO Auto-generated method stub
			
			people.forEach((p1) ->{
				
				//try catch calling saveperson
				
				if(!personList.contains(p1))
				{
					personList.add(p1);
				}

				
			});
			

		//personList.addAll(people);
		
	}

	@Override
	public Person getPerson(String id) {
		// TODO Auto-generated method stub
		List<Person> personList1 = new ArrayList<Person>();
		
		personList.forEach((person) -> {
			
			if(person.getId() == id) {
				personList1.add(person);
			}
			
			
		});
		
		return personList1.get(0);
		
		
	}

	@Override
	public List<Person> getPeopleInZipCode(int zipCode) {
		// TODO Auto-generated method stub
		List<Person> personList2 = new ArrayList<Person>();
        
		
		personList.forEach((person) -> {
			
			if(person.getZipCode() == zipCode) {
				personList2.add(person);
			}
			
			
		});
		
		return personList2;
	}

	@Override
	public List<Person> getPeopleWithAge(int age) {
		// TODO Auto-generated method stub

		List<Person> personList1 = personList.stream().filter(person -> person.getAge() == age).collect(Collectors.toList());
		
		return personList1;
		
	}

	@Override
	public Person getYoungestPerson() {

		
		Optional<Person> youngestPerson = personList.stream().min(Comparator.comparingInt(Person::getAge));
		
		return youngestPerson.get();

		
		
	}

	
    public List<Person> getAllPersons(){
    	
    	return personList;
    	
    }
	
}
