/** Brenda Garcia
 *  Object-Oriented Design
 *  Assignment 5 : Color Buster
 *  Due Date: April 28th, 2022
 */
package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Frank J. Mitropoulos
 *
 */
public class GameView extends JFrame {

	// Create the HUD Panel
	// Create the Board
	private static final long serialVersionUID = 1L;
	private ScoreView scoreView;
	private ButtonView buttonView;
	private BoardView boardView;
	private int score;
	private int matchSize = 3;

	// Setting default to 6 x 6
	int rows = 6, cols = 6;
	int width, height;

	ActionListener newGameListener;
	ActionListener tileTouchedListener;
	ActionListener levelSelectorListener;

	public GameView(String title, int rows, int cols, int width, int height, MouseListener listener, ActionListener newGameListener, ActionListener tileTouched,  ActionListener levelSelectorListener) throws HeadlessException {
		super(title);
		setResizable(false);

		score = 0;
		this.rows = rows;
		this.cols = cols;
		this.width = width;
		this.height = height;

		this.newGameListener = newGameListener;
		this.tileTouchedListener = tileTouched;
		this.levelSelectorListener = levelSelectorListener;

		// Set up some reasonable sizes for the gameview
		setBounds(100,50,width, height);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		scoreView = new ScoreView();
    	add(scoreView, BorderLayout.NORTH);
		
    	buttonView = new ButtonView(newGameListener, levelSelectorListener);
    	add(buttonView, BorderLayout.SOUTH);
		
		boardView = new BoardView(rows, cols, matchSize, tileTouchedListener);
		add(boardView, BorderLayout.CENTER);
	}
	
	// Delegate to boardView
	public boolean isMoveAvailable() {
		if (boardView.isMoveAvailable())
			return true;
		return false;
	}

	public void newGame(int matchSize) {
		// Recreate some components and update the GUI.
		Container c = getContentPane();
		c.remove(boardView);
		c.invalidate();
		pack();

		boardView = null;
		score = 0;
		scoreView.updateScore(score);
		this.matchSize = matchSize;
		boardView = new BoardView(rows,cols, matchSize, tileTouchedListener);

		buttonView.changeLevelToDefault(matchSize); // change JComboBox back to default matchSize

		add(boardView, BorderLayout.CENTER);
		pack();
		revalidate();
		setBounds(100,50,width, height);
		setVisible(true);
	}
	
	// Call this method to start a new Game
	public void newGame(int matchSize, String playerName) {
		// Recreate some components and update the GUI.
		Container c = getContentPane();
		c.remove(boardView);
		c.invalidate();
		pack();

		boardView = null;
		score = 0;
		scoreView.updateScore(score);
		scoreView.updateName(playerName);
		this.matchSize = matchSize;
		boardView = new BoardView(rows,cols, matchSize, tileTouchedListener);

		buttonView.changeLevelToDefault(matchSize); // change JComboBox back to default matchSize

		add(boardView, BorderLayout.CENTER);
		pack();
		revalidate();
		setBounds(100,50,width, height);
		setVisible(true);
	}
	
	public void processTouchedTile(TileView tv) {
		//This method is called when a tileview is touched
		scoreView.updateScore(score += boardView.processTouchedTile(tv));
	}

	public void setMatchSize(int matchSize) {
		this.matchSize = matchSize;
		boardView.setMatchSize(matchSize);
	}
	public int getScore(){
		return score;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}


	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
