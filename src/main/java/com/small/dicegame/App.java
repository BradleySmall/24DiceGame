/*
 * Copyright (c) 2021. Bradley M. Small
 * All rights reserved.
 */

package com.small.dicegame;

import javax.swing.*;
import java.util.Arrays;

public class App extends JFrame {
    public static final int NUMBER_OF_DICE = 6;
    private final DieBox[] dieBoxes = new DieBox[NUMBER_OF_DICE];
    private final JButton rollButton = new JButton("Roll");
    private final JButton newGameButton = new JButton("New Game");
    private final JTextArea scoreText = new JTextArea();
    private final transient DiceGame game = new DiceGame();

    App() {
        initGui();
    }

    private void initGui() {
        setTitle("24 Dice Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        Box diceBox = Box.createHorizontalBox();
        for (int index = 0, dieBoxesLength = dieBoxes.length; index < dieBoxesLength; index++) {
            dieBoxes[index] = new DieBox(index);
            dieBoxes[index].addActionListener(e -> {
                JButton holdButton = (JButton) e.getSource();
                holdButton.setEnabled(false);
                DieBox dieBox = (DieBox) holdButton.getParent();

                hold(dieBox.getIndex());
                checkScore();
            });
            diceBox.add(dieBoxes[index]);
        }
        add(diceBox);

        JPanel buttonPanel = new JPanel();
        rollButton.setEnabled(false);
        rollButton.addActionListener(e -> {
            if (areAllHeld()) {
                for (DieBox d : dieBoxes) d.setButtonEnabled(true);
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

    private void checkScore() {
        if (areAllHeld()) {
            newGameButton.setEnabled(true);
            rollButton.setEnabled(false);

            scoreText.setText("Your score = " + score());
            scoreText.setEnabled(true);
            scoreText.setVisible(true);
        } else {
            rollButton.setEnabled(true);
        }
    }

    private boolean areAllHeld() {
        return Arrays.stream(dieBoxes).noneMatch(DieBox::isButtonEnabled);

    }

    private void updateDiePanelValues(int [] values) {
        for (int index = 0; index < NUMBER_OF_DICE ; ++index) {
            dieBoxes[index].setCurrentValue(values[index]);
        }
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
