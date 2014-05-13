package ass3;
import java.util.Timer;
public class OthelloTimer extends Thread{
  CellMatrix cm;
  
  
  public OthelloTimer(CellMatrix cm) {
    this.cm = cm;
  }


  @Override
  public void run() {
    int i = 0;
    while(true){
      System.out.println(i++);
      if(i > 60000) {
        cm.t1.interrupt();
        break;
        
      }
    }
  }
}
