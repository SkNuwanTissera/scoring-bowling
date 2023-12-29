package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game of bowling.
 */
public class Game {
    private List<Integer> rolls;

    /**
     * Constructs a new Game object.
     */
    public Game() {
        rolls = new ArrayList<>();
    }

    /**
     * Records the number of pins knocked down in a roll.
     *
     * @param pins The number of pins knocked down in the roll.
     */
    public void roll(int pins) {
        rolls.add(pins);
    }

    /**
     * Calculates and returns the total score of the game.
     *
     * @return The total score of the game.
     */
    public int score() {
        int totalScore = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
                totalScore += 10 + strikeBonus(rollIndex);
                rollIndex += 1;
            } else if (isSpare(rollIndex)) {
                totalScore += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                totalScore += frameScore(rollIndex);
                rollIndex += 2;
            }
        }

        return totalScore;
    }

    // Helper methods

    private boolean isStrike(int rollIndex) {
        return rolls.get(rollIndex) == 10;
    }

    private boolean isSpare(int rollIndex) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1) == 10;
    }

    private int strikeBonus(int rollIndex) {
        return rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
    }

    private int spareBonus(int rollIndex) {
        return rolls.get(rollIndex + 2);
    }

    private int frameScore(int rollIndex) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1);
    }
}
