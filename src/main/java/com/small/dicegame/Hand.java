package com.small.dicegame;

import static java.util.Arrays.setAll;
import static java.util.Arrays.stream;

public class Hand {
    private final Boolean[] holds;
    private final Die[] dice = new Die[6];

    Hand() {
        setAll(dice, index -> new Die());
        holds = new Boolean[]{false, false, false, false, false, false};
    }

    public int[] getValues() {
        int[] values;
        values = stream(dice).mapToInt(Die::getValue).toArray();
        return values;
    }

    public void roll() {
        for (int index = 0; index < holds.length; ++index) {
            if (Boolean.FALSE.equals(holds[index])) {
                dice[index].roll();
            }
        }
    }

    public void unHold(int... held) {
        for (int index : held) {
            holds[index] = false;
        }
    }

    public void hold(int... held) {
        for (int index : held) {
            holds[index] = true;
        }
    }

    public int getScore() {
        return stream(dice).mapToInt(Die::getValue).filter(e -> e == 2 || e == 4).distinct().count() == 2 ?
                stream(dice).mapToInt(Die::getValue).sum() - 6 :
                0;
    }

    public Boolean[] getHolds() {
        return holds;
    }
}
