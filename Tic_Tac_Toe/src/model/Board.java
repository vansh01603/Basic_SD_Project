package model;
public class Board {

    private final int size;
    private final Cell[][] board;

    public Board(int size) {
        this.size = size;
        board = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean placeMove(int row, int col, Symbol symbol) {

        if (row < 0 || row >= size || col < 0 || col >= size)
            return false;

        if (!board[row][col].isEmpty())
            return false;

        board[row][col].setSymbol(symbol);
        return true;
    }

    public boolean checkWinner(Symbol symbol) {

        // Rows
        for (int i = 0; i < size; i++) {

            boolean win = true;

            for (int j = 0; j < size; j++) {

                if (board[i][j].getSymbol() != symbol) {
                    win = false;
                    break;
                }
            }

            if (win)
                return true;
        }

        // Columns
        for (int j = 0; j < size; j++) {

            boolean win = true;

            for (int i = 0; i < size; i++) {

                if (board[i][j].getSymbol() != symbol) {
                    win = false;
                    break;
                }
            }

            if (win)
                return true;
        }

        // Main diagonal

        boolean diagonal = true;

        for (int i = 0; i < size; i++) {

            if (board[i][i].getSymbol() != symbol) {
                diagonal = false;
                break;
            }
        }

        if (diagonal)
            return true;

        // Anti diagonal

        diagonal = true;

        for (int i = 0; i < size; i++) {

            if (board[i][size - i - 1].getSymbol() != symbol) {
                diagonal = false;
                break;
            }
        }

        return diagonal;
    }

    public boolean isFull() {

        for (Cell[] row : board) {

            for (Cell cell : row) {

                if (cell.isEmpty())
                    return false;
            }
        }

        return true;
    }

    public void printBoard() {

        System.out.println();

        for (Cell[] row : board) {

            for (Cell cell : row) {

                Symbol symbol = cell.getSymbol();

                if (symbol == Symbol.EMPTY)
                    System.out.print("- ");

                else
                    System.out.print(symbol + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}