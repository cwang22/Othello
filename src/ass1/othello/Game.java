package ass1.othello;

import java.awt.Color;
import java.awt.Point;

public class Game {
  
  Player blackPlayer;
  Player whitePlayer;
  Board board;


  public Game(){
    blackPlayer = new Player(Color.BLACK);
    whitePlayer = new Player(Color.WHITE);
    board = new Board();
    board.print();
  }
  public static void main(String[] args) {
    new Game().start();
  }
  
  public void start(){
    Player current = blackPlayer;
    
    boolean isFinished = false;
    while(!isFinished){
      Point p = current.placeDisc();
      
      //check input
      if (!board.legalMove(current.getColor(), p)) {
        System.out.println("Invalid input");
        continue;
      }
      
      
      board.boardUpdate(current.getColor(), p);
      board.print();
      Player oppoent = getOppoent(current);
      if (board.legalMove(oppoent.getColor())){//if opponent has move
        current = oppoent;
      } else if (!board.legalMove(current.getColor())) {// if current has move
        isFinished = true;
      }
    }
    
    //get Winner
    blackPlayer.setDiscNum(board.count(Color.BLACK));
    whitePlayer.setDiscNum(board.count(Color.WHITE));
    
    if(blackPlayer.getDiscNum() > whitePlayer.getDiscNum()){
      System.out.println("BLACK WIN");
    }else{
      System.out.println("WHITE WIN");
    }
    
  }
  private Player getOppoent(Player current) {
    return current == blackPlayer ? whitePlayer : blackPlayer;
  }
}
