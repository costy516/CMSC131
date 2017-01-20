package cellPhones;

public class SmartPhone extends TextMessagingPhone {
	
	public SmartPhone(String ownerIn) {
		//Invoke the super class' copy constructor and send it owner
		super(ownerIn);
		//throw new RuntimeException("Implement me!");
		
		
		
		//NOTE: There's nothing else to do since SmartPhone adds no
		//      new fields.

	}
	
	
	
	public String displayPicture(String pictureSubject) {
		//return a String of the form:
		//    owner's name " now displaying picture of " pictureSubject
		return new String(ownerName + " now displaying picture of " + pictureSubject);
		//throw new RuntimeException("Implement me!");
	}
	
	
	/* 
	 * This method OVERRIDES the inherited receiveCall method.
	 * Smartphones "display" a photo of the caller.
	 */
	@Override
	public String receiveCall(CellPhone sender) {
		//return a String built from:
		//    the result of calling displayPicture with the sender's owner's 
		//    name concatenated with a dash and then concatenated with the
		//    result of invoking the superclass' receiveCall with the sender
		return new String(this.displayPicture(sender.ownerName+"-"+this.ownerName)
				+ this.receiveCall(sender));
		//throw new RuntimeException("Implement me!");
	}


		
	public String receivePictureAndTextMessage(
			SmartPhone sender, String messageText, String picDescription) {
		//owner receives messageText from sender with picDescription
		return new String (displayPicture(picDescription)
				+ "-" 
				+ this.receiveText(sender, messageText));
		//return a String built from:
		//    the result of calling displayPicture with the picDescription 
		//    concatenated with a dash and then concatenated with the
		//    result of invoking the receiveText method with the sender
		//    and the messageText

		//throw new RuntimeException("Implement me!");
	}

	

	public String sendPictureAndTextMessage(
			SmartPhone receiver, String messageText, String picDescription) {
		//owner sends messageText to receiver with picDescription
		return new String (receiver.receivePictureAndTextMessage(this, messageText, picDescription));
		//return a String built by having the receiver invoke the
		//   receivePictureAndTextMessage method, sending in the 
		//   current phone, the messageText, and the picture description

		//throw new RuntimeException("Implement me!");
	}
}
