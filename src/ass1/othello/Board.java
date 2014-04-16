package ass1.othello;

import java.awt.Color;
import java.awt.Point;

public class Board {
  public static final int ROWS = 8;
  public static final int COLUMNS = 8;

  private static int BLACK = 2;
  private static int WHITE = 1;
  private static int EMPTY = 0;
  
  private int blackCount = 0;
  private int whiteCount = 0;

  int[][] gameBoard;

  /*
   * constructor
   */
  Board() {
    init();
  }

  public void init() {
    gameBoard = new int[ROWS][COLUMNS];

    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        gameBoard[i][j] = 0;
      }
    }

    gameBoard[3][3] = 2;
    gameBoard[4][4] = 2;
    gameBoard[3][4] = 1;
    gameBoard[4][3] = 1;
    
    blackCount = 2;
    whiteCount = 2;
  }

  // print gameBoard
  public void print() {
    System.out.println(" 12345678");
    for (int i = 0; i < ROWS; i++) {
      System.out.print(i + 1);
      for (int j = 0; j < COLUMNS; j++) {

        if (gameBoard[i][j] == EMPTY)
          System.out.print("-");
        if (gameBoard[i][j] == BLACK)
          System.out.print("x");
        if (gameBoard[i][j] == WHITE)
          System.out.print("o");
      }
      System.out.println();
    }
  }

  /** Game Logic **/

  // check if a player has legal move
  public boolean legalMove(Color c) {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        Point p = new Point(i + 1, j + 1);
        if (legalMove(c, p)) {
          return true;
        }
      }
    }
    return false;
  }

  // check if a point is a legal move
  public boolean legalMove(Color c, Point p) {
    if (gameBoard[p.x - 1][p.y - 1] != 0)
      return false;
    for (Direction d : Direction.values()) {
      if (legalMove(c, p, d)) {
        return true;
      }
    }
    return false;
  }

  // check if a point is a legal move in given direction
  private boolean legalMove(Color c, Point p, Direction d) {
    p = d.next(p);
    try {
      Color next = getColor(gameBoard[p.x - 1][p.y - 1]);
      if (next == null || next == c) {
        return false;
      } else {
        return findLast(c, p, d);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  // util function to find if there is a same color disc in given direction
  private boolean findLast(Color c, Point p, Direction d) {
    p = d.next(p);
    Color next = getColor(gameBoard[p.x - 1][p.y - 1]);
    if (next == c) {
      // System.out.println(p);
      return true;
    } else if (next == null) {
      return false;
    } else {
      return findLast(c, p, d);
    }
  }

  // insert a new Point and update board
  public void boardUpdate(Color c, Point p) {
    gameBoard[p.x - 1][p.y - 1] = getColorInt(c);
    turn(c, p);
  }

  // turn all opponent's disc in all directions
  private void turn(Color c, Point p) {
    for (Direction d : Direction.values()) {
      if (legalMove(c, p, d)) {
        turn(c, p, d);
      }
    }
  }

  // turn all opponent's disc in given direction
  private void turn(Color c, Point p, Direction d) {
    Point nextPoint = d.next(p);

    if (nextPoint.x == 0 || nextPoint.y == 0 || nextPoint.x == 8
        || nextPoint.y == 8) {
      return;
    }
    Color next = getColor(gameBoard[nextPoint.x - 1][nextPoint.y - 1]);
    if (next != c) {
      gameBoard[nextPoint.x - 1][nextPoint.y - 1] = getColorInt(c);
      turn(c, nextPoint, d);
    }
  }

  /** Utils **/

  // util function to convert java.awt.Color to the number stand for the given
  // color
  private int getColorInt(Color c) {
    if (c == Color.BLACK)
      return 2;
    if (c == Color.WHITE)
      return 1;
    return 0;
  }

  // util function to convert number stand for color to java.awt.Color
  private Color getColor(int i) {
    if (i == BLACK)
      return Color.BLACK;
    if (i == WHITE)
      return Color.WHITE;
    return null;
  }

  // count amount of discs in a color
  public int getScore(Color c) {
    int count = 0;
    int colorInt = getColorInt(c);

    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if (gameBoard[i][j] == colorInt)
          count++;
      }
    }
    if(c == Color.BLACK)
      return blackCount = count;
    else
      return whiteCount = count; 
  }

  /**
   * unit tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    Board b = new Board();
    b.turn(Color.BLACK, new Point(5, 3));
    b.print();
    boolean t1 = b.legalMove(Color.BLACK);
    boolean t2 = b.legalMove(Color.BLACK, new Point(5, 3));
    boolean t3 = b.legalMove(Color.BLACK, new Point(1, 4), Direction.E);

    System.out.println(t1);
    System.out.println(t2);
    System.out.println(t3);
  }
}
