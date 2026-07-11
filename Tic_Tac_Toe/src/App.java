import service.Game;


public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game(3);

        game.start();
    }
}
