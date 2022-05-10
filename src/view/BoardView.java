/** Brenda Garcia
 *  Object-Oriented Design
 *  Assignment 5 : Color Buster
 *  Due Date: April 28th, 2022
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.*;

import model.Board;
import model.Tile;
import view.TileView;

/**
 * @author Frank J. Mitropoulos
 * 
 * View class over the board model.
 *
 *
 */
public class BoardView extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	private Board b;
	private int rows;
	private int cols;
	private int tileSize;
	private ActionListener listener;
	private int spacer;
	private int matchSize;

	
	private TileView [][] tileGrid;
	
	// Create  BoardView with rows and cols and min match and lis is the actionListener for all the TileViews
	public BoardView(int rows, int cols, int matchSize, ActionListener lis) {
	    spacer = 4;
		listener = lis;
		Dimension s = getPreferredSize(rows);
		this.rows = rows;
		this.cols = cols;
		this.matchSize = matchSize;

		int totalSpace = (cols+1) * spacer;

		tileSize = (s.width-totalSpace) / cols;

		// I'm not using a layout manager here since I'm using XY to layout the TileViews
		// Quick and simple
		setLayout(null);
		tileGrid = new TileView[rows][cols];
		b = new Board(rows,cols, matchSize);
		for (int row=0; row<rows; row++) {
			for (int col=0; col<cols; col++) {
				TileView tv = new TileView(b.tileAt(row, col));
				add(tv);
				tileGrid[row][col] = tv;
			
				tv.setBounds((tileSize * col + spacer), (tileSize * ((rows-1)-row) + spacer),
							             tileSize, tileSize);
				tv.setPosition(tileSize * col + spacer, (tileSize * ((rows-1)-row) + spacer));
				
				tv.addListener(listener);
			}
		}
	}

	// Call this method whenever you want to update the boardView on the display from the current status of the board
	public void updateBoardViewFromBoard() {
		TileView tv;
		removeAll();
		tileGrid = new TileView[rows][cols];
		for (int row=0; row<rows; row++) {
			for (int col=0; col<cols; col++) {
				if (b.hasTileAt(row,col)) {
					 tv = new TileView(b.tileAt(row, col));
				}
				else  {
					tv = new TileView(row,col);
					
				}
				add(tv);
				tileGrid[row][col] = tv;

				tv.setBounds((tileSize * col + spacer), (tileSize * ((rows-1)-row) + spacer),
							             tileSize, tileSize);
				tv.setPosition(tileSize * col + spacer, (tileSize * ((rows-1)-row) + spacer));
				
				tv.addListener(listener);
			}
		}
	}

	// returns the score.
	public int processTouchedTile(TileView tv) {
		// locate the neighbors, collapse, and then call updateBoardViewFromBoard() to update the display
		int score = 0;
		HashSet<Tile> matches = new HashSet<>();
		b.locateNeighbors(tv.getRow(), tv.getCol(), tv.getColor(), matches);

		if (matches.size() >= matchSize) {
			score = matches.size() * 20; //the score depends on the number of tiles that matched times 20
			b.removeMatchingTiles(matches);
			b.collapseColumns();
		}
		else {
			JOptionPane.showMessageDialog(this, "Sorry! That's an invalid move, try again.");
		}

		updateBoardViewFromBoard();
		return score;
	}

	public String toString() {
		return b.toString();
	}

	public boolean isMoveAvailable() {
		return b.isMoveAvailable();
	}
	
	// set the default size of the boardview to a reasonable size
	public Dimension getPreferredSize(int rows) {
		if(rows == 10){
			return new Dimension(700,700);
		}
		else if(rows == 8){
			return new Dimension(550,550);
		}
		else if(rows == 6){
			return new Dimension(400,400);
		}
		return new Dimension(400,400);
	}

	public void setMatchSize(int matchSize) {this.matchSize = matchSize;}
}
