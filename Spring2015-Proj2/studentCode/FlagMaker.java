package studentCode;

import java.awt.Color;
import cmsc131_GridTools.MyGrid;


public class FlagMaker {
	
	/*This drawExample method provided colors the grid for a flag 
	 * (one that is not the flag of any country - not any I know of anyway).
	 * The code provided here is also not a correct error flag - it is just
	 * provided to help you see how you can color in the flag you are given by
	 * the driver.
	 */
	private static void drawExample(MyGrid grid){
		grid.setColor(0, 0, Color.BLUE);
		grid.setColor(0, grid.getWd()-1, Color.BLUE);

		grid.setColor(1, 1, Color.RED);
		grid.setColor(1, grid.getWd()-2, Color.RED);

		grid.setColor(grid.getHt()-1, 0, Color.GREEN);
		grid.setColor(grid.getHt()-1, grid.getWd()-1, Color.GREEN);

		grid.setColor(grid.getHt()-2, 1, Color.YELLOW);
		grid.setColor(grid.getHt()-2, grid.getWd()-2, Color.YELLOW);
	}

	
	

	/*
	 * The following helper method is provided as an example of the ones
	 * that you will be writing.  This one specifically draws the star that
	 * is needed by the flags of Somalia and Vietnam and Senegal.  
	 * 
	 * For starters, just use it.  However, later in your project work tracing
	 * this code to see how it works might be very useful before attempting to
	 * write your own code for anything involving diagonal lines.
	 */
	private static void helperCenterStar(MyGrid grid, Color theColor) {
		int middleX = grid.getWd()/2;
		int middleY = grid.getHt()/2;
		
		//Do the left side of things
		for (int radius=0; radius<middleY-3; radius++) {
			//The left leg
			grid.setColor(middleY+radius, middleX-radius-1, theColor);
			grid.setColor(middleY+radius, middleX-radius, theColor);
			
			//The right leg
			grid.setColor(middleY+radius, middleX+radius-1, theColor);
			grid.setColor(middleY+radius, middleX+radius, theColor);
			
			//The arms
			grid.setColor(middleY, middleX+radius, theColor);
			grid.setColor(middleY, middleX-radius-1, theColor);
			
			//The head
			grid.setColor(middleY-radius, middleX-1, theColor);
			grid.setColor(middleY-radius, middleX, theColor);
		} 
	}
	
	
	
	
	/*
	 * As you start the project, you'll need to implement the following 
	 * helper method.  It needs to set the color of every position in
	 * the grid to the color passed in as the parameter.
	 */
	private static void helperSolid(MyGrid grid, Color theColor) 
	{
		//You'll need to add code here...
		int height = (grid.getHt()-1);
		int width = (grid.getWd()-1);
		for(int row=height; row>=0; row--)
		{
			for(int column=width; column>=0; column--)
			{
				grid.setColor(row, column, theColor);
			}
		}
		
	}
	private static void helperTopHalfSolid(MyGrid grid, Color theColor)
	{
		int halfHeight = ((grid.getHt()/2)-1);
		int width = (grid.getWd()-1);
		for(int row=halfHeight; row>=0; row--)
		{
			for(int column=width; column>=0; column--)
			{
				grid.setColor(row, column, theColor);
			}
		}
	}
	private static void helperTopThrdSolid(MyGrid grid, Color theColor)
	{
		int thirdHeight = ((grid.getHt()/3));
		int width = (grid.getWd()-1);
		for(int row=thirdHeight; row>=0; row--)
		{
			for(int column=width; column>=0; column--)
			{
				grid.setColor(row, column, theColor);
			}
		}
	}
	private static void helperMidThrdSolid(MyGrid grid, Color theColor)
	{
		int topThirdHeight = ((grid.getHt()/3));
		int midThirdHeight = (((grid.getHt()/3)*2)-1);
		int width = (grid.getWd()-1);
		for(int row=midThirdHeight; row>=topThirdHeight; row--)
		{
			for(int column=width; column>=0; column--)
			{
				grid.setColor(row, column, theColor);
			}
		}
	}
	private static void helperLeftThrdSolid(MyGrid grid, Color theColor)
	{
		int height = grid.getHt()-1;
		int leftWidth = (grid.getWd()/3);
		for(int row=height; row>=0; row--)
		{
			for(int column=leftWidth; column>=0; column--)
			{
				grid.setColor(row, column, theColor);
			}
		}
	}
	private static void helperMidThrdWidSolid(MyGrid grid, Color theColor)
	{
		int height = grid.getHt()-1;
		int leftWidth = (grid.getWd()/3);
		int midWidth = (((grid.getWd()/3)*2)-1);
		for(int row=height; row>=0; row--)
		{
			for(int column=midWidth; column>=leftWidth; column--)
			{
				grid.setColor(row, column, theColor);
			}
		}
	}
	private static void helperMidHorizontalLn(MyGrid grid, Color theColor)
	{
		int midHeight = (grid.getHt()/2);
		int width = (grid.getWd()-1);
		for (int column=width; column>=0; column--)
		{
			grid.setColor(midHeight, column, theColor);
		}
	}
	private static void helperHalfDiamond(MyGrid grid, Color theColor)
	{
		int height = (grid.getHt()-1);
		int startRow = 0;
		int column =0;
		while(height>=startRow)
		{
			for(int row=startRow; row<=height; row++)
			{
				grid.setColor(row, column, theColor);
			}
			height--;
			startRow++;
			column++;
		}
	}
	private static void helperMidVerticalLn(MyGrid grid, Color theColor)
	{
		int height = (grid.getHt()-1);
		int midWidth = ((grid.getWd()/2)-1);
		for (int column=midWidth; column<=(midWidth+1); column++)
		{
			for(int row = height; row>=0; row--)
			{
				grid.setColor(row, column, theColor);
			}
		}
	}
	private static void helperFowardSlash(MyGrid grid, Color theColor)
	{
		int height = (grid.getHt()-1);
		int width = (grid.getWd()-1);
		for(int row = height; row>=0; row--)
		{
			for(int column = width; column>=(width-1); column--){
				grid.setColor(row, column, theColor);
			}
			width -= 2;
		}
	}
	private static void helperBackSlash(MyGrid grid, Color theColor)
	{
		int height = (grid.getHt()-1);
		int width = (grid.getWd()-1);
		for(int row = 0; row<=height; row++)
		{
			for(int column = width; column>=(width-1); column--){
				grid.setColor(row, column, theColor);
			}
			width -= 2;
		}
	}
	/*
	 * This is an example of what the draw method for a particular flag 
	 * will tend to look like.  For this example to work, you need to 
	 * implement the body of the helperSolid method above.
	 */
	private static void drawSomalia(MyGrid grid)
	{
		helperSolid(grid, Color.BLUE);
		helperCenterStar(grid, Color.WHITE);		
	}
	private static void drawVietnam(MyGrid grid) 
	{
		helperSolid(grid, Color.RED);
		helperCenterStar(grid, Color.YELLOW);
		
	}
	private static void drawIndoesia(MyGrid grid) 
	{
		helperSolid(grid, Color.WHITE);
		helperTopHalfSolid(grid, Color.RED);
	}
	private static void drawPoland(MyGrid grid) 
	{
		helperSolid(grid, Color.RED);
		helperTopHalfSolid(grid, Color.WHITE);
		
	}
	private static void drawEstonia(MyGrid grid) 
	{
		helperSolid(grid, Color.WHITE);
		helperTopThrdSolid(grid, Color.BLUE);
		helperMidThrdSolid(grid, Color.BLACK);
	}
	private static void drawBolivia(MyGrid grid) 
	{
		helperSolid(grid, Color.GREEN);
		helperTopThrdSolid(grid, Color.RED);
		helperMidThrdSolid(grid, Color.YELLOW);
	}
	private static void drawFrance(MyGrid grid) 
	{
		helperSolid(grid, Color.RED);
		helperLeftThrdSolid(grid, Color.BLUE);
		helperMidThrdWidSolid(grid, Color.WHITE);
	}
	private static void drawSenegal(MyGrid grid) 
	{
		helperSolid(grid, Color.RED);
		helperLeftThrdSolid(grid, Color.GREEN);
		helperMidThrdWidSolid(grid, Color.YELLOW);
		helperCenterStar(grid, Color.GREEN);
	}
	private static void drawBahamas(MyGrid grid) 
	{
		helperSolid(grid, Color.CYAN);
		helperMidThrdSolid(grid, Color.YELLOW);
		helperHalfDiamond(grid, Color.BLACK);
	}
	private static void drawMacedonia(MyGrid grid)
	{
		helperSolid(grid, Color.RED);
		helperMidHorizontalLn(grid, Color.YELLOW);
		helperMidVerticalLn(grid, Color.YELLOW);
		helperBackSlash(grid, Color.YELLOW);
		helperFowardSlash(grid, Color.YELLOW);
	}
	private static void drawError(MyGrid grid) 
	{
		grid.setColor(0, 0, Color.RED);
		grid.setColor(0, (grid.getWd()-1), Color.RED);
		grid.setColor((grid.getHt()-1), (grid.getWd()-1), Color.RED);
		grid.setColor((grid.getHt()-1), 0, Color.RED);
	}
	
	

	
	

	/* The skeleton given here just calls an example flag to be put into the 
	 * grid passed as the first parameter. (note: In its current form it is
	 * ignoring the second parameter.)
	 * 
	 * You need to modify this method so that the correct flag (the one that
	 * corresponds to the country code passed as the second parameter) 
	 * is colored correctly in the grid passed in as the first parameter.
	 * Note: you can assume the grid is already created an waiting for you
	 * to put the correct colors into the correct squares.  You can also 
	 * assume that the method that calls the one you are writing here will
	 * take care of actually displaying the flag - you do not need to do 
	 * anything about that.
	 */
	public static void drawFlag(MyGrid grid, int countryCode) 
	{
		if (countryCode==1 && grid.getHt()%2==1 && grid.getHt()>=9)
		{
			drawSomalia(grid);
		}
		else if (countryCode==2 && grid.getHt()%2==1 && grid.getHt()>=9)
		{
			drawVietnam(grid);
		}
		else if (countryCode==3 && grid.getHt()%2==0)
		{
			drawIndoesia(grid);
		}
		else if (countryCode==4 && grid.getHt()%2==0)
		{
			drawPoland(grid);
		}
		else if (countryCode==5 && grid.getHt()%3==0)
		{
			drawEstonia(grid);
		}
		else if (countryCode==6 && grid.getHt()%3==0)
		{
			drawBolivia(grid);
		}
		else if (countryCode==7 && grid.getWd()%3==0)
		{
			drawFrance(grid);
		}
		else if (countryCode==8 && grid.getWd()%3==0 && grid.getHt()%2==1 && grid.getHt()>=9)
		{
			drawSenegal(grid);
		}
		else if (countryCode==9 && grid.getHt()%3==0)
		{
			drawBahamas(grid);
		}
		else if (countryCode==10 && grid.getHt()%2==1 && grid.getHt()>=8)
		{
			drawMacedonia(grid);
		}
		else //error flag
		{
			drawError(grid);
		}
		//else...  You'll need to fill in the cases and conditions for
		//         the remaining flags and make sure that the error flag
		//         is displayed at the appropriate times.
	}
}
