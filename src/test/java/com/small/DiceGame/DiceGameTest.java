package com.small.DiceGame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DiceGameTest {
    @Test
    void shouldShowValForVal() {
        assertEquals("1", new Die(6, 1).toString());
        assertEquals("2", new Die(6, 2).toString());
        assertEquals("3", new Die(6, 3).toString());
        assertEquals("4", new Die(6, 4).toString());
        assertEquals("5", new Die(6, 5).toString());
        assertEquals("6", new Die(6, 6).toString());
    }

    @Test
    void shouldShow6ForDefault() {
        assertEquals("6", new Die().toString());
    }

    @Test
    void shouldShow8For8SidedWithoutInitialValue() {
        assertEquals("8", new Die(8).toString());
    }

    @Test
    void shouldShowValueBetween1and6() {
        Die die = new Die();

        for (int i = 0; i < 100; ++i) {
            die.roll();
            // System.out.println(die.getValue());
            assertTrue(1 <= die.getValue(), "Too High");
            assertTrue(6 >= die.getValue(), "Too Low");
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
    }
    @Test
    void showHeldRoll() {
        Hand hand = new Hand();
        System.out.println(Arrays.toString(hand.getValues()));
        //System.out.println(Arrays.toString(hand.holds));
        hand.hold(1,2,3,4,5,6);
        //System.out.println(Arrays.toString(hand.holds));
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        hand.unhold(1,2,3,4,5,6);
        //System.out.println(Arrays.toString(hand.holds));
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
    }
    @Test
    void showScoring() {
        Hand hand = new Hand();
        hand.roll();
        System.out.println(Arrays.toString(hand.getValues()));
        System.out.println(hand.score());
    }
}
