package ass1.othello;
import java.awt.Color;
import java.awt.Point;
import java.util.Scanner;

public class Player {
  private Color myColor;
  private int discNum;
  
  public Player(Color myColor) {
    this.myColor = myColor;
    setDiscNum(0);
  }
  
  @SuppressWarnings("resource")
  public Point placeDisc(){
    Point p = null;
    Scanner s = new Scanner(System.in);
    if(myColor == Color.BLACK)
    System.out.println("BLACK 's turn");
    else
      System.out.println("WHITE 's turn");
    int x = s.nextInt();
    int y = s.nextInt();

    p = new Point(x, y);
    return p;
  }
  
  public void oppoendRespond() {
    
  }
  
  public void chooseColor(){
    
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
