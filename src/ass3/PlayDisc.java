package ass3;

import java.awt.Point;
import java.util.Scanner;

public class PlayDisc extends Thread{
  private CellMatrix cm;
  
  public PlayDisc(CellMatrix cm) {
    this.cm = cm;
  }
  
  @Override
  public void run() {
    System.out.println("pd.Running");
    Scanner s = new Scanner(System.in);

    if (cm.getCurrent().getCell() == Cell.BLACK)
      System.out.println("Black's turn");
    else
      System.out.println("White 's turn");
    System.out.println("Please input the location of point(x,y)\nx=");
    try {
      while(!s.hasNextInt()){
        
        Thread.sleep(100);
      }
      
      
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    int x = s.nextInt();
    System.out.println("y=");
    int y = s.nextInt();

    Point p = new Point(x, y);
    cm.nextPoint = p;
    s.close();
  }
  

}
