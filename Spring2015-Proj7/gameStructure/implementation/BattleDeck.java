package implementation;

import java.util.ArrayList;


/** 
 * A data structure class that stores deep copies of any creatures 
 * that are sent to do battle.  By having deep copies, the player's
 * character does not get permanently damaged in their personal 
 * library, only in this playing of the game.
 * <br><br>
 * A BattleDeck object has a list of Battleable creatures (held in 
 * an ArrayList object).  It can not be used to hold anything that
 * doesn't implement the Battleable interface.
 */
public class BattleDeck<T extends Battleable> {
	private ArrayList<Battleable> arr;
	private int addCounter;

	//other fields that you feel you need should go here

	
	

	/**
	 * Standard constructor.  It needs to initialize the ArrayList object 
	 * and do any other setup that you deem necessary for this class object.
	 */
	public BattleDeck() {
		arr = new ArrayList<Battleable>();
		addCounter += 1;
		//throw new RuntimeException("Implement me!");
	}

	
	
	/**
	 * Adds an item to the BattleDeck in a very special way.  
	 * The structure is double-ended; this means that the "side" to which
	 * objects are added alternates with every other item added.  If things
	 * are added in the order 1,2,3,4,5 then the BattleDeck would grow as
	 * the following:<br>
	 * &nbsp;&nbsp;&nbsp;1<br>
	 * &nbsp;&nbsp;&nbsp;1,2<br>
	 * &nbsp;&nbsp;&nbsp;3fs,1,2<br>
	 * &nbsp;&nbsp;&nbsp;3,1,2,4<br>
	 * &nbsp;&nbsp;&nbsp;5,3,1,2,4<br>
	 * It is your job to determine a good way to ensure this alternation.
	 * 
	 * @param newItem refers to a creature to be added to this BattleDeck
	 */
	public void add(T newItem) {
		if(addCounter%2 == 0)
		{
			arr.add(newItem.returnDuplicate());
		}
		else
		{
			arr.add(0, newItem.returnDuplicate());
		}
		addCounter++;
		//throw new RuntimeException("Implement me!");
	}

	
	
	
	/**
	 * Goes through each item in the BattleDeck and deducts the specified 
	 * loss value from every creature it contains.
	 * 
	 * @param lossValue the value to deduct from the strength level
	 */
	public void weakenCreatures(int lossValue) {
		for(Battleable b: arr)
		{
			if(b.getStrength() <= lossValue)
			{
				b.setStrength(0);
			}
			else
			{
				b.setStrength(b.getStrength()-lossValue);
			}
		}
		//throw new RuntimeException("Implement me!");
	}
	
	
	/**
	 * Removes any creature currently in the battle deck who have
	 * no more strength left.
	 */
	public void sweepDeck() {
		ArrayList <Battleable> arrCopy = new ArrayList<Battleable>(arr);
		for (Battleable b: arr)
		{
			if(b.getStrength() == 0)
			{
				arrCopy.remove(b);
			}
		}
		arr = arrCopy;
		//throw new RuntimeException("Implement me!");
	}
	
	
	
	/**
	 * The method is meant to allow the next two creatures to fight and
	 * for the winner to be returned.
	 * <br><br>
	 * If there are no creatures in the structure, returns null.<br>
	 * If there is only one creature in the structure, it is removed
	 * and declared the winner<br>
	 * Otherwise, there is a series of events that takes place.
	 * The following presents the events and the order in which 
	 * the events must take place:<br>
	 * 1. One creature is removed from each end of the structure
	 *       and they will later do battle.<br>
	 * 2. All creatures remaining in the BattleDeck are weakened by
	 *       one strength point.<br>
	 * 3. The BattleDeck is cleared of any creatures who no longer
	 *       have any strength.<br>
	 * 4. The winner is determined in a two-step process; (a) if they have 
	 *       different skill levels, the one with the higher skill level
	 *       wins but if they have the same skill level then (b) the one
	 *       with the higher strength value wins.  If they have the same
	 *       skill level and the same strength level, then whichever of
	 *       the two creatures came from the front of the deck wins.
	 * <br><br>
	 * NOTE: The @SuppressWarnings("unchecked") indicator is to inform
	 * the compiler that even though we don't test to make sure the cast
	 * to T is valid, we are sure of our logic.
	 * 
	 * @return reference to the winning creature
	 */
	@SuppressWarnings("unchecked")
	public T fight() {
		//WTF IS T!!!!!
		Battleable leftFighter;
		Battleable rightFighter;
		Battleable winner;
		if (arr == null)
		{
			return null;
		}
		else
		{
			if (arr.size() == 1)
			{
				winner = arr.get(0);
				arr.remove(0);
			}
			else
			{
				leftFighter = arr.get(0);
				arr.remove(0);
				rightFighter = arr.get(arr.size()-1);
				arr.remove(arr.size()-1);
				weakenCreatures(1);
				sweepDeck();
				//check for winner
				if(leftFighter.getLevel() == rightFighter.getLevel())
				{
					if(leftFighter.getStrength() == rightFighter.getStrength())
					{
						winner = leftFighter;
					}
					else
					{
						winner = (leftFighter.getStrength() < rightFighter.getStrength())?(rightFighter):(leftFighter);
					}
				}
				else
				{
					winner = (leftFighter.getLevel() < rightFighter.getLevel())?(rightFighter):(leftFighter);
				}
			}
		}
		return (T) winner;
		//throw new RuntimeException("Implement me!");
	}
	
	
	
	
	/**
	 * The method will return a ragged 2D array of references to copies of 
	 * the creatures currently stored in the battle deck.  The 2D array will
	 * have one row for each valid skill level (0 through 9).  Within each
	 * row the order will be based on the "front to back" order of them in
	 * the ArrayList.  NOTE: To build the ragged arrays, you'll need to read
	 * through the list of creatures once to determine how big each row will
	 * need to be and then another time to populate the ragged array with 
	 * the references to the copies of the creatures.
	 * 
	 * @return reference to a ragged 2D array
	 */
	public Battleable[][] export2D() {
		Battleable [][] export = new Battleable [10][];
		int lvlCounter;
		int populate = 0;
		for (int lvl = 0;  lvl < export.length; lvl++)
		{
			lvlCounter = 0;
			for(Battleable b: arr)
			{
				if(b.getLevel() == lvl)
				{
					lvlCounter++;
				}
			}
			export [lvl] = new Battleable [lvlCounter]; 
		}
		for (int lvl = 0;  lvl < export.length; lvl++)
		{
			populate = 0;
			for(Battleable b: arr)
			{
				if(b.getLevel() == lvl)
				{
					export[lvl][populate] = b;
					populate++;
				}
			}
		}
		return export;
		//throw new RuntimeException("Implement me!");
	}

	
	
	
	
	/**
	 * The method will return a String object containing a representation
	 * of the creatures currently held in the BattleDeck, shown in order 
	 * from "front to back" of the ArrayList holding the references.
	 * 
	 * @return String representing the BattleDeck
	 */
	@Override
	public String toString() {
		StringBuffer retVal = new StringBuffer("Contents: ");
		retVal.append("[ ");
		for (Battleable val : arr) {
			retVal.append(val + ", ");
		}
		if (retVal.lastIndexOf(", ") == retVal.length()-2) {
			retVal.delete(retVal.length()-2, retVal.length());
		}
		retVal.append(" ]");

		return new String(retVal);
	}





}
