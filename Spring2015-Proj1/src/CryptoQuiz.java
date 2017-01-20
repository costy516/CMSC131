
import java.util.Scanner;

public class CryptoQuiz {
	
	private static int 
		NUM_BITS1, 
		NUM_BITS2, 
		NUM_BITS3, 
		NUM_BITS4;
	
	private static String 
		CRYPT1,
		CRYPT2,
		CRYPT3, 
		CRYPT4;

	private static String 
		promptInitialChoice, 
		promptSelectBITs, 
		promptWhichSystemPart1,
		promptWhichSystemPart2, 
		promptSelectSystem, 
		promptHowManyBITsPart1,
		promptHowManyBITsPart2,
		feedbackInvalidChoice, 
		feedbackCorrect,
		feedbackIncorrect;
	

	//CODE ABOVE HERE IS GIVEN TO YOU - DO NOT ALTER IT

	
	
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		


		
		//Initialize the quiz Q&A values, storing the values in the
		//  variables that were defined for you earlier in the code above.
		NUM_BITS1 = 64; 
		NUM_BITS2 = 128; 
		NUM_BITS3 = 168; 
		NUM_BITS4 = 768;
	
		CRYPT1 = "Blowfish";
		CRYPT2 = "Rijndael";
		CRYPT3 = "TripleDES"; 
		CRYPT4 = "RSA";
		String temp = "";

		//Ask what language they would like to use.
		System.out.print("1) English 2) Espanol: ");
		
		
		//Based on the language selected above, set prompt and feedback 
		//  variables in that language.
		if (myScanner.nextInt() == 1){
			promptInitialChoice= "Enter 1 to guess a crypto system, 2 to guess how many BITs: "; 
			promptSelectBITs="Select number of BITs: " ;
			promptWhichSystemPart1="How many BITs are used in a CRYPT system? ";
			promptWhichSystemPart2="";
			promptSelectSystem= "Select a crypto system: ";
			promptHowManyBITsPart1= "Which crypto system uses N BITs? ";
			promptHowManyBITsPart2 = "";
			feedbackInvalidChoice= "Invalid choice."; 
			feedbackCorrect= "Correct!";
			feedbackIncorrect= "Incorrect!";
		}
		else{
			promptInitialChoice= "Presione el numero 1 para adivinar un sistema de codificacion criptografica, 2 para adivinar la cantidad de BITS: "; 
			promptSelectBITs="Seleccione el numero de BITs: " ;
			promptWhichSystemPart1="Cuantos BITs son utilizados en un sistema CRYPT? ";
			promptWhichSystemPart2="";
			promptSelectSystem= "Seleccione un sistema de codificacion criptografica: ";
			promptHowManyBITsPart1= "Que sistema de codificacion criptografica utiliza N BITs? ";
			promptHowManyBITsPart2 = "";
			feedbackInvalidChoice= "Opcion invalida."; 
			feedbackCorrect= "Correcto!";
			feedbackIncorrect= "Incorrecto!";
		}


		//Perform the quiz!
		System.out.print(promptInitialChoice);
		int answInitial = myScanner.nextInt();
		if(answInitial == 1){
			System.out.print(promptSelectBITs);
			temp = ""+myScanner.nextInt();
			if(temp.equals("" + NUM_BITS1)
					|| temp.equals("" + NUM_BITS2)
					|| temp.equals("" + NUM_BITS3)
					|| temp.equals("" + NUM_BITS4)){
				System.out.print(promptHowManyBITsPart1.replace("N",temp));
				myScanner.nextLine();
				String answ1 = myScanner.nextLine();
				if((answ1.equalsIgnoreCase(CRYPT1) && temp.equals("" + NUM_BITS1)) 
					|| (answ1.equalsIgnoreCase(CRYPT2) && temp.equals("" + NUM_BITS2))
					|| (answ1.equalsIgnoreCase(CRYPT3) && temp.equals("" + NUM_BITS3))
					|| (answ1.equalsIgnoreCase(CRYPT4) && temp.equals("" + NUM_BITS4))){
					System.out.print(feedbackCorrect);
				} else{
					System.out.print(feedbackIncorrect);
				}
			} else{
				System.out.print(feedbackInvalidChoice);
			}
		} else if (answInitial == 2){
			System.out.print(promptSelectSystem);
			myScanner.nextLine();
			temp= myScanner.nextLine();
			if	(temp.equalsIgnoreCase(CRYPT1)
					|| temp.equalsIgnoreCase(CRYPT2)
					|| temp.equalsIgnoreCase(CRYPT3)
					|| temp.equalsIgnoreCase(CRYPT4)){
				System.out.print(promptWhichSystemPart1.replace("CRYPT",temp));
				String answ1 = ""+myScanner.nextInt();
				if((answ1.equals(""+NUM_BITS1) && temp.equalsIgnoreCase(CRYPT1))
					|| (answ1.equals(""+NUM_BITS2) && temp.equalsIgnoreCase(CRYPT2))
					|| (answ1.equals(""+NUM_BITS3) && temp.equalsIgnoreCase(CRYPT3))
					|| (answ1.equals(""+NUM_BITS4) && temp.equalsIgnoreCase(CRYPT4))){
					System.out.print(feedbackCorrect);
				} else{
					System.out.print(feedbackIncorrect);
				}
			} else{
				System.out.print(feedbackInvalidChoice);
			}
		}
		myScanner.close();
	}
}
