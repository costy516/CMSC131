package PhoneTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cellPhones.CellPhone;
import cellPhones.SmartPhone;
import cellPhones.TextMessagingPhone;

public class ExampleTests {

	@Test
	public void testRegular() {
		CellPhone fred = new CellPhone("F");
		CellPhone charlie = new CellPhone("C");
		assertEquals(
				fred.call(charlie),
				"C is receiving a call from F"
		);
	}

	@Test
	public void testTextMessage() {
		CellPhone fred = new CellPhone("F");
		TextMessagingPhone cindy = new TextMessagingPhone("C's txtphn");
		TextMessagingPhone betsy = new TextMessagingPhone("B's txtphn");
		assertEquals(
				"F is receiving a call from C's txtphn",
				cindy.call(fred)
		);
		assertEquals(
				"B's txtphn is receiving a call from C's txtphn",
				cindy.call(betsy)
		); 
		assertEquals(
				"B's txtphn has received TEXT from C's txtphn:What r u doing?",
				cindy.sendText(betsy, "What r u doing?")
		);
	}

	@Test
	public void testCameraPhone() {
		CellPhone fred = new CellPhone("F");
		TextMessagingPhone betsy = new TextMessagingPhone("B's txtphn");
		SmartPhone pete = new SmartPhone("P's smrtphn");
		SmartPhone susan = new SmartPhone("S's smrtphn");
		assertEquals(
				"S's smrtphn now displaying picture of FunnyPic-"+
				"S's smrtphn has received TEXT from P's smrtphn:LOL.",
				pete.sendPictureAndTextMessage(susan, "LOL.", "FunnyPic")
		);
		assertEquals(
				"B's txtphn has received TEXT from S's smrtphn:ROFL",
				susan.sendText(betsy, "ROFL")
		);
		assertEquals(
				"F is receiving a call from S's smrtphn",
				susan.call(fred)
		);
		assertEquals(
				"S's smrtphn now displaying picture of F-"+
				"S's smrtphn is receiving a call from F",
				fred.call(susan)
		);
		
	}
	
	@Test
	public void testMixedList() {
		ArrayList<CellPhone> listOfPhones = new ArrayList<CellPhone>();

		listOfPhones.add(new CellPhone("F"));
		listOfPhones.add(new TextMessagingPhone("C's txtphn"));
		listOfPhones.add(new SmartPhone("T's camphn"));
		

		CellPhone charlie = new CellPhone("D");
		assertEquals(
				listOfPhones.get(0).call(charlie),
				"D is receiving a call from F"
		);
		assertEquals(
				listOfPhones.get(1).call(charlie),
				"D is receiving a call from C's txtphn"
		);
		assertEquals(
				listOfPhones.get(2).call(charlie),
				"D is receiving a call from T's camphn"
		);
		
	}
}
