package othello;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Board {
  public static final int ROWS = 8;
  public static final int COLS = 8;

  public HashMap<Point, GirdColor> discs;
  
  public Board() {
    discs = new HashMap<Point, GirdColor>(ROWS * COLS);

    for (int i = 1; i <= 8; i++) {
      for (int j = 1; j <= 8; j++) {
        Point p = new Point(i, j);
        discs.put(p, GirdColor.EMPTY);
      }
    }
    
    discs.put(new Point(4, 4), GirdColor.BLACK);
    discs.put(new Point(4, 5), GirdColor.WHITE);
    discs.put(new Point(5, 4), GirdColor.WHITE);
    discs.put(new Point(5, 5), GirdColor.BLACK);
    
  }
  
  public void print() {
    
//    Set<Point> keys = discs.keySet();
//    for(Iterator<Point> it = keys.iterator();it.hasNext();){
//      discs.get(it.next()).print();
//    }
    System.out.println(" ABCDEFGH");
    for (int i = 1; i <= 8; i++) {
      System.out.print(i);
      for (int j = 1; j <= 8; j++) {
        Point p = new Point(i, j);
        discs.get(p).print();
       
      }
      System.out.println();
    }
  }
  


  public boolean hasPossibleMove(GirdColor gc) {
    Set<Point> keys = discs.keySet();
    for(Iterator<Point> it = keys.iterator();it.hasNext();){
      Point p = it.next();
      if(hasPossibleMove(gc,p)){
        return true;
      }
    }
    return false;
  }
  
  public boolean hasPossibleMove(GirdColor gc, Point p){
    for(Direction d : Direction.values()){
      if(hasPossibleMove(gc, p, d))
        return true;
    }
    return false;
  }
  
  private boolean hasPossibleMove(GirdColor gc, Point p, Direction d){
    p = d.next(p);
    
    GirdColor next = discs.get(p);
    if(next == null || next == GirdColor.EMPTY || next == gc){
      return false;
    }else{
      return find(gc, p, d);
    }
  }

  public boolean find(GirdColor gc, Point p, Direction d) {
    p = d.next(p);
    GirdColor next = discs.get(p);
    if( next == gc ){
      System.out.println(p);
      return true;
    } else if( next == null || next == GirdColor.EMPTY){
      return false;
    }else{
      return find(gc, p, d);
    }
  }



  public void update(Point p, GirdColor gc) {
    discs.put(p, gc);
    turn(p, gc);
    
  }
  
  private void turn(Point p, GirdColor gc) {
    for(Direction d : Direction.values()){
      if(hasPossibleMove(gc, p, d)){
        turn(gc, p, d);
      }  
    }
  }

  private void turn(GirdColor gc, Point p, Direction d) {
    
    while(discs.get(d.next(p)) != gc){
      p = d.next(p);
      discs.put(p, gc);
    }
     
  }

  public static void main(String[] args) {
    Board b = new Board();
    b.print();

    b.discs.put(new Point(5,3), GirdColor.BLACK);
    b.discs.put(new Point(5,4), GirdColor.BLACK);
    b.discs.put(new Point(4,3), GirdColor.WHITE);
    b.discs.put(new Point(4,4), GirdColor.WHITE);
    
    b.update(new Point(3,3), GirdColor.BLACK);
    b.print();

  }
}
