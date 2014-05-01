package ass3;

import java.awt.Image;

/**
 *
 * @author wang w
 */
public class Othello {

    private GameState game;
    private Controller con;
   



    public static void main(String[] args) {
        new Othello().getStarted();
        new Othello().displayScore();

    }

    public Othello() {
        
        game = new GameState();
        con = new Controller();
    }
    
   

    public void getStarted() {
        new GameState().newGame();
    }


    public void displayScore() {
        System.out.println(con.finalResult(game.player1.name, game.player2.name));
    }


}
