package othello;

import java.awt.Color;
import java.awt.Point;
import java.util.Scanner;

public class HumanPlayer extends Player{

  public HumanPlayer(Color c) {
    super(c);
  }
  
  @SuppressWarnings("resource")
  public Point placeDisc() {
    Point p = null;
    Scanner s = new Scanner(System.in);
    if (myColor == Color.BLACK)
      System.out.println("Black's turn");
    else
      System.out.println("White 's turn");
    System.out.println("Please input the location of point(x,y)\nx=");
    int x = s.nextInt();
    System.out.println("y=");
    int y = s.nextInt();

    p = new Point(x, y);
    return p;
  }
  
}
