package com.small.dicegame;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class App extends JFrame {
    DiePanel[] diePanels = new DiePanel[6];
    JButton[] holdButtons = new JButton[6];
    JButton rollButton = new JButton("Roll");
    JButton newGameButton = new JButton("New Game");
    JTextArea scoreText = new JTextArea();
    App() {
        initGui();
    }

    public static void main(String[] args) {
        new App();
    }

    private boolean areAllHeld() {
        return Arrays.stream(holdButtons).noneMatch(JButton::isEnabled);
    }

    private void initGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

        for (int i = 0; i < 6; ++i) {
            diePanels[i] = new DiePanel();
            diePanels[i].setLayout(new BoxLayout(diePanels[i], BoxLayout.PAGE_AXIS));
            diePanels[i].setCurrentValue(i + 1);
            diePanels[i].add(Box.createRigidArea(new Dimension(0, 70)));
            holdButtons[i] = new JButton("Hold");
            holdButtons[i].setEnabled(false);
            holdButtons[i].addActionListener(e -> {
                JButton b = (JButton) e.getSource();
                b.setEnabled(false);
                if (areAllHeld()) {
                    newGameButton.setEnabled(true);
                    rollButton.setEnabled(false);
                    int score = 17;
                    scoreText.setText("Your score = " + score);
                    scoreText.setEnabled(true);
                    scoreText.setVisible(true);
                } else {
                    rollButton.setEnabled(true);
                }
            });
            diePanels[i].add(holdButtons[i]);
            panel.add(diePanels[i]);
        }

        add(panel);

        JPanel buttonPanel = new JPanel();

        rollButton.setEnabled(false);
        rollButton.addActionListener(e -> {
            if (areAllHeld()) {
                for (JButton b : holdButtons) b.setEnabled(true);
            }
            rollButton.setEnabled(false);
        });
        buttonPanel.add(rollButton);

        buttonPanel.add(newGameButton);
        newGameButton.addActionListener(e -> {
            newGameButton.setEnabled(false);
            rollButton.setEnabled(true);
            scoreText.setEnabled(false);
            scoreText.setVisible(false);
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
}
