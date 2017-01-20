
public class Rational {
	private int numer, denom;
	//DATA FIELDS SHOULD GO UP HERE
	
	
	//Constructor
	public Rational(int numerIn, int denomIn) {
		numer = numerIn;
		denom = denomIn;
		
		//Remove the below line when you are ready to implement this method.
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	
	
	
	//Getters
	public int getNumer() {
		return numer;
		//Remove the below line when you are ready to implement this method.
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public int getDenom() {
		return denom;
		//Remove the below line when you are ready to implement this method.
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	
	
	
	
	
	public String toString() {
		String str = ""+getNumer()+"/"+getDenom();
		return str;
		//Remove the below line when you are ready to implement this method.
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	
	
	

	public static Rational multiply(Rational a, Rational b) {
		int newNumer = a.getNumer() * b.getNumer();
		int newDenom = a.getDenom() * b.getDenom();
		Rational c = new Rational (newNumer, newDenom);
		return c;
		//Remove the below line when you are ready to implement this method.
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	
	
	
	
	public Rational reciprocal() {
		Rational reciprocal = new Rational (getDenom(), getNumer());
		return reciprocal;
		//Remove the below line when you are ready to implement this method.
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public Rational divide(Rational a) {
		Rational divide = new Rational ((getNumer()*a.getDenom()),(getDenom()*a.getNumer()));
		return divide;
		//Remove the below line when you are ready to implement this method.
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public Rational add(Rational a) {
		int w = getNumer();
		int x = getDenom();
		int y = a.getNumer();
		int z = a.getDenom();
		Rational add = new Rational (((w*z)+(x*y)),(x*z));
		return add;
		//Remove the below line when you are ready to implement this method.
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	
	//NOTE: We are not writing an equals method for this class at this time.
	//      For this reason, do not use assertEquals to try to test whether
	//      two Rational objects are equal in value.
	
}
