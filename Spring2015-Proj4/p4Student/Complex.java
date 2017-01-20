package p4Student;
import p4Utilities.MyDouble;

public class Complex 	
{

	//STUDENTS:  You may NOT add any further instance or static fields!
	//These two fields will be final so must be initialized by the constructors.
	private final MyDouble real;
	private final MyDouble imag;


	/* STUDENTS: Put your methods here, as described in the project description.
	 * 	 
	 * IMPORTANT:  You may NOT call the toString method for the MyDouble class except
	 * while you are writing the toString method for the Complex class.  You may NOT
	 * call the toString method of the Complex class ANYWHERE.  If you don't adhere
	 * to this rule, you will fail some (or possibly all) release tests. */


	public Complex (MyDouble realIn, MyDouble imagIn) 
	{
		real = realIn;
		imag = imagIn;
		numberCreated++;
		//throw new RuntimeException("You Must Implement This");
	}

	public Complex (MyDouble realIn)
	{
		real = realIn;
		imag = new MyDouble(0);
		numberCreated++;
		//throw new RuntimeException("You Must Implement This");
	}

	public Complex (Complex orig) 
	{
		real = orig.getReal();
		imag = orig.getImag();
		numberCreated++;
		//throw new RuntimeException("You Must Implement This");
	}


	public MyDouble getReal () 
	{
		return this.real;
		//throw new RuntimeException("You Must Implement This");
	}

	public MyDouble getImag () 
	{
		return this.imag;
		//throw new RuntimeException("You Must Implement This");
	}

	public Complex add (Complex param) 
	{
		MyDouble realIn = new MyDouble(real.add(param.getReal()));
		MyDouble imagIn = new MyDouble(imag.add(param.getImag()));
		Complex add = new Complex(realIn, imagIn);
		return add;
		//throw new RuntimeException("You Must Implement This");
	}

	public Complex subtract (Complex param) 
	{
		MyDouble realIn = new MyDouble(real.subtract(param.getReal()));
		MyDouble imagIn = new MyDouble(imag.subtract(param.getImag()));
		Complex subtract = new Complex(realIn, imagIn);
		return subtract;
		//throw new RuntimeException("You Must Implement This");
	}

	public Complex multiply (Complex param) 
	{
		MyDouble negOne = new MyDouble (-1);
		MyDouble realIn = new MyDouble((real.multiply(param.getReal())).add(((imag).multiply(param.getImag())).multiply(negOne)));
		MyDouble imagIn = new MyDouble((real.multiply(param.getImag())).add(imag.multiply(param.getReal())));
		Complex multiply = new Complex(realIn, imagIn);
		return multiply;
		//throw new RuntimeException("You Must Implement This");
	}

	public Complex divide (Complex param) 
	{
		MyDouble denom = new MyDouble(param.getReal().multiply(param.getReal()).add(param.getImag().multiply(param.getImag())));
		MyDouble realIn = new MyDouble((this.getReal().multiply(param.getReal()).add((this.getImag().multiply(param.getImag())))).divide(denom));
		MyDouble imagIn = new MyDouble((this.getImag().multiply(param.getReal()).subtract(this.getReal().multiply(param.getImag()))).divide(denom));
		Complex divide = new Complex(realIn, imagIn);
		return divide;
		
		//throw new RuntimeException("You Must Implement This");
	}
	
	public Complex conjugate (Complex denom) 
	{
		MyDouble negOne = new MyDouble (-1);
		MyDouble realIn = new MyDouble(denom.getReal());
		MyDouble imagIn = new MyDouble(denom.getImag().multiply(negOne));
		Complex conjugate = new Complex(realIn, imagIn);
		return conjugate;
	}


	public int compareTo (Complex param) 
	{
		return (this.norm()).compareTo(param.norm());
		//throw new RuntimeException("You Must Implement This");
	}

 
	public String toString () 
	{
		String str = ""+getReal()+""+((getImag().doubleValue()<0.0)?"":"+")+""+getImag()+"i";	
		return str;
		//throw new RuntimeException("You Must Implement This");
	}





	public MyDouble norm ()
	{
		MyDouble norm = ((imag.square()).add(real.square())).sqrt();
		return norm;
		//throw new RuntimeException("You Must Implement This");
	}




	public static Complex parseComplex (String thingToParse) 
	{
		thingToParse = thingToParse.replace(" ","");
		String realIn = "", imagIn = "";
		int secondSymbol = (thingToParse.contains("+"))?(thingToParse.indexOf('+',0)):(thingToParse.indexOf('-',1));
		boolean plus = (thingToParse.charAt(secondSymbol) == '+');
		realIn = (thingToParse.substring(0, secondSymbol));
		imagIn = (plus)?(thingToParse.substring(secondSymbol+1, thingToParse.length())):(thingToParse.substring(secondSymbol, thingToParse.length()));
		imagIn = imagIn.replace("i", "");
		return new Complex ( MyDouble.parseDouble(realIn), MyDouble.parseDouble(imagIn));
		
	}
	






















	//Code below is provided.  Do not change or even look at for now...

	public static long getNumberCreated() {
		return numberCreated;
	}

	

	public boolean equals (Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			Complex casted = (Complex)other;
			return this.real.equals(casted.real)&&this.imag.equals(casted.imag);
		}
	}



	private static long numberCreated = 0;




}
