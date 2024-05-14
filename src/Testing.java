import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Testing extends JFrame {
    private Hangman hangman;
    private JLabel wordLabel;
    private JLabel statusLabel;
    private JPanel drawingPanel;

    public Testing(Hangman hangman) {
        this.hangman = hangman;

        setTitle("Hangman");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        wordLabel = new JLabel();
        statusLabel = new JLabel();
        drawingPanel = new JPanel();

        add(wordLabel, BorderLayout.NORTH);
        add(statusLabel, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);

        updateWordLabel();
        updateStatusLabel();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char guessedLetter = e.getKeyChar();
                if (Character.isLetter(guessedLetter)) {
                    hangman.guessLetter(guessedLetter);
                    updateWordLabel();
                    updateStatusLabel();
                    if (hangman.isGameOver()) {
                        JOptionPane.showMessageDialog(Testing.this, "Game Over!");
                        dispose();
                    }
                }
            }
        });

        setVisible(true);
    }

    private void updateWordLabel() {
        String word = hangman.getVisibleWord();
        wordLabel.setText("Word: " + word);
    }

    private void updateStatusLabel() {
        statusLabel.setText("Incorrect guesses: " + hangman.getIncorrectGuesses());
        drawHangman();
    }

    private void drawHangman() {
        int incorrectGuesses = hangman.getIncorrectGuesses();
        drawingPanel.removeAll();
        switch (incorrectGuesses) {
            case 1:
                drawingPanel.add(new JLabel("Your drawing for 1 incorrect guess"));
                break;
            case 2:
                drawingPanel.add(new JLabel("Your drawing for 2 incorrect guesses"));
                break;
            // Add more cases for each part of the hangman
        }
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        Hangman hangman = new Hangman(); // Assuming you have a Hangman class
        SwingUtilities.invokeLater(() -> new Testing(hangman));
    }
}
