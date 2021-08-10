package com.small.dicegame;

import java.util.Arrays;

public class DiceGame {

    private GameStates gameState = GameStates.NEW_GAME;
    private Hand hand = new Hand();

    public GameStates getState() {
        return gameState;
    }

    public void roll() {
        if (gameState == GameStates.NEW_GAME || gameState == GameStates.HOLDS_PLACED) {
            hand.roll();
            gameState = GameStates.IN_PROGRESS;
        }
    }

    public void newGame() {
        hand = new Hand();
        gameState = GameStates.NEW_GAME;
    }

    public Integer getScore() {
        if (gameState == GameStates.GAME_COMPLETE) {
            return hand.getScore();
        }
        return null;
    }

    public Boolean[] getHolds() {
        return hand.getHolds();
    }

    public void setHolds(int... holds) {
        if (gameState == GameStates.IN_PROGRESS || gameState == GameStates.HOLDS_PLACED) {
            hand.hold(holds);
            if (Arrays.stream(getHolds()).allMatch(e -> e)) {
                gameState = GameStates.GAME_COMPLETE;
            } else {
                gameState = GameStates.HOLDS_PLACED;
            }
        }
    }

    public int[] getValues() {
        return hand.getValues();
    }

    public enum GameStates {
        NEW_GAME,
        IN_PROGRESS,
        HOLDS_PLACED,
        GAME_COMPLETE
    }
}
