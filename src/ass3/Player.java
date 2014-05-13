package ass3;

import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author wang w
 */
public class Player {
  Cell c;
  String name;
  Point next;

  Player(Cell c, String name) {
    this.c = c;
    this.name = name;
  }

  public Point placeDisc() {
    Point p = null;
    if (c == Cell.BLACK)
      System.out.println("Black's turn");
    else
      System.out.println("White 's turn");
    System.out.println("Please input the location of point(x,y)\nx=");
    Scanner s = new Scanner(System.in);
    long start = System.currentTimeMillis();
    try {
      while (System.in.available() == 0) {
        if (System.currentTimeMillis() - start > 10000) {
          System.out.println(System.currentTimeMillis());
          return null;
        }
      }
      int x = s.nextInt();
      System.out.println("y=");
      int y = s.nextInt();

      p = new Point(x, y);

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return p;
  }

  public Cell getCell() {
    return c;
  }

  public String input() {
    System.out.println(c.toString() + "'s turn");
    System.out.println("input Point[x y](use space in between), press U to undo, press R to redo");
    Scanner s = new Scanner(System.in);
    Timer t = Timer.getTimer();
    t.start();
    try {
      while (System.in.available() == 0) {
        if (t.isTimeOut()) {
          System.out.println("---Time Out---");
          return "timeout";
        }
      }
      
      String str = s.nextLine();
      System.out.println(str);
      if (str.matches("\\d\\s\\d")) {
        String[] sp = str.split("\\s");
        int x = Integer.parseInt(sp[0]);
        int y = Integer.parseInt(sp[1]);
        next = new Point(x, y);
        return "point";
      } else {
        if (str.equalsIgnoreCase("u"))
          return "undo";
        else if (str.equalsIgnoreCase("r"))
          return "redo";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return "invalid";
  }

  public Point getNext() {
    return next;
  }
  

}
