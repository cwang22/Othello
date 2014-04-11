package ass1.othello;

import java.awt.Color;
import java.awt.Point;
import java.util.Scanner;

public class WhitePlayer extends Player {

  public static final Color WHITE = Color.WHITE;

  public WhitePlayer() {
    super(WHITE);

  }

  @SuppressWarnings("resource")
  public Point placeDisc() {
    Point p = null;
    Scanner s = new Scanner(System.in);
    System.out.println("White's turn");
    System.out.println("Please input the location of point(x,y)\nx=");
    int x = s.nextInt();
    System.out.println("y=");
    int y = s.nextInt();
    p = new Point(x, y);
    return p;
  }
}
