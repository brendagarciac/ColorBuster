/** Brenda Garcia
 *  Object-Oriented Design
 *  Assignment 5 : Color Buster
 *  Due Date: April 28th, 2022
 */
package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

/**
 * @author Frank J. Mitropoulos
 */
public class Tile { 

	public static String [] colors = {
			"Resources/images/Green.jpg",
			"Resources/images/Blue.jpg",
			"Resources/images/Purple.jpg",
			"Resources/images/Pink.jpg",
			"Resources/images/Yellow.jpg"
	};

	private int col;
	private int row;
	private Image img;
	private int color;
	private int status;

	public Tile(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		color = randInt(0,4);
		status = 0;
		
		try {
			img = ImageIO.read(new FileImageInputStream(new File(colors[color])));
		} catch (IOException ex) {
			
		}
	}

	public int getRow() { 
		return row;
	}

	public void setRow(int x) {
		this.row = x;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int y) {
		this.col = y;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int stat) {
		status = stat;
	}
	
	public String toString() {
		String c = "Y";
		if (color == 0) 
			c = "Green";
		else if (color == 1)
			c = "Blue";
		else if (color == 2)
			c = "Purple";
		else if (color == 3)
			c = "Pink";
		else
			c = "Yellow";
			
		return "[" + row + "," + col + "," + c + "]";
	}

	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
