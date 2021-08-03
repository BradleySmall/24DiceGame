package com.small.DiceGame;

import static java.util.Arrays.setAll;
import static java.util.Arrays.stream;

public class Hand {
    public boolean[] holds;
    private final Die[] dice = new Die[6];

    Hand() {
        setAll(dice, index -> new Die());
        holds = new boolean[]{false, false, false, false, false, false};
    }

    public int[] getValues() {
        int[] values;
        values = stream(dice).mapToInt(Die::getValue).toArray();
        return values;
    }

    public void roll() {
        for (int index = 0; index < holds.length; ++index) {
            if (!holds[index]) {
                dice[index].roll();
            }
        }
    }

    public void unhold(int... held) {
        for (int index : held) {
            holds[index - 1] = false;
        }
    }

    public void hold(int... held) {
        for (int index : held) {
            holds[index - 1] = true;
        }
    }

    public int score() {
        return stream(dice).mapToInt(Die::getValue).filter(e -> e == 2 || e == 4).distinct().count() == 2 ?
                stream(dice).mapToInt(Die::getValue).sum() - 6 :
                0;
    }
}
