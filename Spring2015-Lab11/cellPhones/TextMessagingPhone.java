package cellPhones;

public class TextMessagingPhone extends CellPhone {
	//number of messages owner can send and receive
	//REMINDER: private fields cannot be accessed by class which 
	//                extends this class.
	//DO NOT ALTER THIS FIELD'S ACCESS LEVEL
	private int availMessages;
	
	
	public TextMessagingPhone(String owner) {
		//Initialize ownerName as owner and availMessage as 15 by invoking the
		//   two-parameter constructor of this class.
		super(owner);
		availMessages = 15;
		//throw new RuntimeException("Implement me!");
		
	}
	
	public TextMessagingPhone(String owner, int messageLimit) {
		//initialize ownerName as owner and availMessage as messageLimit
		//part of this will require invoking the superclass constructor
		// and then setting the new instance variable
		super(owner);
		availMessages = messageLimit;
		//throw new RuntimeException("Implement me!");
		

		
		
	}
	
	public String receiveText(TextMessagingPhone sender, String message) {
		//The owner receives message from sender.
		
		//decrease the number of messages available to receive
		availMessages--;
		return new String(ownerName+" has received TEXT from "+ sender.ownerName + ":" + message);
		//return a String of the form:
		//    owner's name " has received TEXT from " sender's name ":" message


		//throw new RuntimeException("Implement me!");
		
		
		
	}
	
	public String sendText(TextMessagingPhone receiver, String message) {
		//decrease the number of messages available to send
		availMessages--;
		//return a String by using the receiver to invoke receiveText 
		//  while passing in the current phone and the message
		return new String (receiver.receiveText(this, message));
		
		//throw new RuntimeException("Implement me!");

	}
}
