package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        // Assume rolls for a game are inputted here
        int[] rolls = {3, 5, 10, 4, 6, 7, 2, 3, 150, 8, 1, 10, 10, 10, 9, 0};
        for (int pins : rolls) {
            game.roll(pins);
        }

        int totalScore = game.score();
        System.out.println("Total score: " + totalScore);
    }
}
