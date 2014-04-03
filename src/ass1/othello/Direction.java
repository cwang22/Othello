package ass1.othello;
import java.awt.Point;


public enum Direction {
  /**
   * x/y -1 0 1 
   * -1  NW N NE
   *  0   W + E
   *  1  SW S SE
   */
  
  W(0,-1),NW(-1,-1),N(-1,0),NE(-1,1),E(0,1),SE(1,1),S(1,0),SW(1,-1);
  
  int x;
  int y;
  Direction(int x, int y){
    this.x = x;
    this.y = y;
  }
  
  public Point next(Point p) {
    return new Point(p.x + this.x, p.y + this.y);
  }
}
