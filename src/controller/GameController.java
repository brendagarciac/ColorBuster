/** Brenda Garcia
 *  Object-Oriented Design
 *  Assignment 5 : Color Buster
 *  Due Date: April 28th, 2022
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import view.GameView;
import view.TileView;
import  view.MainScreenView;

/**
 * @author Frank J. Mitropoulos
 *
 */
public class GameController {
	private int score;
	private int matchSize = 3;
	private int width;
	private int height;
	private GameView gameView;
	private MainScreenView mainScreenView;

	/**
	 * Create the GameView and pass in the appropriate listeners
	 */
	public GameController() {
		super();

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				width = 380;
				height = 500;
				gameView = new GameView("Color Buster",6,6, width, height, null, new NewGameListener(), new TileTouchedListener(), new LevelSelectorListener());
				mainScreenView = new MainScreenView(width, height, gameView, new NewGameListener(), new BoardSizeSelectorListener());
				mainScreenView.setVisible(true);
			}
		});
	}
	
	// Listener used to process touches on TileView
	class TileTouchedListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			TileView tv = (TileView) event.getSource();

			//delegate to gameview
			gameView.processTouchedTile(tv);

			score = gameView.getScore();
			// If no move is available display a message
			if (!gameView.isMoveAvailable()) {
				JOptionPane.showMessageDialog(gameView,
					    "Game Over! Score: " + score);
			}
		}
		
	}
	
	// Listener used to process click on New Game Button
	class NewGameListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			String playerName = mainScreenView.getName();
			if(!playerName.isEmpty()){
				//Delegate to GameView
				gameView.newGame(matchSize, playerName);
				mainScreenView.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(mainScreenView, "Please enter a name");
			}

		}
	}

	//Listener used to process change of min matches size
	class LevelSelectorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Delegate to GameView!
			JComboBox comboBox = (JComboBox) e.getSource();
			String level = (String) comboBox.getSelectedItem();
			gameView.setMatchSize(Integer.parseInt(level));
			gameView.newGame(Integer.parseInt(level));
		}
	}

	//Listener used to process board size selection at the main screen
	class BoardSizeSelectorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Delegate to GameView!
			JComboBox comboBox = (JComboBox) e.getSource();
			String bSize = (String) comboBox.getSelectedItem();
			String[] size = bSize.split(" ");
			gameView.setRows(Integer.parseInt(size[0]));
			gameView.setCols(Integer.parseInt(size[2]));
			if(Integer.parseInt(size[0]) == 10){
				gameView.setWidth(670);
				gameView.setHeight(770);
			}
			else if(Integer.parseInt(size[0]) == 8){
				gameView.setWidth(520);
				gameView.setHeight(620);
			}
		}
	}
}
