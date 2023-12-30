package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    @Test
    void testAllZeros() {
        Game game = new Game();
        int[] rolls = new int[20]; // 20 rolls of 0
        for (int pins : rolls) {
            game.roll(pins);
        }
        assertEquals(0, game.score());
    }

    @Test
    void testAllStrikes() {
        Game game = new Game();
        int[] rolls = new int[12]; // 12 strikes
        for (int i = 0; i < 12; i++) {
            rolls[i] = 10;
        }
        for (int pins : rolls) {
            game.roll(pins);
        }
        assertEquals(300, game.score());
    }

    @Test
    void testAllSpares() {
        Game game = new Game();
        int[] rolls = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}; // 21 rolls, all spares
        for (int pins : rolls) {
            game.roll(pins);
        }
        assertEquals(150, game.score());
    }

    @Test
    void testRandomGame() {
        Game game = new Game();
        int[] rolls = {10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1}; // Example game
        for (int pins : rolls) {
            game.roll(pins);
        }
        assertEquals(167, game.score());
    }

    // Negative test cases
    @Test
    void testInvalidNumberOfPins() {
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> game.roll(-1));
    }

//    @Test
//    void testExceedingPinsInFrame() {
//        Game game = new Game();
//        game.roll(5);
//        assertThrows(IllegalArgumentException.class, () -> game.roll(6));
//    }

    @Test
    void testInvalidSequenceOfRolls() {
        int[] rolls = {3, 5, 10, 4, 6, 7, 2, 3, 10, 8, 1, 10, 10, 10, 9};
        assertThrows(IllegalArgumentException.class, () -> GameUtils.validateRoll(rolls));
    }
}