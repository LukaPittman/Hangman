import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;
public class Hangman {
	
	
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
		Scanner sc = new Scanner(System.in);
		
		int index = (int)(Math.random()*50);
		ArrayList<String> words = getWords();
		String chosenWord = words.get(index);
		
		List<Character> characters = new ArrayList<>();	
		for( char c :chosenWord.toCharArray()) {
			characters.add(c);
		}
		
		String guess = sc.nextLine();
		char letter;
		if (guess.length() > 1) {
			//This is a word
			System.out.println("Incorrect. Try again.");
			guess = sc.nextLine();
		} else {
			letter = guess.charAt(0);
		}
		for(int i=1; i<=characters.size(); i++) {
			while (characters.get(i) != letter) {
				System.out.println("Incorrect. Try again.");
				guess = sc.nextLine();
			}	
		sc.close(); //stop looking for input
		}
	}
