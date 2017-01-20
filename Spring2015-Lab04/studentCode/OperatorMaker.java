package studentCode;
import java.awt.Color;

import cmsc131_squareGridTools.SquareGrid;


public class OperatorMaker {
	/* *************************************************
	 * Draws a single Operator into the already created grid
	 * that is passed as the first parameter to the drawOp
	 * method according to the symbol selection passed as the 
	 * second parameter.
	 * 
	 * It accomplishes this by calling the appropriate
	 * helper method and passing the grid into that.	
	 * 
	 * All of the methods are static and have a parameter of
	 * type SquareGrid.
	 * 
	 * Each method can determine how "big" the operator is
	 * by making use of grid.getHt() to find out the size
	 * of the SquareGrid that was passed in.
	 * *************************************************/

	
	public static void drawOp(SquareGrid grid, int symbol) {
		//Your code here will essentially be a chain of if-else statements
		//  that call the appropriate helper and pass in grid.
		if (symbol == 1)
		{
			helperMinus(grid);
		}
		else if (symbol == 2)
		{
			helperPlus(grid);
		}
		else if (symbol == 3)
		{
			helperDivide(grid);
		}
		else if (symbol == 4)
		{
			helperMultiply(grid);
		}
	}
	
	
	
	

	/*
	 * The helper methods you need to write are indicated below.
	 * 
	 * You may add more helper methods if you want, but they 
	 * all need to be static as well.	
	 * 
	 * You will be using for loops here but you should also
	 * think about how one helper method might be able to make
	 * use of calling other helper methods that you have written.
	 * 
	 * In addition to the getHt() method, you'll be using the setColor
	 * method.  The way you'll use this will appear similar to
	 *    grid.setColor(row, column, Color.BLUE);
     * where you'll indicate the correct row and column and this 
     * line of code would then set that position in the grid to be
     * the color blue.
     * 
	 * Start by implementing the minus helper and testing that on
	 * your computer and on the submit server, then move on to each 
	 * remaining symbol in turn.
	 * 
	 * To run the program on your computer, you'll need to open the
	 * ExampleDriver.java file and run from there.  You do not change
	 * that file in any way.  All changes are done in this file.
	 * 
	 */
	
	private static void helperMinus(SquareGrid grid){
		int midHeight = (grid.getHt()/2);
		int width = (grid.getWd()-1);
		for (int col = width; col>=0; col--)
		{
			grid.setColor(midHeight, col, Color.BLUE);
		}
	}

	private static void helperPlus(SquareGrid grid){
		int height = (grid.getHt()-1);
		int width = (grid.getWd()-1);
		int midHeight = (grid.getHt()/2);
		int midWidth = (grid.getWd()/2);
		for (int col = width; col>=0; col--)
		{
			grid.setColor(midHeight, col, Color.BLUE);
		}
		for (int row = height; row>=0; row--)
		{
			grid.setColor(row, midWidth, Color.BLUE);
		}
	}

	private static void helperDivide(SquareGrid grid){
		int height = (grid.getHt()-1);
		int width = (grid.getWd()-1);
		for (int row = 0; row<=height; row++)
		{
			grid.setColor(row, width, Color.BLUE);
			width--;
		}
	}

	private static void helperMultiply(SquareGrid grid){
		int height = (grid.getHt()-1);
		int width = (grid.getWd()-1);
		int midHeight = (grid.getHt()/2);
		int midWidth = (grid.getWd()/2);
		int widthTemp = width;
		for (int col = width; col>=0; col--)
		{
			grid.setColor(midHeight, col, Color.BLUE);
		}
		for (int row = height; row>=0; row--)
		{
			grid.setColor(row, midWidth, Color.BLUE);
		}
		for (int row = 0; row<=height; row++)
		{
			grid.setColor(row, widthTemp, Color.BLUE);
			widthTemp--;
		}
		for (int row = height; row>=0; row--)
		{
			grid.setColor(row, width, Color.BLUE);
			width--;
		}
	}

	
}

