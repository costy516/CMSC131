package studentCode;

import java.util.ArrayList;


/*
 * This class is what you need to implement for this lab.
 * 
 * The Person interface has been written as have some classes that
 *   implement the interface.
 */


public class MyPersonList {
	ArrayList<Person> people;

	
	
	/**
	 * Instantiates the "people" variable as a new ArrayList of
	 * references to Person objects.
	 */
	public MyPersonList(){
		people = new ArrayList<Person>();
		//throw new RuntimeException("Implement this.");
	}
	
	/**
	 * A copy constructor which makes a deep copy considering the fact that
	 * a Person object is mutable.
	 */
	public MyPersonList(MyPersonList other) {
		if (other == null)
		{
			people = new ArrayList<Person>();
		}
		else
		{
			people = new ArrayList<Person>();
			for(Person p: other.people)
			{
				people.add(p.copyMe());
			}
		}
		//throw new RuntimeException("Implement this.");
	}
	
	
	/** Adds the object referenced by the parameter to the end of the list.  
	 *  With ArrayList this will be much shorter in terms of code than last 
	 *  time.  
	 *  
	 *  Note that you want to make sure that you don't just do a reference 
	 *  copy of the newMember Person since it is mutable.
	 */
	public void addItem(Person newMember){	
		people.add(newMember.copyMe());
		//throw new RuntimeException("Implement this.");
	}
	
	/** Gives each person in the list a raise of $1000.  
	 * 
	 *  Note that the objects are mutable, which means you can use a 
	 *  for-each style loop as you update.
	 */
	public void giveRaises(){
		for (Person p:people)
		{
			p.acceptRaise(1000);
		}
		//throw new RuntimeException("Implement this.");
	}
	
	/** Returns the sum of the salaries of all people in the list.
	 */
	public int getTotalOfSalaries(){
		int sum = 0;
		for (Person p:people)
		{
			sum += p.getSalary();
		}
		return sum;
		//throw new RuntimeException("Implement this.");
	}

	/** Returns the number of people in the list with a name
	 *  that matches the parameter (possibly 0 people).
	 */
	public int count(String searchName){
		int counter = 0;
		for (Person p:people)
		{
			if(p.getName().equals(searchName))
			{
				counter++;
			}
		}
		return counter;
		//throw new RuntimeException("Implement this.");
	}
	
	/** Removes ALL people from the list whose names match the parameter
	 *  (possibly more than one person).  
	 *  
	 *  Consider that a for-each style loop cannot be used unless you 
	 *  create a shadow.  There are code examples in the posted slides 
	 *  that will be useful here.
	 */
	public void remove(String removeName){
		ArrayList<Person> people2 = new ArrayList<Person>(people);
		for(Person p: people)
		{
			if(p.getName().equals(removeName))
			{	
				people2.remove(p);
			}
		}
		people = people2;
		//throw new RuntimeException("Implement this.");
	}
	
}




