package model;

public class Board {

    private final Cell[] cells;
    private final int size;

    public Board(int size) {

        this.size = size;
        cells = new Cell[size + 1];

        for (int i = 1; i <= size; i++) {
            cells[i] = new Cell(i);
        }
    }

    public void addSnake(Snake snake) {

        cells[snake.getHead()].setSnake(snake);
    }

    public void addLadder(Ladder ladder) {

        cells[ladder.getStart()].setLadder(ladder);
    }

    public int getFinalPosition(int position) {

        Cell cell = cells[position];

        if (cell.hasSnake()) {

            System.out.println("Oops! Bitten by Snake 🐍");

            return cell.getSnake().getTail();
        }

        if (cell.hasLadder()) {

            System.out.println("Great! Climbed a Ladder 🪜");

            return cell.getLadder().getEnd();
        }

        return position;
    }

    public int getSize() {
        return size;
    }
}