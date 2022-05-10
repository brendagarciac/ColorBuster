/** Brenda Garcia
 *  Object-Oriented Design
 *  Assignment 5 : Color Buster
 *  Due Date: April 28th, 2022
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainScreenView  extends JFrame {
    private GameView gameView;
    private JButton newGameButton;
    private JLabel welcomeLabel;
    private JComboBox boardSizeSelector;
    private JLabel nameLabel;
    private JTextField nameTextField;

    private String playerName;

    public MainScreenView(int width, int height, GameView gameView, ActionListener gameButtonListener, ActionListener boardSizeSelectorListener) {
        super();
        this.gameView = gameView;

        setTitle(gameView.getTitle());
        setBackground(Color.PINK);
        getContentPane().setBackground(Color.PINK);

        setBounds(100,50,width, height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.NORTH;

        welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to Color Buster!");
        welcomeLabel.setFont(new Font("Brush Script MT", Font.PLAIN, 30));
        add(welcomeLabel, constraints);

        constraints.insets = new Insets(30,30,30,30);
        boardSizeSelector = new JComboBox();
        boardSizeSelector.addItem("6 x 6");
        boardSizeSelector.addItem("8 x 8");
        boardSizeSelector.addItem("10 x 10");
        boardSizeSelector.addActionListener(boardSizeSelectorListener);
        add(boardSizeSelector, constraints);

        constraints.insets = new Insets(10,10,10,10);
        nameLabel = new JLabel();
        nameLabel.setText("Enter name:");
        add(nameLabel, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        nameTextField = new JTextField();
        nameTextField.setHorizontalAlignment(JTextField.CENTER);
        add(nameTextField, constraints);

        constraints.fill = GridBagConstraints.REMAINDER;
        newGameButton = new JButton();
        newGameButton.setText("PLAY");
        newGameButton.addActionListener(gameButtonListener);
        add(newGameButton, constraints);

        setVisible(true);
    }

    public String getName(){
        playerName = nameTextField.getText();
        return playerName;
    }


}
