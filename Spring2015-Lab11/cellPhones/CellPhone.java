package cellPhones;

public class CellPhone {

	//REMINDER: protected fields can be accessed directly by any
	//          class which extends this one
	protected String ownerName;




	public CellPhone(String ownerNameIn) {
		//initialize ownerName as ownerNameIn
		ownerName = ownerNameIn;
		//throw new RuntimeException("Implement me!");
		
	}

	public String receiveCall(CellPhone sender) {
		//return a String of the form:
		//    owner's name " is receiving a call from " sender's name
		return new String (ownerName+ " is receiving a call from " + sender.ownerName);
		//throw new RuntimeException("Implement me!");
		
	}

	public String call(CellPhone receiver) {
		//return a String by using the receiver to invoke receiveCall 
		//  while passing in the current phone
		return (receiver.receiveCall(this));
		//throw new RuntimeException("Implement me!");
		
		
	}
}
