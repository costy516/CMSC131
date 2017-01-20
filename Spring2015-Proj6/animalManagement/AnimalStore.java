package animalManagement;

/**
 *  The Animal Store has a name (String), options (list of Menageries), 
 *  an inventory (list of ZooAnimal), and an amount of cash on hand, 
 *  measured in pennies (int)
 * 
 *  This class facilitates orders being placed, deliveries being made to the
 *  inventory, and menageries being added to the options.
 */
public class AnimalStore {

	/*
	 * STUDENTS:  YOU MAY NOT ADD ANY OTHER INSTANCE VARIABLES TO THIS CLASS!
	 */
	private String name;
	private SortedListOfImmutables options;    // A list of Menagerie objects	
	private SortedListOfImmutables inventory;  // A list of ZooAnimal objects
	private int cash;

	/**
	 * Standard constructor.  The options and the inventory are both initialized as 
	 * empty lists.  The name and cash amount are set to match the parameters.
	 * 
	 * @param nameIn name of the animal store
	 * @param startingCash cash amount that the restaurant will have, measured
	 * in pennies
	 */
	public AnimalStore(String nameIn, int startingCash) {
		options = new SortedListOfImmutables();
		name = nameIn;
		cash = startingCash;
		inventory = new SortedListOfImmutables();
	}

	/**
	 * Getter for the name of the animal store.
	 * 
	 * @return reference to the name of the animal store
	 */
	public String getName() {
		return name;
		//throw new RuntimeException("You Must Implement This");
		
	}

	/**
	 * Getter for the options.
	 * 
	 * @return a reference to a copy of the options
	 */
	public SortedListOfImmutables getMenu() {
		//Incomplete 4/23
		return new SortedListOfImmutables(options);
		//Needs to be fixed! Make a copy!
		//throw new RuntimeException("You Must Implement This");
		
	}

	/**
	 * Adds an menagerie to the options.
	 * 
	 * @param menagerieToAdd reference to the menagerie to be added to the options
	 */
	public void addMenagerie(Menagerie menagerieToAdd) {
		options.add(menagerieToAdd);
		//throw new RuntimeException("You Must Implement This");
		
	}
	
	/**
	 * Getter for the inventory.
	 * 
	 * @return a reference to a copy of the inventory
	 */
	public SortedListOfImmutables getInventory() {
		//Incomplete 4/23
		return new SortedListOfImmutables (inventory);
		//Not Complete! Make a copy!
		//throw new RuntimeException("You Must Implement This");
		
	}

	/**
	 * Getter for the current amount of cash on hand
	 * 
	 * @return the current amount of cash, measured in pennies
	 */
	public int getCash() {
		return cash;
		//throw new RuntimeException("You Must Implement This");
		
	}

	/**
	 * Checks if the Animal items contained in the specified Menagerie are 
	 * actually contained in the animal store's inventory.
	 * 
	 * @param menagerieIn Menagerie that we are checking against the inventory
	 * @return true if the list of ZooAnimal items contained in the Menagerie are
	 * all present in the inventory, false otherwise.
	 */
	public boolean checkIfInInventory(Menagerie menagerieIn) {
		return inventory.checkAvailability(menagerieIn.getAnimalList());
		//throw new RuntimeException("You Must Implement This");
		
	}

	/**
	 * Adds the specified list of animals to the inventory.  If the 
	 * total wholesale cost of all of the zoo animals combined exceeds 
	 * the amount of cash on hand, then NONE of the zoo animals are added 
	 * to the inventory.  If the amount of cash on hand is sufficient to
	 * pay for the shipment, then the amount of cash on hand is reduced by 
	 * the wholesale cost of the shipment.
	 * 
	 * @param list zoo animals to be added to the inventory
	 * @return true if the zoo animals are added; false if the zoo animals are
	 * not added because their wholesale cost exceeds the current cash
	 * on hand
	 */
	public boolean addShipmentToInventory(SortedListOfImmutables list) {
		if(list.getWholesaleCost() > cash)
		{
			return false;
		}
		else
		{
			inventory.add(list);
			cash -= list.getWholesaleCost();
			return true;
		}
		//throw new RuntimeException("You Must Implement This");
	}

	/**
	 * Removes the zoo animals contained in the specified Menagerie from the inventory.
	 * If the inventory does not contain all of the items required for this
	 * Menagerie, then NOTHING is removed from the inventory.  If the inventory contains
	 * all of the required items, then the amount of cash on hand is INCREASED by
	 * the retail value of the Menagerie.
	 *  
	 * @param menagerie Menagerie that has been ordered
	 * @return true if the zoo animals are removed from the inventory; false
	 * if the zoo animals were not removed because one or more required items
	 * were not contained in the inventory
	 */
	public boolean placeOrder(Menagerie menagerie) {
		if(!inventory.checkAvailability(menagerie.getAnimalList()))
		{
			return false;
		}
		else
		{
			inventory.remove(menagerie.getAnimalList());
			cash += menagerie.getRetailValue();
			return true;
		}
		//throw new RuntimeException("You Must Implement This");
	}

}
