package othello;

import java.awt.Color;
import java.awt.Point;

public class AIPlayer extends Player{
  Board b;

  public AIPlayer(Color c, Board b) {
    super(c);
    this.b = b;
  }

  @Override
  public Point placeDisc() {
    
    Point p = b.getLegalMove(myColor);
    System.out.println("AI respond: (" + p.x + ", " + p.y +")");
    return p;
  }

}
