package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.GameUtils.frameScore;
import static org.example.GameUtils.isSpare;
import static org.example.GameUtils.isStrike;
import static org.example.GameUtils.spareBonus;
import static org.example.GameUtils.strikeBonus;
import static org.example.GameUtils.validateFrame;
import static org.example.GameUtils.validatePins;

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
     *             Must be between 0 and 10.
     *             If the number of pins is invalid, an IllegalArgumentException is thrown.
     *             If the number of pins is valid, it is added to the list of rolls.
     *             If the number of pins is valid, but the frame is invalid, an IllegalArgumentException is thrown.
     */
    public void roll(int pins) {
        validatePins(pins);
        validateFrame(pins);
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
            if (isStrike(rollIndex, rolls)) {
                totalScore += 10 + strikeBonus(rollIndex, rolls);
                rollIndex += 1;
            } else if (isSpare(rollIndex, rolls)) {
                totalScore += 10 + spareBonus(rollIndex, rolls);
                rollIndex += 2;
            } else {
                totalScore += frameScore(rollIndex, rolls);
                rollIndex += 2;
            }
        }

        return totalScore;
    }


}
