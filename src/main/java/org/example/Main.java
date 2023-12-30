package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        // Assume rolls for a game are inputted here
        int[] rolls = {10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1};
        GameUtils.validateRoll(rolls);
        for (int pins : rolls) {
            game.roll(pins);
        }
        int totalScore = game.score();
        System.out.println("Total score: " + totalScore);
    }
}
