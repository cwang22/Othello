package othello;

import java.awt.Color;
import java.awt.Point;
import java.util.Scanner;

public class Player {
  protected Color myColor;
  private int discNum;

  public Player(Color c) {
    this.myColor = c;
    setDiscNum(0);
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

  public Color getColor() {
    return myColor;
  }

  public int getDiscNum() {
    return discNum;
  }

  public void setDiscNum(int discNum) {
    this.discNum = discNum;
  }
}
