package othello;

import java.awt.Color;
import java.awt.Point;
import java.util.Scanner;

public class Game {

  Player blackPlayer;
  Player whitePlayer;
  Board board;

  public Game() {
    board = new Board();
    blackPlayer = new HumanPlayer(Color.BLACK);
    
    Scanner s = new Scanner(System.in);
    System.out.println("Select Game mode:\n1. Player Vs Player\n2. Player Vs Computer");
    int choice = s.nextInt();
    if(choice == 2){
      System.out.println("-----Player Vs Player------");
      whitePlayer = new AIPlayer(Color.WHITE, board);
    }
    else if(choice == 1) {
      System.out.println("-----Player Vs Computer------");
      whitePlayer = new HumanPlayer(Color.WHITE);
    }
    else {
      System.out.println("invalid input.");
      System.exit(-1);
    }
    
    board.print();
  }

  public static void main(String[] args) {
    new Game().start();
  }

  public void start() {
    Player current = blackPlayer;

    boolean isFinished = false;
    while (!isFinished) {
      Point p = current.placeDisc();

      // check input
      if (!board.legalMove(current.getColor(), p)) {
        System.out.println("Invalid input");
        continue;
      }

      board.boardUpdate(current.getColor(), p);
      board.print();
      Player oppoent = getOpponent(current);
      if (board.legalMove(oppoent.getColor())) {// if opponent has move
        current = oppoent;
      } else if (!board.legalMove(current.getColor())) {// if current has move
        isFinished = true;
      }
    }

    // get Winner
    blackPlayer.setDiscNum(board.getScore(Color.BLACK));
    whitePlayer.setDiscNum(board.getScore(Color.WHITE));

    if (blackPlayer.getDiscNum() > whitePlayer.getDiscNum()) {
      System.out.println("BLACK WIN");
    } else {
      System.out.println("WHITE WIN");
    }

  }

  private Player getOpponent(Player current) {
    return current == blackPlayer ? whitePlayer : blackPlayer;
  }
}
