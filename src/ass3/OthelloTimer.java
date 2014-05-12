package ass3;
import java.util.Timer;
public class OthelloTimer extends Timer{
  static OthelloTimer ot;
  
  public static OthelloTimer getTimer() {
    if(ot != null)
      ot = new OthelloTimer();
    return ot;
  }
  
  private OthelloTimer(){
    super();
  }
}
