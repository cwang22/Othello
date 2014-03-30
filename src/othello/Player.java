package othello;
import java.awt.Point;
import java.util.Scanner;

public class Player {
  private GirdColor gc;
  public Player(GirdColor gc){
    this.gc = gc;
  }
  
  public Point play(Scanner s) {
    Point p = null;
    
    System.out.println(gc + "'s turn");
    int x = s.nextInt();
    int y = s.nextInt();

    
    p = new Point(x, y);
    return p;
  }
  public GirdColor getGirdColor() {
    return gc;
  }
  public Player oppoent() {
    // TODO Auto-generated method stub
    return null;
  }

}
