package p3_student;


import cmsc131PhotoLibrary.Photograph;
import cmsc131PhotoLibrary.Pixel;

/**
 * This class will be written by the Student.  It provides various
 * static methods that take a photograph and produce a copy of it with
 * various modifications.
 * 
 * See the project description for details of method implementations.
 * 
 * @author CMSC 131 Student
 *
 */
public class PhotoTools {

	public static Photograph copy(Photograph photo) {
		int width = (photo.getWd());
		int height = (photo.getHt());
		Photograph copy = new Photograph(width, height);
		for (int row = 0; row <height; row++)
		{
			for(int col = 0; col <width; col++)
			{
				copy.setPixel(col, row, photo.getPixel(col, row));
			}
		}
		return copy;
		//REMOVE THE LINE OF CODE BELOW THIS COMMENT WEHN YOU IMPLEMENT THIS
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}

	
	public static Photograph makeGrayscale(Photograph photo) {
		int height = (photo.getHt());
		int width = (photo.getWd());
		Photograph newPhoto = new Photograph(width, height);
		int tempR, tempG, tempB, averageColor;
		for (int row = 0; row <height; row++)
		{
			for (int col = 0; col<width; col++)
			{
				tempR = photo.getPixel(col, row).getRed();
				tempG = photo.getPixel(col, row).getGreen();
				tempB = photo.getPixel(col, row).getBlue();
				averageColor = (tempR+tempG+tempB)/3;
				Pixel p = new Pixel (averageColor, averageColor, averageColor);
				newPhoto.setPixel(col, row, p);
			}
		}
		return newPhoto;
		//REMOVE THE LINE OF CODE BELOW THIS COMMENT WEHN YOU IMPLEMENT THIS
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}

	public static Photograph striped(Photograph photo) {
		int height = (photo.getHt());
		int width = (photo.getWd());
		int section = 0;
		Photograph striped = new Photograph(width, height);
		for(int row = 0; row<height; row++)
		{
			if(row>=0+section && row<=9+section)
			{
				for(int col = 0; col <width; col++)
				{
					striped.setPixel(col, row, photo.getPixel(col, row));
				}
				System.out.println("Orignial");
			}
			else if(row>=10+section && row<=19+section)
			{
				for(int col = 0; col <width; col++)
				{
					Pixel p = new Pixel (255, 255, 255);
					striped.setPixel(col, row, p);
				}
				System.out.println("white");
			}
			else if(row>=20+section && row<=28+section)
			{
				for(int col = 0; col <width; col++)
				{
					Pixel p = new Pixel (0, 0, 0);
					striped.setPixel(col, row, p);
				}
				System.out.println("black");
			}
			else
			{
				for(int col = 0; col <width; col++)
				{
					Pixel p = new Pixel (0, 0, 0);
					striped.setPixel(col, row, p);
				}
				section+=30;
			}
		}
		return striped;
		//REMOVE THE LINE OF CODE BELOW THIS COMMENT WEHN YOU IMPLEMENT THIS
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static Photograph isolateColor(Photograph photo, int type) {
		int height = (photo.getHt());
		int width = (photo.getWd());
		Photograph isolateColor = new Photograph(width, height);
		int tempR, tempG, tempB;
		if (type == 0) //red
		{	
			for (int row = 0; row <height; row++)
			{
				for (int col = 0; col<width; col++)
				{
					tempR = photo.getPixel(col, row).getRed();
					Pixel p = new Pixel (tempR, 0, 0);
					isolateColor.setPixel(col, row, p);
				}
			}
		}
		else if (type == 1) //green
		{	
			for (int row = 0; row <height; row++)
			{
				for (int col = 0; col<width; col++)
				{
					tempG = photo.getPixel(col, row).getGreen();
					Pixel p = new Pixel (0, tempG, 0);
					isolateColor.setPixel(col, row, p);
				}
			}
		}
		else //blue
		{	
			for (int row = 0; row <height; row++)
			{
				for (int col = 0; col<width; col++)
				{
					tempB = photo.getPixel(col, row).getBlue();
					Pixel p = new Pixel (0, 0, tempB);
					isolateColor.setPixel(col, row, p);
				}
			}
		}
		return isolateColor;
		//REMOVE THE LINE OF CODE BELOW THIS COMMENT WEHN YOU IMPLEMENT THIS
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}

	


	public static Photograph stretched(Photograph photo, int type) {
		int height = (photo.getHt());
		int width = (photo.getWd());
		if (type == 0) //horizontal
		{
			Photograph horizontal = new Photograph(width*2, height);
			for(int col = 0; col <horizontal.getWd(); col++)
			{
				for (int row = 0; row <height; row++)
				{
					horizontal.setPixel(col, row, photo.getPixel(col/2, row));
				}
			}
			return horizontal;
		}
		else //vertical
		{
			Photograph vertical = new Photograph(width, height*2);
			for(int col = 0; col <width; col++)
			{
				for (int row = 0; row <vertical.getHt(); row++)
				{
					vertical.setPixel(col, row, photo.getPixel(col, row/2));
				}
			}
			return vertical;
		}
		//REMOVE THE LINE OF CODE BELOW THIS COMMENT WEHN YOU IMPLEMENT THIS
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}

	public static Photograph mirrored(Photograph photo) {
		int width = (photo.getWd());
		int height = (photo.getHt());
		Photograph mirrored = new Photograph(width, height);
		for (int row = 0; row <height; row++)
		{
			for(int col = 0; col <width; col++)
			{
				mirrored.setPixel((width-1)-col, row, photo.getPixel(col, row));
			}
		}
		return mirrored;
		//REMOVE THE LINE OF CODE BELOW THIS COMMENT WEHN YOU IMPLEMENT THIS
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static Photograph rotated(Photograph photo) {
		int width = (photo.getWd());
		int height = (photo.getHt());
		Photograph rotated = new Photograph(height, width);
		for (int rowOrig = 0, colNew = rotated.getWd()-1; rowOrig <height && colNew >= 0; rowOrig++, colNew--)
		{
			for(int colOrig = 0, rowNew = rotated.getHt()-1; colOrig <width && rowNew >= 0; colOrig++, rowNew--)
			{
				rotated.setPixel(colNew, rowNew, photo.getPixel(colOrig, rowOrig));
			}
		}
		return mirrored(upsideDown(rotated));
		//REMOVE THE LINE OF CODE BELOW THIS COMMENT WEHN YOU IMPLEMENT THIS
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static Photograph upsideDown(Photograph photo) {
		Photograph upsideDown = new Photograph(photo.getWd(), photo.getHt());
		for (int row = 0; row <photo.getHt(); row++)
		{
			for(int col = 0; col <photo.getWd(); col++)
			{
				upsideDown.setPixel(col, (photo.getHt()-1)-row, photo.getPixel(col, row));
			}
		}
		return mirrored(upsideDown);
		//REMOVE THE LINE OF CODE BELOW THIS COMMENT WEHN YOU IMPLEMENT THIS
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}

	public static Photograph weirdCombo(Photograph photo) {
		int height = (photo.getHt());
		int width = (photo.getWd());
		Photograph weirdCombo = new Photograph(width*3, height);
		int tempR, tempG, tempB;
		for (int row = 0; row <height; row++)
		{
			for (int col = 0; col<weirdCombo.getWd(); col++)
			{
				if(col<width)
				{
					tempR = photo.getPixel(col, row).getRed();
					Pixel p = new Pixel (tempR, 0, 0);
					weirdCombo.setPixel(col, row, p);
					//System.out.println("red");
				}
				else if(col<width*2 && col>=width)
				{
					tempG = photo.getPixel(col-width, row).getGreen();
					Pixel p = new Pixel (0, tempG, 0);
					weirdCombo.setPixel(col, row, p);
					//System.out.println("green");
				}
				else if(col<width*3 && col>=width*2)
				{
					tempB = photo.getPixel(col-(2*width), row).getBlue();
					Pixel p = new Pixel (0, 0, tempB);
					weirdCombo.setPixel(col, row, p);
					//System.out.println("blue");
				}
			}
		}
		return weirdCombo;
		//REMOVE THE LINE OF CODE BELOW THIS COMMENT WEHN YOU IMPLEMENT THIS
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}



}
