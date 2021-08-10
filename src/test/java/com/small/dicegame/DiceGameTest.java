package com.small.dicegame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DiceGameTest {
    @Test
    void shouldShowValForVal() {
        assertEquals(1, new Die(6, 1).getValue());
        assertEquals(2, new Die(6, 2).getValue());
        assertEquals(3, new Die(6, 3).getValue());
        assertEquals(4, new Die(6, 4).getValue());
        assertEquals(5, new Die(6, 5).getValue());
        assertEquals(6, new Die(6, 6).getValue());
    }

    @Test
    void shouldShow6ForDefault() {
        assertEquals(6, new Die().getValue());
    }

    @Test
    void shouldShow8For8SidedWithoutInitialValue() {
        assertEquals(8, new Die(8).getValue());
    }

    @Test
    void shouldShowValueBetween1and6() {
        Die die = new Die();

        for (int i = 0; i < 100; ++i) {
            die.roll();
            assertTrue(1 <= die.getValue(), "Too Low");
            assertTrue(6 >= die.getValue(), "Too High");
        }
    }

    @Test
    void shouldShow_666666_ForHand_6() {
        assertArrayEquals(new int[]{6, 6, 6, 6, 6, 6}, new Hand().getValues());
    }

    @Test
    void showHandRoll() {
        Hand hand = new Hand();
        System.out.println(Arrays.toString(hand.getValues()));
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        assertTrue(true);
    }

    @Test
    void showHeldRoll() {
        Hand hand = new Hand();
        System.out.println(Arrays.toString(hand.getValues()));
        hand.hold(1, 2, 3, 4, 5, 6);
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        hand.unhold(1, 2, 3, 4, 5, 6);
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        assertTrue(true);
    }

    @Test
    void showScoring() {
        Hand hand = new Hand();
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        System.out.println(hand.getScore());
        assertTrue(true);
    }

    @Test
    void shouldCreateGame() {
        assertInstanceOf(DiceGame.class, new DiceGame());
    }

    @Test
    void shouldCreateNewGame() {
        DiceGame game = new DiceGame();
        game.newGame();
        assertNull(game.getScore());
        assertArrayEquals(new Boolean[]{false, false, false, false, false, false}, game.getHolds());
        assertArrayEquals(new int[]{6, 6, 6, 6, 6, 6}, game.getValues());
        assertEquals(DiceGame.GameStates.NEW_GAME, game.getState());
    }

    @Test
    void shouldSetHolds() {
        DiceGame game = new DiceGame();
        game.roll();
        game.setHolds(1, 3, 5);
        assertArrayEquals(new Boolean[]{true, false, true, false, true, false}, game.getHolds());
        assertNull(game.getScore());
        game.newGame();
        game.roll();
        game.setHolds(2, 4, 6);
        assertArrayEquals(new Boolean[]{false, true, false, true, false, true}, game.getHolds());
        assertNull(game.getScore());
        game.newGame();
        game.roll();
        game.setHolds(1, 2, 3, 4, 5, 6);
        assertArrayEquals(new Boolean[]{true, true, true, true, true, true}, game.getHolds());
        assertNotNull(game.getScore());
    }
    @Test
    void shouldPlay() {
        DiceGame game = new DiceGame();
        System.out.println(Arrays.toString(game.getHolds()));
        System.out.println(Arrays.toString(game.getValues()));
        System.out.println(game.getScore());

        game.roll();
        System.out.println(Arrays.toString(game.getHolds()));
        System.out.println(Arrays.toString(game.getValues()));
        System.out.println(game.getScore());

        game.roll();
        System.out.println(Arrays.toString(game.getHolds()));
        System.out.println(Arrays.toString(game.getValues()));
        System.out.println(game.getScore());

        game.setHolds(1,2,3,4,5,6);
        System.out.println(Arrays.toString(game.getHolds()));
        System.out.println(Arrays.toString(game.getValues()));
        System.out.println(game.getScore());

        game.roll();
        System.out.println(Arrays.toString(game.getHolds()));
        System.out.println(Arrays.toString(game.getValues()));
        System.out.println(game.getScore());

        assertTrue(true);
    }
}
