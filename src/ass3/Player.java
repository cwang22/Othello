package ass3;

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author wang w
 */
public class Player {
  Cell c;
  String name;

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
          return new Point(1,1);
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

}
