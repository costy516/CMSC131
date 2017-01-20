
public class Lab07 {

/**
 * A static method that is passed a reference to an array of integers, 
 * where the reference could be null, and if not then where the  
 * length of the array isn't known in advance, and the integers in 
 * the array can be of any value.
 * 
 * If all of the values are between 1 and 10 (inclusive) then the method
 * returns an array of size 10 where the i_th position of that array 
 * tells you how many times the value i+1 appeared in the parameter array.
 * For example, the [0] position tells you how many 1s appeared.
 * 
 * If any of the values are outside the range the method will throw a 
 * new RuntimeException with the message "Ooops. Sorry about that." inside 
 * its message.  The way it does this is that as you go through the elements
 * of the parameter array and try to increment retArr[value-1] if the value
 * isn't between 1 and 10 then Java's ArrayIndexOutOfBoundsException will be 
 * thrown by Java - if you put the loop inside a try block then it's more
 * efficient because you don't have to test before each increment attempt 
 * and you can let the try/catch deal with things.
 * 
 * @param arrayIn array of integers
 * @return an array of size 10 representing the tally
*/
		public static int[] tallyArray(int[] arrayIn) throws RuntimeException {
			int[] retArr = new int[10];
			
			//Your code goes here...
			boolean validNumber = false;
			if(arrayIn == null)
			{
				return retArr;
			}
			else{
				for(int arrayInIndex = 0; arrayInIndex < arrayIn.length; arrayInIndex++)
				{
					for (int retArrIndex = 0; retArrIndex< 10; retArrIndex++)
					{
						if(arrayIn[arrayInIndex] == (retArrIndex+1))
						{
							retArr[retArrIndex]++;
							validNumber = true;
						}
					}
					if(!validNumber)
					{
						throw new RuntimeException("Ooops. Sorry about that.");
					}
					validNumber = false;
				}
				return retArr;
			}
		}
	

}
