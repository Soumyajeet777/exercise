package com.group.exercise.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.group.exercise.exception.InvalidException;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.group.exercise.model.Person;
import com.group.exercise.repository.PersonRepoInterface;



public class PersonRepoImplTest  {

	

	private PersonRepoInterface personRepoInterface = new PersonRepoImpl();;

	private PersonRepoImpl personRepoImpl = new PersonRepoImpl();
	
	 @Test
     //Test for savePerson

		public void savePersonTest() {
			
		Person personTest = new Person("124","Saurav",31,651024);
		personRepoInterface.savePerson(personTest );
		
		List<Person> allPersonList = personRepoImpl.getAllPersons();
		
		assertTrue(allPersonList.contains(personTest));
		
		}
     
     
     @Test
     public void savePersonTestWithExistingValue() {
     	
     	Person personTest = new Person("121","Soumya",27,713304);
			
			assertThrows(InvalidException.class, () -> {
				   personRepoInterface.savePerson(personTest );
			    });
     }
     
     
		
     @Test
		//Test for savePeople
		
		public void savePeopleTest() {
		List<Person> personListTest = new ArrayList<>();
		
		List<Person> allPersonList = personRepoImpl.getAllPersons();
		
		personListTest.add(new Person("126","Madhu",25,713301));
		personListTest.add(new Person("125","Rima",32,411028));
		personListTest.add(new Person("127","Sarkar",30,100011));
		personRepoInterface.savePeople(personListTest);
		
		assertTrue(allPersonList.containsAll(personListTest));
		
		}
		
		
     @Test
		//Test for getPerson
		
		public void getPersonTest() {
		Person personWithIdTest = personRepoInterface.getPerson("122");
		
		
		Person personTest1 = new Person("122","Jeet",28,713307);
		assertEquals(personTest1, personWithIdTest);
		
		}
		
     
     @Test
		//Test for getPeopleInZipCode
		
		public void getPeopleInZipCodeTest(){
		
		List<Person> personListWithZipTest = personRepoInterface.getPeopleInZipCode(713304);
		
		List<Person> personList1 = new ArrayList<>();
		personList1.add(new Person("121","Soumya",27,713304));
		
		assertEquals(personList1, personListWithZipTest);
		
		}
		
     
     @Test
		//Test for getPeopleWithAge
		
		public void getPeopleWithAgeTest(){
		List<Person> personListWithAgeTest = personRepoInterface.getPeopleWithAge(30);
		
		List<Person> personList2 = new ArrayList<>();
		personList2.add(new Person("123","Kar",30,713301));
		personList2.add(new Person("127","Sarkar",30,100011));
		
		assertEquals(personList2, personListWithAgeTest);
		
		}
		
		
     @Test
		//Test for getYoungestPerson
		
		public void getYoungestPersonTest() {
		
		Person youngestPersonTest = personRepoInterface.getYoungestPerson();
		
		Person personTest2 = new Person("121","Soumya",27,713304);
		assertEquals(personTest2, youngestPersonTest);
		
		
     }
		
}
