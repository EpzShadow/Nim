/*Write a program that allows two people to play a game of Nim.
The program should start by creating four piles of sticks, each with a
number of sticks that varies randomly from four to
eight and displaying the piles on the screen.*/
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class Nim extends JFrame
{
    //declaring a few things before hand, so all methods can access them
    public static JTextField userOneText;
    public static JTextField userTwoText;
    static String playerOne, playerTwo, currentPlayer;
    static int playerOneWins = 0, playerTwoWins = 0;
    
    public static void main (String[] args)
    {
	//calling the first method that sets it off
	login ();
    }

    //class for the initial user login page, where names are given
    public static void login ()
    {
	//creating a panel and frame to allow a GUI to be made
	final JPanel panel = new JPanel ();
	final JFrame frame = new JFrame ("Nim Login");
	/*(frame work) setting the size, close operation, color, adding panel
	and centering it, respectively*/
	frame.setSize (400, 200);
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.setVisible (true);
	frame.setBackground (Color.WHITE);
	frame.getContentPane ().add (panel);
	frame.setLocationRelativeTo (null);
	/*(panel work), setting the color, size*/
	panel.setBackground (Color.WHITE);
	panel.setLayout (null);
	//creating a label that tells the players to enter their name
	JLabel labelOne = new JLabel ("Player 1");
	labelOne.setBounds (40, 25, 100, 25);
	panel.add (labelOne);
	//text field so players can enter their user name and adding to panel
	userOneText = new JTextField (20);
	userOneText.setBounds (115, 25, 165, 25);
	panel.add (userOneText);
	//duplicate for second player, then setting bounds and adding to panel
	JLabel labelTwo = new JLabel ("Player 2");
	labelTwo.setBounds (40, 70, 100, 25);
	panel.add (labelTwo);
	//similarly, a duplicate text box for the second player
	userTwoText = new JTextField (20);
	userTwoText.setBounds (115, 70, 165, 25);
	panel.add (userTwoText);
	//A button to submit the user names when they are ready
	JButton button = new JButton ("Start Game!");
	button.setBounds (123, 115, 150, 30);
	//setting up a function for the button
	button.addActionListener (new ActionListener ()
	{
	    public void actionPerformed (ActionEvent e)
	    {
		/*Storing the usernames of the two players from the
		login screen*/
		playerOne = userOneText.getText ();
		playerTwo = userTwoText.getText ();
		//exiting out of the login GUI for optimization
		frame.dispose ();
		//calling the window that allows them to pick who goes first
		whoGoesFirst ();
	    }
	}
	);
	panel.add (button);
	//setting it to visible so its prompted automatically
	frame.setVisible (true);

    }

    //a new window that asks who goes first
    public static void whoGoesFirst ()
    {
	//creating a panel and frame for the game NIM!
	final JFrame frame = new JFrame ("Select who goes first!");
	final JPanel panel = new JPanel ();
	/*customizing the frame (size, close, color, centering, all
	done respectively*/
	frame.setSize (1024, 768);
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.setBackground (Color.WHITE);
	frame.getContentPane ().add (panel);
	frame.setLocationRelativeTo (null);
	frame.setVisible (true);
	//panel work, color and layout format
	panel.setBackground (Color.white);
	panel.setLayout (null);
	//Creating a text that asks which user goes first
	JLabel goesFirst = new JLabel ("Select Who Goes First!");
	goesFirst.setBounds (300, 150, 700, 200);
	panel.add (goesFirst);
	goesFirst.setFont (goesFirst.getFont ().deriveFont (40.0f));
	//creating two seperate buttons for which player goes first
	JButton playersOneFirst = new JButton (playerOne + " goes first!");
	playersOneFirst.setBounds (250, 500, 200, 50);
	/*the function of the button is to open a new window, and store who
	/goes first*/
	playersOneFirst.addActionListener (new ActionListener ()
	{
	    public void actionPerformed (ActionEvent e)
	    {

		frame.dispose ();
		//calling the game NIM to be played after users have put in
		currentPlayer = playerOne;
		//calling the gameCreation class for the game to start
		gameCreation ();

	    }
	}
	);
	JButton playersTwoFirst = new JButton (playerTwo + " goes first!");
	playersTwoFirst.setBounds (575, 500, 200, 50);
	playersTwoFirst.addActionListener (new ActionListener ()
	{
	    public void actionPerformed (ActionEvent e)
	    {

		frame.dispose ();
		//calling the game NIM to be played after users have put in
		currentPlayer = playerTwo;
		//calling the gameCreation class for the game to start
		gameCreation ();
	    }
	}
	);
	//adding the buttons to the panel
	panel.add (playersOneFirst);
	panel.add (playersTwoFirst);
	//making everything visible
	frame.setVisible (true);
    }

    //using really big "I" to represnt sticks
    public static String createStickString (int sticks)
    {
	String s = "";
	for (int i = 0 ; i < sticks ; ++i)
	{
	    s = s + "I";
	}
	return s;
    }
    
    //A new window for the game to be played.
    public static void gameCreation ()
    {
	//creating a panel and frame for the game NIM!
	final JFrame frame = new JFrame ("Nim for two!");
	final JPanel panel = new JPanel ();
	/*customizing the frame (size, close, color, centering, all
	done respectively*/
	frame.setSize (1024, 768);
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.setBackground (Color.WHITE);
	frame.getContentPane ().add (panel);
	frame.setLocationRelativeTo (null);
	frame.setVisible (true);
	//panel work, color and layout format
	panel.setBackground (Color.white);
	panel.setLayout (null);

	//creating an array for four random piles
	final int sticksNumber[] = new int [4];
	final JLabel labels[] = new JLabel [4];
	final JLabel sticksLabels[] = new JLabel [4];
	int x_org = 150;
	int y_org = 50;
	//a for loop used for setting up different variables
	for (int i = 0 ; i < 4 ; i++)
	{
	    //setting up a random value between 4-8 for each pile
	    sticksNumber [i] = 4 + (int) (Math.random () * ((8 - 4) + 1));
	    //a string to display which pile is which
	    String s = "Pile " + String.valueOf (i + 1);
	    //array of labels for eah pile, also setting up fonts etc.
	    labels [i] = new JLabel (s);
	    labels [i].setBounds (x_org + 200 * i, y_org, 200, 50);
	    labels [i].setFont (labels [i].getFont ().deriveFont (30.0f));
	    panel.add (labels [i]);

	    /*calling the createStickString method to create images of sticks
	    using the letter I. Also using the number of sticks to see how
	    many times to print also, formatting*/
	    sticksLabels [i] = new JLabel (createStickString (sticksNumber [i]));
	    sticksLabels [i].setBounds (x_org + 200 * i, y_org + 80, 200, 60);
	    sticksLabels [i].setFont (sticksLabels [i].getFont ().
		    deriveFont (60.0f));
	    panel.add (sticksLabels [i]);
	}
	//a label to display who the current player is
	final JLabel currentPlayLabel = new JLabel ("Current Player: " +
		String.valueOf (currentPlayer));
	currentPlayLabel.setBounds (x_org + 100, y_org + 150, 500, 30);
	currentPlayLabel.setFont (currentPlayLabel.getFont ().deriveFont (30.0f));
	panel.add (currentPlayLabel);
	//label asking the user which pile they want to pick
	final JLabel pilesPickLabel = new JLabel ("Which pile to pick?");
	pilesPickLabel.setBounds (x_org, y_org + 200, 400, 30);
	pilesPickLabel.setFont (pilesPickLabel.getFont ().deriveFont (25.0f));
	panel.add (pilesPickLabel);
	//a text field for the use to enter which pile they choose from
	final JTextField pilesPick = new JTextField (1);
	pilesPick.setBounds (x_org + 400, y_org + 200, 400, 30);
	pilesPick.setFont (pilesPick.getFont ().deriveFont (25.0f));
	panel.add (pilesPick);
	//label asking the user how many sticks to remove from said pile
	final JLabel stickPickLabel = new JLabel ("How many sticks to pick?");
	stickPickLabel.setBounds (x_org, y_org + 250, 400, 30);
	stickPickLabel.setFont (stickPickLabel.getFont ().deriveFont (25.0f));
	panel.add (stickPickLabel);
	//text field fro them to enter how many sticks to remove
	final JTextField sticksPick = new JTextField (1);
	sticksPick.setBounds (x_org + 400, y_org + 250, 400, 30);
	sticksPick.setFont (sticksPick.getFont ().deriveFont (25.0f));
	panel.add (sticksPick);
	//a submit button
	final JButton submitButton = new JButton ("Submit");
	submitButton.setBounds (x_org + 400, y_org + 400, 150, 30);
	panel.add (submitButton);
	//visibiility
	panel.setVisible (true);
	frame.setVisible (true);
	//setting up the usuability and function for the textboxes, and buttons
	submitButton.addActionListener (new ActionListener ()
	{
	    public void actionPerformed
		(ActionEvent e)
	    {
		//declaring a variable for try and catch
		boolean PASS = true;
		//declaration of variables
		int piles = 0, sticks = 0, remaining = 0, answer = -1;
		do
		{
		    //try and catch statement for if they enter characters
		    try
		    {
			//function of the text box for  pile they choose from
			piles = Integer.parseInt (pilesPick.getText ());
			//function of the text box for amount of sticks chosen
			sticks = Integer.parseInt (sticksPick.getText ());
			PASS = true;
		    }
		    catch (NumberFormatException t)
		    {
			/*giving an error message and returning to the
			 textbox if they enter string*/
			JOptionPane.showMessageDialog (null, "Invalid input",
				"InfoBox: Bad input ",
				JOptionPane.INFORMATION_MESSAGE);
			PASS = false;
			return;
		    }
		}
		while (PASS = false);
		//bullet proof for invalid values
		if (piles > 5 || piles < 1 || sticks < 1
			|| sticks > sticksNumber [piles - 1])
		{

		    JOptionPane.showMessageDialog (null, "Invalid input",
			    "InfoBox: Bad input ",
			    JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		//resetting the textbox for later use again
		pilesPick.setText ("");
		sticksPick.setText ("");
		//if and else statement to change turns
		if (currentPlayer == playerOne)
		{
		    currentPlayer = playerTwo;
		}
		else
		{
		    currentPlayer = playerOne;
		}
		//calculating the amount of sticks left in each pile
		sticksNumber [piles - 1] -= sticks;
		//drawing the amount of sticks left in each pile
		sticksLabels [piles - 1].setText
		    (createStickString (sticksNumber [piles - 1]));
		/*calculating the amount of sticks remaining, to see whether
		or not the game has finished*/
		for (int i = 0 ; i < 4 ; ++i)
		{
		    remaining += sticksNumber [i];
		}
		if (remaining == 0)
		{
		    //congragulatory message
		    String s = " " + currentPlayer +
			" wins. Congratulations!!!";
		    JOptionPane.showMessageDialog (null, s,
			    "InfoBox: Win",
			    JOptionPane.INFORMATION_MESSAGE);
		    //adding the win to the respective player's total
		    if (currentPlayer.equals (playerOne))
		    {
			playerOneWins++;
		    }
		    else
			playerTwoWins++;
		    //calling a method if they want to play again
		    playAgain ();
		    frame.dispose ();
		}
		//setting who the current player is
		String player = "Current Player is: "
		    + String.valueOf (currentPlayer);
		currentPlayLabel.setText (player);
	    }
	}
	);
	frame.setVisible (true);
    }

    //JOptionPane for if they want to play again
    public static void playAgain ()
    {
	int x;
	String s = "Would you like to play again?";
	//panel displaying if they want to play again
	x = JOptionPane.showConfirmDialog (null,
		s, "Play Again?", JOptionPane.YES_NO_OPTION);
	//if yes, then repeat
	if (x == JOptionPane.YES_OPTION)
	{
	    whoGoesFirst ();
	}
	//display the winnings of each player
	else
	{
	    //creating a panel and frame to allow a GUI to be made
	    final JPanel panel = new JPanel ();
	    final JFrame frame = new JFrame ("Final Counter:");
	    /*(frame work) setting the size, close operation, color,
	    adding panel and centering it, respectively*/
	    frame.setSize (400, 200);
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    frame.setVisible (true);
	    frame.setBackground (Color.WHITE);
	    frame.getContentPane ().add (panel);
	    frame.setLocationRelativeTo (null);

	    /*(panel work), setting the color, size*/
	    panel.setBackground (Color.WHITE);
	    panel.setLayout (null);

	    //labels displaying the amount of wins they got
	    JLabel labelOne = new JLabel (playerOne + ": " + playerOneWins +
		    " Win(s)");
	    labelOne.setBounds (60, 60, 100, 25);
	    panel.add (labelOne);
	    JLabel labelTwo = new JLabel (playerTwo + ": " + playerTwoWins
		    + "  Win(s)");
	    labelTwo.setBounds (60, 95, 100, 25);
	    panel.add (labelTwo);
	    JLabel labelThree = new JLabel ("Final Tally: ");
	    labelThree.setBounds (50, 10, 10000, 50);
	    labelThree.setFont (labelThree.getFont ().deriveFont (20.0f));
	    panel.add (labelThree);
	    //visibility
	    frame.setVisible (true);
	}
    }
}
