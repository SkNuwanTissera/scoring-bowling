package org.example;

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

