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
  
  public Cell getCell() {
    return c;
  }

  @SuppressWarnings("resource")
  public String input() {
    System.out.println(c.toString() + "'s turn");
    System.out.println("input Point[x y](use space in between)");
    System.out.println("input [U number](use space in between) to undo");
    System.out.println("input [R number](use space in between) to redo");
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
          return "-1";
        else if (str.equalsIgnoreCase("r"))
          return "1";
        else if (str.matches("[Uu]\\s\\d+"))
          return "-" + str.substring(2);
        else if (str.matches("[Rr]\\s\\d+"))
          return str.substring(2);
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
