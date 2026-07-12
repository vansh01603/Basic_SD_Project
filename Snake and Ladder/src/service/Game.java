package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;
public class Game {

    private final Board board;
    private final Dice dice;
    private final List<Player> players;
    private final Scanner scanner = new Scanner(System.in);

    private int currentPlayerIndex;
    private boolean gameOver;

    public Game() {

        board = new Board(100);
        dice = new Dice();
        players = new ArrayList<>();

        currentPlayerIndex = 0;
        gameOver = false;

        initializePlayers();
        initializeBoard();
    }

    private void initializePlayers() {

        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
    }

    private void initializeBoard() {

        board.addSnake(new Snake(99, 40));
        board.addSnake(new Snake(75, 32));
        board.addSnake(new Snake(54, 12));

        board.addLadder(new Ladder(4, 25));
        board.addLadder(new Ladder(13, 46));
        board.addLadder(new Ladder(42, 81));
    }

    public void start() {

        while (!gameOver) {

            Player player = players.get(currentPlayerIndex);

            System.out.println("--------------------------------");

            System.out.println(player.getName() + "'s Turn");

            System.out.println("\n---------------------------------");
System.out.println("🎲 " + player.getName() + "'s Turn");
System.out.print("Press ENTER to roll the dice...");
scanner.nextLine();

System.out.print("Rolling");

try {
    for (int i = 0; i < 3; i++) {
        Thread.sleep(300);
        System.out.print(".");
    }
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

System.out.println();

int roll = dice.roll();

System.out.println("🎲 You rolled: " + roll);

            System.out.println("Dice : " + roll);

            movePlayer(player, roll);

            if (player.getPosition() == 100) {

                System.out.println(player.getName() + " Wins!");

                gameOver = true;

                break;
            }

            currentPlayerIndex =
                    (currentPlayerIndex + 1) % players.size();
        }
    }

    private void movePlayer(Player player, int diceValue) {

        int current = player.getPosition();

        int next = current + diceValue;

        if (next > 100) {

            System.out.println("Cannot Move.");

            return;
        }

        player.setPosition(next);

        System.out.println("Moved to " + next);

        next = board.getFinalPosition(next);

        player.setPosition(next);

        System.out.println("Current Position : " + next);
    }
}