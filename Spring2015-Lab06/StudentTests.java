import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {
	
	//This is a place for you to practice writing some JUnit tests and
	//   get help from us or your peers if needed.
	
	

	@Test
	public void testAllOperatorsUsingDenomOfOne() {
		Rational r1 = new Rational (4,1);
		Rational r2 = new Rational (5,1);
		//Reciprocal
		Rational expected = new Rational (1,4);
		Rational result = r1.reciprocal();
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
		//Multiply
		expected = new Rational (20,1);
		result = Rational.multiply(r1, r2);
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
		//Divide
		expected = new Rational (4,5);
		result = r1.divide(r2);
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
		//Add
		expected = new Rational (9,1);
		result = r1.add(r2);
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
		//Subtract
		expected = new Rational (-1,1);
		result = r1.subtract(r2);
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
	}
	

	@Test
	public void testReciprocal() {
		Rational r1 = new Rational (3,5);
		Rational expected = new Rational (5,3);
		Rational result = r1.reciprocal();
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
	}
	
	
	@Test
	public void testMultiply() {
		Rational r1 = new Rational (3,5);
		Rational r2 = new Rational (6,9);
		Rational expected = new Rational (18,45);
		Rational result = Rational.multiply(r1, r2);
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
	}
	
	
	@Test
	public void testDivide() {
		Rational r1 = new Rational (3,5);
		Rational r2 = new Rational (6,9);
		Rational expected = new Rational (27,30);
		Rational result = r1.divide(r2);
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
	}
	
	
	@Test
	public void testAdd() {
		Rational r1 = new Rational (3,5);
		Rational r2 = new Rational (6,9);
		Rational expected = new Rational (57,45);
		Rational result = r1.add(r2);
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
	}
	
	
	@Test
	public void testSubtract() {
		Rational r1 = new Rational (3,5);
		Rational r2 = new Rational (6,9);
		Rational expected = new Rational (-3,45);
		Rational result = r1.subtract(r2);
		assertTrue((result.getNumer()==expected.getNumer())&&(result.getDenom()==expected.getDenom()));
	}

	@Test
	public void testConstructorOnDivideByZero() {
		try {
		     Rational rationalNum = new Rational(5, 0);
		     fail(); //If you get to this line of code, something went wrong.
		  }
		  catch (ArithmeticException e) {
		     //Nothing really needed here for this test since we
		     //  WANT this exception caught for the test to pass.
		  }
	}
	
	
}

