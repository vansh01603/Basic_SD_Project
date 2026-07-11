package service;

import model.*;

import java.util.Scanner;

public class Game {

    private final Board board;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;

    private final Scanner sc = new Scanner(System.in);

    public Game(int size) {

        board = new Board(size);

        player1 = new Player("Player 1", Symbol.X);
        player2 = new Player("Player 2", Symbol.O);

        currentPlayer = player1;
    }

    public void start() {

        while (true) {

            board.printBoard();

            System.out.println(currentPlayer.getName() + "'s Turn");

            System.out.print("Row : ");
            int row = sc.nextInt();

            System.out.print("Col : ");
            int col = sc.nextInt();

            boolean success = board.placeMove(row, col, currentPlayer.getSymbol());

            if (!success) {
                System.out.println("Invalid Move!");
                continue;
            }

            if (board.checkWinner(currentPlayer.getSymbol())) {

                board.printBoard();

                System.out.println(currentPlayer.getName() + " Wins!");

                break;
            }

            if (board.isFull()) {

                board.printBoard();

                System.out.println("Match Draw!");

                break;
            }

            switchTurn();
        }
    }

    private void switchTurn() {

        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}