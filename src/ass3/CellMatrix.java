package ass3;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class CellMatrix {

  public static int ROWS = 8;
  public static int COLS = 8;
  Cell[][] cells;
  Player blackPlayer;
  Player whitePlayer;
  Player current;
  
  int step;
  ArrayList<History> history;

  Point nextPoint = null;

  public CellMatrix() {
    cells = new Cell[8][8];
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        cells[i][j] = Cell.EMPTY;
      }
    }
    cells[3][3] = Cell.BLACK;
    cells[4][4] = Cell.BLACK;
    cells[3][4] = Cell.WHITE;
    cells[4][3] = Cell.WHITE;
    blackPlayer = new Player(Cell.BLACK, "Player1");
    whitePlayer = new Player(Cell.WHITE, "Player2");
    current = blackPlayer;
    history = new ArrayList<History>();
    step = 0;
    save();
  }

  public void start() {
    boolean isFinished = false;

    while (!isFinished) {
      print();

      String input = current.input();
      System.out.println(input);
      Point p = null;
      if(input == "point")
        p = current.getNext();
      if(input == "timeout")
        current = getOpponent();
      if(input == "undo")
        undo();
      if(input == "redo")
        redo();
      

      
      if (p != null) {

        if (!legalMove(current.getCell(), p)) {
          System.out.println("Invalid input");
          continue;
        }
        boardUpdate(current.getCell(), p);
        Player oppoent = getOpponent();


        
        if (legalMove(oppoent.getCell())) {// if opponent has move
          current = oppoent;
          step++;
          save();
        } else if (!legalMove(current.getCell())) {// if current has move
          isFinished = true;
        }
      }
    }
  }
  
  public void save() {
    Cell[][] save = new Cell[ROWS][COLS];
    for(int i = 0; i < ROWS; i++) {
      for(int j = 0; j < COLS; j++) {
        save[i][j] = cells[i][j];
      }
    }
    History h = new History(save,current);
    if(step == history.size())
      history.add(h);
    else
      history.set(step, h);
  }
  
  public void undo() {    
    if(step>0){
      History h = history.get(--step);
      cells = h.getCells();
      current = h.getCurrent();
    }
  }
  
  public void redo() {
    System.out.print(step);
    if(step < history.size() - 1){
      History h = history.get(++step);
      cells = h.getCells();
      current = h.getCurrent();
    }
  }

  private Player getOpponent() {
    return current == blackPlayer ? whitePlayer : blackPlayer;
  }

  public void print() {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if (cells[i][j] == Cell.BLACK) {
          System.out.print("X ");
        } else if (cells[i][j] == Cell.WHITE) {
          System.out.print("O ");
        } else {
          System.out.print("- ");
        }
      }
      System.out.println();
    }
  }

  /** Game Logic **/

  // check if a player has legal move
  public boolean legalMove(Cell c) {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        Point p = new Point(i + 1, j + 1);
        if (legalMove(c, p)) {
          return true;
        }
      }
    }
    return false;
  }

  // check if a point is a legal move
  public boolean legalMove(Cell c, Point p) {
    if (p.x < 1 || p.x > 8 || p.y < 1 || p.y > 8)
      return false;
    if (cells[p.x - 1][p.y - 1] != Cell.EMPTY)
      return false;
    for (Direction d : Direction.values()) {
      if (legalMove(c, p, d)) {
        return true;
      }
    }
    return false;
  }

  // check if a point is a legal move in given direction
  private boolean legalMove(Cell c, Point p, Direction d) {
    p = d.next(p);
    try {
      Cell next = cells[p.x - 1][p.y - 1];
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
  private boolean findLast(Cell c, Point p, Direction d) {
    p = d.next(p);
    Cell next = cells[p.x - 1][p.y - 1];
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
  public void boardUpdate(Cell c, Point p) {
    cells[p.x - 1][p.y - 1] = c;
    turn(c, p);
  }

  // turn all opponent's disc in all directions
  private void turn(Cell c, Point p) {
    for (Direction d : Direction.values()) {
      if (legalMove(c, p, d)) {
        turn(c, p, d);
      }
    }
  }

  // turn all opponent's disc in given direction
  private void turn(Cell c, Point p, Direction d) {
    Point nextPoint = d.next(p);

    if (nextPoint.x == 0 || nextPoint.y == 0 || nextPoint.x == 8
        || nextPoint.y == 8) {
      return;
    }
    Cell next = cells[nextPoint.x - 1][nextPoint.y - 1];
    if (next != c) {
      cells[nextPoint.x - 1][nextPoint.y - 1] = c;
      turn(c, nextPoint, d);
    }
  }

  public Point getLegalMove(Cell c) {
    Point p = null;
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        p = new Point(i + 1, j + 1);
        if (legalMove(c, p)) {
          return p;
        }
      }
    }
    return p;
  }

  public Player getCurrent() {
    return current;
  }

}
