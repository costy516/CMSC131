package p4Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import p4Student.Complex;
import p4Student.FeatureLibrary;
import p4Utilities.MyDouble;

public class StudentTests {

	public void testStringHelper(double real, double imag, String str) {
		Complex complexValue=
				new Complex(new MyDouble(real), new MyDouble(imag));

		assertEquals(complexValue.toString(), str);
	}

	@Test
	public void testString() {
		//YOU PUT YOUR SPECIFICS OF WHAT TO TEST DOWN HERE, USING THE HELPER
		//FOR EXAMPLE: 
		testStringHelper(5.3, 2, "5.3+2i");

	}



	public void testAdditionHelper(
			double real1, double imag1, 
			double real2, double imag2,
			double real3, double imag3) {

		Complex first=
				new Complex(new MyDouble(real1), new MyDouble(imag1));
		Complex second=
				new Complex(new MyDouble(real2), new MyDouble(imag2));
		Complex sum=
				new Complex(new MyDouble(real3), new MyDouble(imag3));

		assertEquals(first.add(second), sum);
	}


	@Test
	public void testAdd() {
		//YOU PUT YOUR SPECIFICS OF WHAT TO TEST DOWN HERE, USING THE HELPER
		//FOR EXAMPLE: 
		testAdditionHelper(23.4, 23.5, 235.53, 527.24, 258.93, 550.74);	
	}




	public void testParsingHelper(String str, double real, double imag) {
		Complex parseResult=
				Complex.parseComplex(str);
		Complex correctResult=
				new Complex(new MyDouble(real), new MyDouble(imag));

		assertEquals(correctResult, parseResult);
	}

	@Test
	public void testParse() {
		//YOU PUT YOUR SPECIFICS OF WHAT TO TEST DOWN HERE, USING THE HELPER
		//FOR EXAMPLE: 
		testParsingHelper("1+2i", 1, 2);
	}
	
	
	
	
	//Just some tests for you to try out on the FeatureLibrary methods

	public void testTooBigHelper(double real1, double imag1, boolean result) {
		Complex num = new Complex(new MyDouble(real1), new MyDouble(imag1));
		assertEquals(result, FeatureLibrary.tooBig(num));
	}
	
	@Test
	public void testTooBig() {
		testTooBigHelper(3, 4, false);
		testTooBigHelper(32, 64, true);
	}
	
	
	
	
	
	public void testHowFarHelper(double real1, double imag1, int result) {
		Complex num = new Complex(new MyDouble(real1), new MyDouble(imag1));
		assertEquals(result, FeatureLibrary.howFar(num));
	}
	
	@Test
	public void testHowFar() {
		testHowFarHelper(3, 4, 1);
		testHowFarHelper(32, 64, 0);
		testHowFarHelper(1.1, 1.1, 2);
		testHowFarHelper(0.4, 0.4, 11);
		testHowFarHelper(0.12, 0.6, -1);
	}
	
//	@Test
//	public void testDivide(){
//		testDivideHelper();
//	
//	}
//	public void testDivideHelper(){
//		Complex c1 = new Complex (new MyDouble(5),new MyDouble(9));
//		Complex c2 = new Complex (new MyDouble(3), new MyDouble(2));
//		Complex result = c1.divide(c2);
//		Complex expected = new Complex (new MyDouble((double)(33/13.0)), new MyDouble((double)(17/13.0)));
//		assertEquals(expected, result);
//	}
	
	
}
