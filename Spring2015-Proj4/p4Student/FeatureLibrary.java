package p4Student;
import p4Utilities.MyDouble;
import p4Utilities.Constants;


public class FeatureLibrary {	
	public static boolean tooBig(Complex value){
		double a = value.getReal().doubleValue();
		double b = value.getImag().doubleValue();
		if((int)(Math.pow(a, 3.0)+Math.pow( b, 7.0))>Constants.BOUNDARY.doubleValue())
		{
			return true;
		}
		else
		{
			return false;
		}
		//throw new RuntimeException("You Must Implement This");
	}

	
	public static int howFar(Complex startingValue) {
		Complex tempValue = new Complex(startingValue.getReal(), startingValue.getImag());
		Complex checker = startingValue;
		int zCount =0;
		while (!tooBig(tempValue) && zCount < Constants.LIMIT)
		{
			checker = tempValue.multiply(tempValue).add(startingValue);
			zCount++;
			tempValue = checker;
		}
		if(zCount == Constants.LIMIT)
		{
			return -1;
		}
		else
		{
			return zCount;
		}
		//throw new RuntimeException("You Must Implement This");
	}

	
	
	
}
