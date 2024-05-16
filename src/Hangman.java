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
	
		
	
public Hangman() {
	// Creates the JFrame and GUI
	
	setTitle("Hangman");
	setSize(1200,800);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	setResizable(false);
	
	
	
}
	// List of words used for Hang Man
	public static ArrayList<String> getWords() {
		// The list
		ArrayList<String> words = new ArrayList<String>();
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
        g2d.drawLine(125, 660,275 , 660);
        // Top Line/Horizontal
        g2d.drawLine(200, 200, 400, 200);
        // Hanging line/Vertical
        g2d.drawLine(400, 200, 400, 250);
        // Restore the previous stroke
        g2d.setStroke(oldStroke);
        
        if (this.wrongGuess ==1) {
        	int centerX = 600;
		    int centerY = 400;
		    int radius = 50;
		    // Draw the circle
			g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        }
        
	}
	
	public void updateWrongGuesses(List<Character> wrongGuesses) {
		int DXAxis = 700;//coordinates for displaying wrong guess labels
		int DYAxis = 200;
		
		//Remove wrong guess labels before adding new ones
		Component[]components = getContentPane().getComponents();
	    for (Component component : components) {
	        if (component instanceof JLabel) {
	            getContentPane().remove(component);
	        }
	    }
	    
	    //Add wrong guess labels
	    for (Character wrongGuessChar : wrongGuesses) {
            // Create a JLabel for the current character
            JLabel label = new JLabel(wrongGuessChar.toString());
            label.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font size and style
            label.setBounds(DXAxis, DYAxis, 30,30);
            getContentPane().add(label); // Add the label to the frame
            DXAxis += 35;
		}
	    
	    revalidate(); //revalidate the frame to reflect changes
	    repaint(); //repaint the frame to ensure updates are shown
	}
	
	// Main Method
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Hangman());
		int correctLetter = 0; //number of correct letters in word guessed from individual guess
		//int wrongGuess = 0; //wrong guessed letter (guess not in word at all)
		int end = 6; //max number of wrong guesses allowed (adjust for difficulty)

		Hangman hangman = new Hangman(); //Creates the window
		
		
		Scanner sc = new Scanner(System.in); // Scanner for user input
		
		
		
		int index = (int)(Math.random()*50); //Chooses random word out of the list
		ArrayList<String> words = getWords();
		String chosenWord = words.get(index);
		System.out.println(chosenWord);
		
		List<Character> characters = new ArrayList<>();	// Separates the chosen word into a list of its individual characters
		for( char c :chosenWord.toCharArray()) {
			characters.add(c);
		}

		// Creates JLabel for each of the characters in the word with the letters
		int XAxis = 700;
		int YAxis = 600;
		for (Character ch : characters) {
            // Create a JLabel for the current character
            JLabel label = new JLabel("__");
            label.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font size and style
            label.setBounds(XAxis, YAxis, 50,50);
            hangman.add(label); // Add the label to the frame
            
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
		
		List<Character> wrongGuesses= new ArrayList<>();	// Stores all guesses into a list
		hangman.updateWrongGuesses(wrongGuesses); //create instance of method in Hangman class
		//  Repeatedly ask user for guesses and checks to see if correct
		for(int i=0; i<characters.size(); i++) {          
			if (characters.get(i) != letter) { //guess not any letter in chosenword
				System.out.println("Incorrect. Try again.");
				hangman.increaseGuess();
				wrongGuesses.add(letter);
				//update graphics for each of the wrong guesses (to be displayed)
				hangman.updateWrongGuesses(wrongGuesses);
				guess = sc.nextLine();
				if (hangman.getGuesses()==end) {//max number of wrong guesses reached
					sc.close(); //stop looking for input
					System.out.println("Game over!");
					break;
				}
			}
			



		
				
			hangman.repaint();
			System.out.print(hangman.getGuesses());
			

			for(int g=0; g<=characters.size()-1; g++) { //goes through letters in chosenword
				if (characters.get(g) == letter) { //guess is some or 1 letter in chosenword
					correctLetter+=1; //add correct number of letters
					//add code to print the individual label with that character 
					
				}
				if (correctLetter == characters.size()-1) { //guessed all letters in chosenword
					sc.close(); //stop looking for input
					System.out.println("Game complete!");
				}
			}
		}

	}
}
