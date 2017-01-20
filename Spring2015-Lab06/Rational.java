
public class Rational {
	private final int numer, denom;
	
	//Copy the code body from your Lab05
	public Rational(int numerIn, int denomIn) {
		if (denomIn==0)
		{
			throw new ArithmeticException("Divide by Zero");
		}
		numer = numerIn;
		denom = denomIn;
	}
	
	//The new copy constructor for you to implement.
	public Rational(Rational other) {
		numer = other.getNumer();
		denom = other.getDenom();
	}
	
	//Copy the code body from your Lab05
	public int getNumer() {
		return numer;
	}
	
	//Copy the code body from your Lab05
	public int getDenom() {
		return denom;
	}
	
	//Copy the code body from your Lab05
	public String toString() {
		String str = ""+getNumer()+"/"+getDenom();
		return str;
	}
	
	//Copy the code body from your Lab05
	public Rational reciprocal() {
		Rational reciprocal = new Rational (this.getDenom(), this.getNumer());
		return reciprocal;
	}
	
	//Copy the code body from your Lab05
	public static Rational multiply(Rational first, Rational second) {
		int newNumer = first.getNumer() * second.getNumer();
		int newDenom = first.getDenom() * second.getDenom();
		Rational multiply = new Rational (newNumer, newDenom);
		return multiply;
	}
	
	//Copy the code body from your Lab05
	public Rational divide(Rational otherRational) {
		Rational divide = new Rational ((getNumer()*otherRational.getDenom()),(getDenom()*otherRational.getNumer()));
		return divide;
	}
	
	//Copy the code body from your Lab05
	public Rational add(Rational otherRational) {
		int w = getNumer();
		int x = getDenom();
		int y = otherRational.getNumer();
		int z = otherRational.getDenom();
		Rational add = new Rational (((w*z)+(x*y)),(x*z));
		return add;
	}
	
	//The new subtract method for you to implement.
	public Rational subtract(Rational otherRational) {
		int w = getNumer();
		int x = getDenom();
		int y = otherRational.getNumer();
		int z = otherRational.getDenom();
		Rational subtract = new Rational (((w*z)-(x*y)),(x*z));
		return subtract;
	}
}
