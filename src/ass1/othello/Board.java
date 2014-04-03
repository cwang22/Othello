package ass1.othello;

import java.awt.Color;
import java.awt.Point;

import othello.Direction;
import othello.GirdColor;


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
  
  public void boardUpdate(Color c, Point p){
    gameBoard[p.x-1][p.y-1] = getColorInt(c);
    turn(c,p);
  }
  
  private void turn (Color c, Point p) {
    for (Direction d : Direction.values()) {
      if (legalMove(c, p, d)) {
        turn(c, p, d);
      }
    }
  }

  private void turn (Color c, Point p, Direction d) {
    Point nextPoint = d.next(p);

      if(nextPoint.x == 0 || nextPoint.y == 0 || nextPoint.x == 8 || nextPoint.y == 8) {
        return;
      }
    Color next = getColor(gameBoard[nextPoint.x-1][nextPoint.y-1]);
      if (next != c) {
        gameBoard[nextPoint.x-1][nextPoint.y-1] = getColorInt(c);
        turn(c,nextPoint,d);
      }

  }
  
  private Color getOpponent (Color c) {
    return c == Color.BLACK ? Color.WHITE : Color.BLACK;
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
  
  
 
  
  public void init(){
    
  }
  
  private int getColorInt(Color c){
    if(c == Color.BLACK)
      return 2;
    if(c == Color.WHITE)
      return 1;
    return 0;
  }
  
  private Color getColor(int i){
    if(i == BLACK)
      return Color.BLACK;
    if(i == WHITE)
      return Color.WHITE;
    return null;
  }

  public boolean legalMove(Color c) {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        Point p = new Point(i+1,j+1);
        if (legalMove(c, p)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean legalMove(Color c, Point p) {
    for(Direction d : Direction.values()){
      if(legalMove(c, p, d)){
        return true;
      }
    }
    return false;
  }

  private boolean legalMove (Color c, Point p, Direction d) {
    p = d.next(p);
    try{
    Color next = getColor(gameBoard[p.x - 1][p.y -1]);
    if (next == null || next == c) {
      return false;
    } else {
      return find(c, p, d);
    }
    }catch(ArrayIndexOutOfBoundsException e){
      return false;
    }
  }



  private boolean find (Color c, Point p, Direction d) {
    p = d.next(p);
    Color next = getColor(gameBoard[p.x - 1][p.y -1]);
    if (next == c) {
      //System.out.println(p);
      return true;
    } else if (next == null) {
      return false;
    } else {
      return find(c, p, d);
    }
  }

  public int count(Color c) {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if(gameBoard[i][j] == EMPTY)
          System.out.print("-");
        if(gameBoard[i][j] == BLACK)
          System.out.print("x");
        if(gameBoard[i][j] == WHITE)
          System.out.print("o");
      }
    
  }
    return 0;
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    Board b = new Board();
    b.turn(Color.BLACK, new Point(5,3));
    b.print();
    boolean t1 = b.legalMove(Color.BLACK);
    boolean t2 = b.legalMove(Color.BLACK, new Point(5,3));
    boolean t3 = b.legalMove(Color.BLACK, new Point(1,4), Direction.E);
    
    System.out.println(t1);
    System.out.println(t2);
    System.out.println(t3);
  }
}
