package org.example;

import java.util.Arrays;
import java.util.List;

class GameUtils {
    static void validatePins(int pins) {
        if (pins < 0 || pins > 10) {
            throw new IllegalArgumentException("Number of pins must be between 0 and 10");
        }
    }

    static void validateFrame(int pins) {
        if (pins < 0 || pins > 10) {
            throw new IllegalArgumentException("Number of pins must be between 0 and 10");
        }
    }

    static void validateRoll(int[] rolls) {
        if (isInvalidRoll(Arrays.asList(Arrays.stream(rolls).boxed().toArray(Integer[]::new)))) {
            throw new IllegalArgumentException("Invalid sequence of rolls.");
        }
    }

    private static boolean isInvalidRoll(List<Integer> rolls) {
        int size = rolls.size();

        if (size % 2 == 0) {
            // Even-sized means we're starting a new frame
            if (size < 18 && rolls.get(size - 2) == 10) {
                // Strike before the last frame should not be allowed
                return true;
            } else if (size >= 18 && rolls.get(size - 2) != 10 && rolls.get(size - 2) + rolls.get(size - 1) > 10) {
                // Current roll, after a non-strike in the last frame, exceeds 10 pins
                return true;
            }
        } else {
            // Odd-sized means we're in the middle of a frame
            int frameScore = rolls.get(size - 2) + rolls.get(size - 1);
            if (frameScore > 10) {
                // Sum of current and previous rolls exceeds 10 in a frame
                return true;
            }
        }

        return false;
    }



    static boolean isStrike(int rollIndex, List<Integer> rolls) {
        return rolls.get(rollIndex) == 10;
    }

    static boolean isSpare(int rollIndex, List<Integer> rolls) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1) == 10;
    }

    static int strikeBonus(int rollIndex, List<Integer> rolls) {
        return rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
    }

    static int spareBonus(int rollIndex, List<Integer> rolls) {
        return rolls.get(rollIndex + 2);
    }

    static int frameScore(int rollIndex, List<Integer> rolls) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1);
    }

}

