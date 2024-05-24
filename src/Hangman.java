// Imports
import java.util.ArrayList;
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

public class Hangman extends JFrame{
	private static Graphics globalGraphics; // Global Graphics object
	
	private int wrongGuess = 0;
	private List<JLabel> wordLabels = new ArrayList<>(); //store word labels
	private List<JLabel> wrongGuessLabels = new ArrayList<>(); //store wrong guess labels
	
public Hangman() {
	// Creates the JFrame and GUI //hi
	
	setTitle("Hangman");
	setSize(1200, 800);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	setResizable(false);
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
	
	public void increaseGuess() {
		this.wrongGuess++;
	}
	
	public int getGuesses() {
		return this.wrongGuess;
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
        	int centerX = 400;
		    int centerY = 300;
		    int radius = 50;
		    // Draw the circle
			g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        }
		
        // Adds the body
        if (this.wrongGuess >=2) {
			g2d.setStroke(new BasicStroke(5)); // Set the line thickness to 5 pixels
			// Draw body line
			g2d.drawLine(400, 350, 400, 550);
			}
		
        // Adds the first arm
        if (this.wrongGuess >=3 ) {
			g2d.setStroke(new BasicStroke(5));
			// Draw arm1
			g2d.drawLine(350, 375, 399, 450);
		}
        
        // Adds the second arm
		if (this.wrongGuess >=4 ) {
			g2d.setStroke(new BasicStroke(5));
			// Draw arm1
			g2d.drawLine(450, 375, 401, 450);
		}
		
		// Adds the first leg
		if (this.wrongGuess >=5 ) {
			g2d.setStroke(new BasicStroke(5));
			// Draw leg1
			g2d.drawLine(350, 650, 399, 550);
		}
		
		// Adds the second leg
		if (this.wrongGuess >=6 ) {
			g2d.setStroke(new BasicStroke(5));
			// Draw leg2
			g2d.drawLine(450, 650, 401, 550);
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
	    
	    revalidate(); //revalidate the frame to reflect changes
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
		SwingUtilities.invokeLater(() -> new Hangman());
		int correctLetter = 0; //number of correct letters in word in total guessed
		int thisGuessCorrect = 0; //number of correct letters in word guessed by individual guess
		//int wrongGuess = 0; //wrong guessed letter (guess not in word at all)
		int end = 6; //max number of wrong guesses allowed (adjust for difficulty)

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
		

		String guess = sc.nextLine();   // Checks if guess is a letter or a word
		char letter=' ';//default first guess

		if (guess.length() > 1) {
			//This is a word
			System.out.println("Incorrect. Try again."); // Guess is wrong
			guess = sc.nextLine();
		} else {
			letter = guess.charAt(0); //takes the first character of the word 
		}
		List<Integer> position= new ArrayList<>();	// Stores all position of correct guess into a list
		List<Character> wrongGuesses= new ArrayList<>();	// Stores all guesses into a list
		hangman.updateWrongGuesses(wrongGuesses); //create instance of method in Hangman class
		//  Repeatedly ask user for guesses and checks to see if correct
		while(!guess.equals("STOP")) {
			for(int i=0; i<=characters.size()-1; i++) {  //goes through letters in chosenword
				if (characters.get(i) == letter) { //guess is some or 1 letter in chosenword
					correctLetter+=1; //add correct number of letters to total
					thisGuessCorrect+=1; //add correct number of letters for this individual guess
					position.add(i);
					//add code to print the individual label with that character 
					hangman.updateCorrectGuesses(characters, position);
				}
			}
			if (correctLetter == characters.size()) { //guessed all letters in chosenword
				sc.close(); //stop looking for input
				System.out.println("Game complete!");
				break;
			}
			
			if (thisGuessCorrect == 0) { //guess not any letter in chosenword
				System.out.println("Incorrect. Try again.");
				hangman.increaseGuess();
				wrongGuesses.add(letter);
				System.out.println(wrongGuesses); //check code
				//update graphics for each of the wrong guesses (to be displayed)
				hangman.updateWrongGuesses(wrongGuesses);
				if (hangman.getGuesses()==end) {//max number of wrong guesses reached
					sc.close(); //stop looking for input
					System.out.println("Game over!");
					break;
				}
			}
			thisGuessCorrect = 0; //resets thisGuessCorrect variable
			guess = sc.nextLine();
			letter = guess.charAt(0);
			
			//hangman.repaint();
			//System.out.print(hangman.getGuesses());
		}
	}
}
