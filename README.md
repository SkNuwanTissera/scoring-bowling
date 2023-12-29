# Bowling Game

This Java class `Game` simulates a game of bowling. It keeps track of rolls and calculates the total score based on the rules of bowling.

## How to Use

1. **Setup**

    - Instantiate a `Game` object: `Game game = new Game();`

2. **Rolling**

    - Use the `roll(int pins)` method to record the number of pins knocked down in each roll:
      ```java
      game.roll(3); // Example roll with 3 pins knocked down
      ```

3. **Calculating Score**

    - At the end of the game, call the `score()` method to get the total score:
      ```java
      int totalScore = game.score();
      ```

4. **Example**

    ```java
    // Example usage:
    Game game = new Game();
    int[] rolls = {3, 5, 10, 4, 6, 7, 2, 3, 10, 8, 1, 10, 10, 10, 9, 0};
    for (int pins : rolls) {
        game.roll(pins);
    }

    int totalScore = game.score();
    System.out.println("Total score: " + totalScore);
    ```

## Methods

- `void roll(int pins)`
    -  Records the number of pins knocked down in a roll.

- `int score()`
    - Calculates and returns the total score of the game.

## Class Structure

- `Game`
    - Represents a game of bowling.
    - Maintains a list of rolls and computes the score based on bowling rules.

