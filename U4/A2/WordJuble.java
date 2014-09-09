import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WordJuble {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		//take in the input
		ArrayList<String> possibles = jumble(JOptionPane
				.showInputDialog("What word would you like to jumble?"));
		
		//print out the info
		System.out.println(possibles.toString().replace("[", "").replace("]", "").replace(" ", "")
				.replace(",", "\n"));
	}

	//jumble
	private static ArrayList<String> jumble(String word) {
		return jumble(word, "");
	}

	//jumbe the words
	private static ArrayList<String> jumble(String word, String jumbLet) {
		ArrayList<String> words = new ArrayList<String>();
		String remainingLetters;
		String origWord = word;
		String origJumbledLetters = jumbLet;
		if (word.length() == 1) {
			words.add(jumbLet + word);
		} else {
			for (int pos = 0; pos < origWord.length(); pos++) {
				remainingLetters = origWord.substring(0, pos)
						+ origWord.substring(pos + 1, origWord.length());
				words.addAll(jumble(remainingLetters, origJumbledLetters + origWord.charAt(pos)));
			}
		}
		return words;
	}
}
