// Imports
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.lang.*;


import javax.swing.ImageIcon;
import java.net.URL;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;


public class Hangman extends JFrame{
	private JTextField guessBox;
	private JButton submitGuess;
	private static Graphics globalGraphics; // Global Graphics object
	private int wrongGuess = 0; //number of wrong guesses (guess not in word at all)
	private List<JLabel> wordLabels = new ArrayList<>(); //store word labels
	private List<JLabel> wrongGuessLabels = new ArrayList<>(); //store wrong guess labels
	private char guess;
	public String clicked = "No";
	private Image headImage; //image for head
	
	public Hangman() {
		// Creates the JFrame and GUI
		
		setTitle("Hangman");
		setSize(1200, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		guessBox = new JTextField("hello");
		add(guessBox);
		guessBox.setBounds(150,50 , 300, 50); // x, y, width, height
		Font font = new Font("Arial", Font.PLAIN, 20); // Font name, style, size
	    guessBox.setFont(font);
		submitGuess = new JButton("Submit");
		add(submitGuess);
		submitGuess.setBounds(150,100, 100, 50);
		
		submitGuess.addActionListener(new ActionListener() { 
			  @Override
			  public void actionPerformed(ActionEvent e) {
				  String text = guessBox.getText().trim();
				  clicked = "Yes";
				  if (text.length() > 1) {
					  //This is a word
					  showMessageDialog(null, "Please only input letters");
				  } else {
					  guess = text.charAt(0);
					  
				  }
				  
				  
			  } 
				
		});
	
	

	
	try {
		//load head image
		headImage = ImageIO.read(new File("src/Stick_Figure_Head.jpg"));
		if (headImage == null) {
			System.err.println("Image not found!");
		}
	} catch (IOException e) { //in the case that it cant find the image
		e.printStackTrace();
	}
}

	// List of words used for Hang Man
	public static ArrayList<String> getWords() {
		// The list
		ArrayList<String> words = new ArrayList<>();
        words.add("computer");
        words.add("programming");
        words.add("hangman");
        words.add("developer");
        words.add("algorithm");
        words.add("software");
        words.add("application");
        words.add("interface");
        words.add("database");
        words.add("variable");
        words.add("network");
        words.add("keyboard");
        words.add("monitor");
        words.add("mouse");
        words.add("server");
        words.add("client");
        words.add("debugging");
        words.add("iteration");
        words.add("repository");
        words.add("version");
        words.add("index");
        words.add("compiler");
        words.add("framework");
        words.add("language");
        words.add("script");
        words.add("library");
        words.add("backend");
        words.add("frontend");
        words.add("operator");
        words.add("operand");
        words.add("syntax");
        words.add("statement");
        words.add("expression");
        words.add("inheritance");
        words.add("polymorphism");
        words.add("encapsulation");
        words.add("abstraction");
        words.add("constructor");
        words.add("destructor");
        words.add("parameter");
        words.add("argument");
        words.add("override");
        words.add("overload");
        words.add("class");
        words.add("object");
        words.add("method");
        words.add("variable");
        words.add("java");
        words.add("python");
        words.add("ruby");
        words.add("html");
        words.add("css");
        return words;
    }
	public void changeClicked(String No) {
		this.clicked = "No";
	}
	public String getClicked() {
		return this.clicked;
	}
	public void increaseGuess() {
		this.wrongGuess++;
	}
	public int getGuesses() {
		return this.wrongGuess;
	}
	
	public void changeGuess(char a) {
		this.guess = a;
	
	}
	public char getGuessChar() {
		while (!clicked.equals("Yes")) {
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		clicked = "No";
		return this.guess;
		
		
	}

	
	public void paint(Graphics g) {
		super.paint(g);
		
	
		
	    g.setColor(Color.BLACK);

        // Set the stroke thickness
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(5)); // Set the line thickness to 5 pixels

        // Draw the vertical line
        int x = 200; // X-coordinate of the line (center of the frame)
        int startY = 200; // Starting Y-coordinate of the line
        int endY = 660; // Ending Y-coordinate of the line
        
        // Main body Straight Line/Vertical
        g2d.drawLine(x, startY, x, endY);
        // Bottom base line/Horizontal
        g2d.drawLine(125, 660, 275, 660);
        // Top Line/Horizontal
        g2d.drawLine(200, 200, 400, 200);
        // Hanging line/Vertical
        g2d.drawLine(400, 200, 400, 250);
        // Restore the previous stroke
        g2d.setStroke(oldStroke);
        
        // Adds the head
        if (this.wrongGuess >=1) {
        	if (headImage != null) {
        		g.drawImage(headImage, 342, 250, 120, 120, this);
        	} else {
        		System.err.println("head image not loaded.");
        	}
        	int centerX = 400;
		    int centerY = 300;
		    int radius = 50;
		    // Draw the circle
			//g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        }
		
        // Adds the body
        if (this.wrongGuess >=2) {
			g2d.setStroke(new BasicStroke(3)); // Set the line thickness to 5 pixels
			// Draw body line
			g2d.drawLine(402, 370, 402, 520);
			}
		
        // Adds the first arm
        if (this.wrongGuess >=3 ) {
			g2d.setStroke(new BasicStroke(3));
			// Draw arm1
			g2d.drawLine(351, 375, 401, 450);
		}
        
        // Adds the second arm
		if (this.wrongGuess >=4 ) {
			g2d.setStroke(new BasicStroke(3));
			// Draw arm1
			g2d.drawLine(452, 375, 402, 450);
		}
		
		// Adds the first leg/left
		if (this.wrongGuess >=5 ) {
			g2d.setStroke(new BasicStroke(3));
			// Draw leg1
			g2d.drawLine(350, 650, 401, 520);
		}
		
		// Adds the second leg/right
		if (this.wrongGuess >=6 ) {
			g2d.setStroke(new BasicStroke(3));
			// Draw leg2
			g2d.drawLine(451, 650, 402, 520);
		}
		
	
	
	}
	
	public void updateWrongGuesses(List<Character> wrongGuesses) {
		int DXAxis = 700;//coordinates for displaying wrong guess labels
		int DYAxis = 200;
		
		//Remove wrong guess labels before adding new ones
	    for (JLabel label : wrongGuessLabels) {
	    	getContentPane().remove(label);
	    }
	    wrongGuessLabels.clear();;
	    
	    //Add wrong guess labels
	    for (Character wrongGuessChar : wrongGuesses) {
            // Create a JLabel for the current character
            JLabel label = new JLabel(wrongGuessChar.toString());
            label.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font size and style
            label.setBounds(DXAxis, DYAxis, 30,30);
            getContentPane().add(label); //add the label to the frame
            wrongGuessLabels.add(label); // keep track of the label
            DXAxis += 35;
		}
	    
	    revalidate(); //Revalidated the frame to reflect changes
	    repaint(); //repaint the frame to ensure updates are shown
	}
	public void updateCorrectGuesses(List<Character> characters, List<Integer> positions) {
		for(int pos : positions) {
			JLabel label = wordLabels.get(pos);
			label.setText(characters.get(pos).toString());
		}
		revalidate();
		repaint();
	}

	
	
	
	// Main Method
	public static void main(String[] args) {
		
        // Add the JTextField to the JFrame
        

        // Make the frame visible
        
		
		SwingUtilities.invokeLater(() -> new Hangman());
		int correctLetter = 0; //number of correct letters in word in total guessed
		int thisGuessCorrect = 0; //number of correct letters in word guessed by individual guess
		int end = 6; //max number of wrong guesses allowed (adjust for difficulty)
		int guesses = 0; //total number of guesses (both right and wrong)
		
		Hangman hangman = new Hangman(); //Creates the window
		
		
		Scanner sc = new Scanner(System.in); // Scanner for user input
		
		
		
		int index = (int)(Math.random()*50); //Chooses random word out of the list
		ArrayList<String> words = getWords();
		String chosenWord = words.get(index);
		System.out.println(chosenWord); //for checking purposes
		
		List<Character> characters = new ArrayList<>();	// Separates the chosen word into a list of its individual characters
		for( char c :chosenWord.toCharArray()) {
			characters.add(c);
		}
		System.out.println(characters.size());
		// Creates JLabel for each of the characters in the word with the letters
		int XAxis = 700;
		int YAxis = 600;
		for (Character ch : characters) {
            // Create a JLabel for the current character
            JLabel label = new JLabel("__");
            label.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font size and style
            label.setBounds(XAxis, YAxis, 50,50);
            hangman.add(label); // Add the label to the frame
            hangman.wordLabels.add(label); //Add the label to the wordLabels
            XAxis += 35;
            
            
		}
		
		hangman.setLocationRelativeTo(null);
		hangman.setVisible(true);
		

		char guess = hangman.getGuessChar(); // Checks if guess is a letter or a word
		//char letter=' ';//default first guess
		String guess2 = Character.toString(guess);
		/*
		if (guess.length() > 1) { //This is a word
			guess = sc.nextLine();
		} else {
			letter = guess.charAt(0); //takes the first character of the word 
			if (letter == ' ' || letter == '0') {//not valid guess, so should prompt user to guess again
				System.out.println("Not a valid guess. Try again.");
				guess = sc.nextLine();
				
				if (guess.length() > 1) { //This is a word
					guess = sc.nextLine();
				} else {
					letter = guess.charAt(0); //takes the first character of the word 
				}
			}
		}*/
		
		List<Integer> position= new ArrayList<>();	// Stores all position of correct guess into a list
		List<Character> wrongGuesses= new ArrayList<>();	// Stores all guesses into a list
		hangman.updateWrongGuesses(wrongGuesses); //create instance of method in Hangman class
		List<Character> letters = new ArrayList<>(); //records specific guesses so that user cannot guess the same letter again
		//  Repeatedly ask user for guesses and checks to see if correct
		
		String skip = "";
		while(guess != '!') {
			if (guesses == 0) {
				guesses++; //add number of guesses so when it runs again it will add the guess
			}
			System.out.println(letters);
			for(int j=0; j<=letters.size()-1; j++) {
				if(letters.get(j) == guess) {
					if (skip == "yes") {
						System.out.println("Already guessed. Please try again!");
						break; //stop checking because it is already a duplicate guess
					}
					System.out.println("Already guessed. Please try again!");
					skip = "yes"; //to skip over logic on line 293-324 for this guess since it is duplicate
				}
			}
			if (!skip.equals("yes")) {
				for(int i=0; i<=characters.size()-1; i++) {  //goes through letters in chosenword
					if (characters.get(i) == guess) { //guess is some or 1 letter in chosenword
						correctLetter+=1; //add correct number of letters to total
						thisGuessCorrect+=1; //add correct number of letters for this individual guess
						//System.out.println(thisGuessCorrect);
						System.out.println(correctLetter);
						position.add(i);
						//add code to print the individual label with that character 
						hangman.updateCorrectGuesses(characters, position);
					}
				}
				if (correctLetter == characters.size()) { //guessed all letters in chosenword
					sc.close(); //stop looking for input
					System.out.println("Game complete!");
					showMessageDialog(null, "Good Game, you won");
					break;
					
				}
				
				if (thisGuessCorrect == 0) { //guess not any letter in chosenword
					System.out.println("Incorrect. Try again.");
					hangman.increaseGuess();
					wrongGuesses.add(guess);
					System.out.println(wrongGuesses); //check code
					//update graphics for each of the wrong guesses (to be displayed)
					hangman.updateWrongGuesses(wrongGuesses);
					if (hangman.getGuesses()==end) {//max number of wrong guesses reached
						sc.close(); //stop looking for input
						System.out.println("Game over!");
						showMessageDialog(null, "Good Game, you Lost");
						break;
					}
				}
			}
			thisGuessCorrect = 0; //resets thisGuessCorrect variable
			letters.add(guess); //add specific guess to list
			guesses++;
			skip = "no"; //reset variable
			guess = hangman.getGuessChar();
			
		}
	}
	
}
