/** Brenda Garcia
 *  Object-Oriented Design
 *  Assignment 5 : Color Buster
 *  Due Date: April 28th, 2022
 */
package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.*;

/**
 * @author Frank J. Mitropoulos
 *
 */
public class ButtonView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton newGameButton;
	private JComboBox levelSelector;
	private JLabel levelLabel;
	
	public ButtonView(ActionListener gameButtonListener, ActionListener levelSelectorListener) {
		
		levelLabel = new JLabel();
		levelLabel.setText("Min Matches: ");
		add(levelLabel);
		
		levelSelector = new JComboBox();
		levelSelector.addItem("3");
		levelSelector.addItem("4");
		levelSelector.addItem("5");
		levelSelector.addActionListener(levelSelectorListener);
		add(levelSelector);
		
		newGameButton = new JButton();
		newGameButton.setText("New Game");
		newGameButton.addActionListener(gameButtonListener);
		add(newGameButton);
	}

	public void changeLevelToDefault(int matchSize){
		for (int i = 0; i < levelSelector.getItemCount(); i++)
		{
			if (levelSelector.getItemAt(i).toString().equalsIgnoreCase(Integer.toString(matchSize)))
			{
				levelSelector.setSelectedIndex(i);
				break;
			}
		}
	}

}
