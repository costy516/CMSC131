
public class NumberList {

	public int[] values;  
	
	//Constructor for an empty list (provided for you)
	public NumberList() {
		values = new int[0];
	}
	
	//Constructor passed in an array - don't just copy the reference!
	public NumberList(int[] a) {
		values = new int[a.length];
		for(int checker = 0; checker < a.length; checker++)
		{
			values[checker] = a[checker];
		}
		//YOUR CODE HERE
		//throw new RuntimeException("Not yet implemented...");
		
	}
	
	//Copy constructor
	//  (code provided for you but uses your array-based constructor)
		public NumberList(NumberList original) {
			this(original.values);

	}
	
	//Size getter
	public int getSize() {
		return this.values.length;
		//YOUR CODE HERE
		//throw new RuntimeException("Not yet implemented...");
		
		
	}
	
	//Single-value getter
	public int getAt(int index) {
		return values[index];
		//YOUR CODE HERE
		//throw new RuntimeException("Not yet implemented...");
		
	}
	
	//Process the values to get the sum
	public long getSum() {
		int result = 0;
		for(int adder = 0; adder < values.length; adder++)
		{
			result += values[adder];
		}
		return result;
		//YOUR CODE HERE
		//throw new RuntimeException("Not yet implemented...");
		
	}
	
	//See if the given value is anywhere within the array
	public boolean contains(int searchVal) {
		boolean found = false;
		if(values == null)
		{
			return found; //HINT PART 1!!!
		}
		else 
		{
			for(int checker = 0; checker < values.length; checker++)
			{
				if(values[checker] == searchVal)
				{
					found = true;
				}
			}
		}
		

		//YOUR CODE HERE
		
		
		
		return found; //HINT PART 2!!!
	}
	
	//Add a new element at the end of the list - the array must "grow" somehow first!
	public void add(int newValue) {
		int[] newBiggerArray = new int[values.length + 1];
		for(int integrate = 0; integrate < newBiggerArray.length; integrate++)
		{
			if(integrate == newBiggerArray.length-1)
			{
				newBiggerArray[integrate] = newValue;
			}
			else
			{
				newBiggerArray[integrate] = values[integrate];
			}
		}
		values = newBiggerArray;
		//YOUR CODE HERE - THINK ABOUT HOW TO USE THE ARRAY CREATED ABOVE
		
		
		

	}
	
}
