import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hangman extends JFrame{
	
	
		
	
public Hangman() {
	setTitle("Hangman");
	setSize(1200,800);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new GridLayout(4,2,5,5));
	setResizable(false);
	
	
	
}
	
	public static ArrayList<String> getWords() {
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
	
	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		hangman.setVisible(true);
		
		Scanner sc = new Scanner(System.in);
		
		int index = (int)(Math.random()*50);
		ArrayList<String> words = getWords();
		String chosenWord = words.get(index);
		
		List<Character> characters = new ArrayList<>();	
		for( char c :chosenWord.toCharArray()) {
			characters.add(c);
		}
		for (Character ch : characters) {
            JLabel label = new JLabel(ch.toString()); // Create JLabel with character text
            label.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font size and style
            hangman.add(label); // Add label to the frame
        }
		
		String guess = sc.toString();
		System.out.println("You're correct!");

		for ()
		while (Character[] != ) {
			System.out.println("Incorrect. Try again.");
		    guess = sc.nextInt();
		}
		sc.close(); //stop looking for input

	}

}
