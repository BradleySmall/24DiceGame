/*
 * Copyright (c) 2021. Bradley M. Small
 * All rights reserved.
 */

package com.small.dicegame;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class DiceGameTest {
    @Test
    public void shouldShowValForVal() {
        assertEquals(1, new Die(6, 1).getValue());
        assertEquals(2, new Die(6, 2).getValue());
        assertEquals(3, new Die(6, 3).getValue());
        assertEquals(4, new Die(6, 4).getValue());
        assertEquals(5, new Die(6, 5).getValue());
        assertEquals(6, new Die(6, 6).getValue());
    }

    @Test
    public void shouldShow6ForDefault() {
        assertEquals(6, new Die().getValue());
    }

    @Test
    public void shouldShow8For8SidedWithoutInitialValue() {
        assertEquals(8, new Die(8).getValue());
    }

    @Test
    public void shouldShowValueBetween1and6() {
        Die die = new Die();

        for (int i = 0; i < 100; ++i) {
            die.roll();
            assertTrue("Too Low", 1 <= die.getValue());
            assertTrue("Too High", 6 >= die.getValue());
        }
    }

    @Test
    public void shouldShow_666666_ForHand_6() {
        assertArrayEquals(new int[]{6, 6, 6, 6, 6, 6}, new Hand().getValues());
    }

    @Test
    public void showHandRoll() {
        Hand hand = new Hand();
        System.out.println(Arrays.toString(hand.getValues()));
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        assertTrue(true);
    }

    @Test
    public void showHeldRoll() {
        Hand hand = new Hand();
        System.out.println(Arrays.toString(hand.getValues()));
        hand.hold(0, 1, 2, 3, 4, 5);
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        hand.unHold(0, 1, 2, 3, 4, 5);
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        assertTrue(true);
    }

    @Test
    public void showScoring() {
        Hand hand = new Hand();
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        System.out.println(hand.getScore());
        assertTrue(true);
    }

    @Test
    public void shouldCreateNewGame() {
        DiceGame game = new DiceGame();
        game.newGame();
        assertNull(game.getScore());
        assertArrayEquals(new Boolean[]{false, false, false, false, false, false}, game.getHolds());
        assertArrayEquals(new int[]{6, 6, 6, 6, 6, 6}, game.getValues());
        assertEquals(DiceGame.GameStates.NEW_GAME, game.getState());
    }

    @Test
    public void shouldSetHolds() {
        DiceGame game = new DiceGame();
        game.roll();
        game.setHolds(0, 2, 4);
        assertArrayEquals(new Boolean[]{true, false, true, false, true, false}, game.getHolds());
        assertNull(game.getScore());
        game.newGame();
        game.roll();
        game.setHolds(1, 3, 5);
        assertArrayEquals(new Boolean[]{false, true, false, true, false, true}, game.getHolds());
        assertNull(game.getScore());
        game.newGame();
        game.roll();
        game.setHolds(0, 1, 2, 3, 4, 5);
        assertArrayEquals(new Boolean[]{true, true, true, true, true, true}, game.getHolds());
        assertNotNull(game.getScore());
    }

    @Test
    public void shouldPlay() {
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

        game.setHolds(0, 1, 2, 3, 4, 5);
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
