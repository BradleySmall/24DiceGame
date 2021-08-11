package com.small.dicegame;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class App extends JFrame {
    public static final int NUMBER_OF_DICE = 6;
    private final DiePanel[] diePanels = new DiePanel[NUMBER_OF_DICE];
    private final JButton[] holdButtons = new JButton[NUMBER_OF_DICE];
    private final JButton rollButton = new JButton("Roll");
    private final JButton newGameButton = new JButton("New Game");
    private final JTextArea scoreText = new JTextArea();
    private final transient DiceGame game = new DiceGame();
    App() {
        initGui();
    }

    private void initGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

        IntStream.range(0, NUMBER_OF_DICE).forEach(index -> {
            diePanels[index] = new DiePanel();
            diePanels[index].setLayout(new BoxLayout(diePanels[index], BoxLayout.PAGE_AXIS));
            diePanels[index].setCurrentValue(6);
            diePanels[index].add(Box.createRigidArea(new Dimension(0, 70)));
            holdButtons[index] = new JButton("Hold");
            holdButtons[index].setEnabled(false);
            holdButtons[index].addActionListener(e -> {
                JButton holdButton = (JButton) e.getSource();
                holdButton.setEnabled(false);
                hold(getHoldButtonIndex(holdButton));
                if (areAllHeld()) {
                    newGameButton.setEnabled(true);
                    rollButton.setEnabled(false);

                    scoreText.setText("Your score = " + score());
                    scoreText.setEnabled(true);
                    scoreText.setVisible(true);
                } else {
                    rollButton.setEnabled(true);
                }
            });
            diePanels[index].add(holdButtons[index]);
            panel.add(diePanels[index]);
        });

        add(panel);

        JPanel buttonPanel = new JPanel();

        rollButton.setEnabled(false);
        rollButton.addActionListener(e -> {
            if (areAllHeld()) {
                for (JButton b : holdButtons) b.setEnabled(true);
            }
            rollButton.setEnabled(false);
            updateDiePanelValues(roll());
        });
        buttonPanel.add(rollButton);

        buttonPanel.add(newGameButton);
        newGameButton.addActionListener(e -> {
            newGameButton.setEnabled(false);
            rollButton.setEnabled(true);
            scoreText.setEnabled(false);
            scoreText.setVisible(false);
            newGame();
        });

        add(buttonPanel);
        scoreText.setText("Score = 0");
        scoreText.setEnabled(false);
        add(scoreText);
        pack();
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean areAllHeld() {
        return Arrays.stream(holdButtons).noneMatch(JButton::isEnabled);
    }

    private void updateDiePanelValues(int [] values) {
        for (int index = 0; index < NUMBER_OF_DICE ; ++index) {
            diePanels[index].setCurrentValue(values[index]);
        }
    }

    private int getHoldButtonIndex (JButton b) {
        for (int holdIndex = 0; holdIndex < NUMBER_OF_DICE; ++holdIndex) {
            if (b == holdButtons[holdIndex]) {
                return holdIndex;
            }
        }
        return -1;
    }

    private void newGame() {
        game.newGame();
    }

    private int score() {
        return game.getScore();
    }

    private void hold(int holdIndex) {
        game.setHolds(holdIndex);
    }

    private int[] roll() {
        game.roll();
        return game.getValues();
    }

    public static void main(String[] args) {
        new App();
    }
}
