package ass1.othello;

import java.awt.Color;
import java.awt.Point;


public class Board {
  public static final int ROWS = 8;
  public static final int COLS = 8;

  private static int BLACK = 2;
  private static int WHITE = 1;
  private static int EMPTY = 0;
  
  private int blackCount;
  private int whiteCount;
  
  int[][] gameBoard;
  
  Board(){
    gameBoard = new int[ROWS][COLS];
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        gameBoard[i][j] = 0;
      }
    }

    gameBoard[3][3] = 2;
    gameBoard[4][4] = 2;
    gameBoard[3][4] = 1;
    gameBoard[4][3] = 1;
  }
  
  
  
  public void boardUpdate(Point p, Color c){
    gameBoard[p.x-1][p.y-1] = getColorInt(c);
  }
  
  void print(){
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if(gameBoard[i][j] == EMPTY)
          System.out.print("-");
        if(gameBoard[i][j] == BLACK)
          System.out.print("x");
        if(gameBoard[i][j] == WHITE)
          System.out.print("o");
      }
      System.out.println();
    }
  }
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    new Board().print();

  }
  
  public void init(){
    
  }
  
  private int getColorInt(Color c){
    if(c == Color.BLACK)
      return 2;
    if(c == Color.WHITE)
      return 1;
    return 0;
  }



  public boolean legalMove(Point p, Color c) {
    // TODO Auto-generated method stub
    return false;
  }



  public boolean haslegalMove(Color color) {
    // TODO Auto-generated method stub
    return false;
  }



  public int count(Color c) {
    // TODO Auto-generated method stub
    return 0;
  }
  
  

}
