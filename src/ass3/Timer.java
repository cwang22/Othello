package ass3;

public class Timer{
  static Timer t;
  
  static final int LIMIT = 10;
  long start;
  private Timer() {
  }
  
  public static Timer getTimer() {
    if(t == null) {
      t = new Timer();
    }
    return t;
  }
  
  public void start() {
    start = System.currentTimeMillis();
  }
  
  public boolean isTimeOut() {
    long current = System.currentTimeMillis();
    return (current - start) > (LIMIT * 1000); 
  }
}
