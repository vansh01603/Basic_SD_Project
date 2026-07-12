package model;

public class Cell {

    private final int number;
    private Snake snake;
    private Ladder ladder;

    public Cell(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public boolean hasSnake() {
        return snake != null;
    }

    public boolean hasLadder() {
        return ladder != null;
    }
}