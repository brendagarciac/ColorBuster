/** Brenda Garcia
 *  Object-Oriented Design
 *  Assignment 5 : Color Buster
 *  Due Date: April 28th, 2022
 */
package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * @author Frank J. Mitropoulos
 * 
 *  A very simple score panel
 *  call updateScore and pass in the score to update the display
 */
public class ScoreView extends JPanel {

	
	private static final long serialVersionUID = 1L;

	private JLabel scoreLabel;
	private JLabel playerNameLabel;

	public ScoreView() {
		playerNameLabel = new JLabel();
		scoreLabel = new JLabel("Score: 0");
		add(playerNameLabel);
		add(scoreLabel);

	}
	
	public void updateScore(int score) {
		scoreLabel.setText("Score: " + score);
	}

	public void updateName(String name){
		playerNameLabel.setText(name + "'s");
	}

}
