import java.util.Scanner;

public class LoopsPart1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Shape? ");
		String shape = sc.next();

		
		//YOUR CODE STARTS HERE
		if (shape.equalsIgnoreCase("square")){
			System.out.print("Size? ");
			int size = sc.nextInt();
			for (int i = 0; i <= (size-1); i++){
				for(int j = 0; j<= (size-1); j++){
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (shape.equalsIgnoreCase("rectangle")){
			System.out.print("Width? ");
			int width = sc.nextInt();
			System.out.print("Height? ");
			int height = sc.nextInt();
			for(int p = 0; p <= (height-1); p++){
				for(int q = 0; q <= (width-1); q++){
					System.out.print("*");
				}
				System.out.println();
			}
		} else if(shape.equalsIgnoreCase("triangle")){
			System.out.print("Size? ");
			int size = sc.nextInt();
			int width = size;
			for (int i = 0; i <= (size-1); i++){
				for(int j = size; j<= (width); j++){
					System.out.print("*");
				}
				width++;
				System.out.println();
			}
		}
		
		
		
		
		
		//YOUR CODE ENDS HERE

		sc.close();
	}

}
