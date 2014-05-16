package othello;

public class Timer {
  static Timer t;

  static final int LIMIT = 60;
  long start;

  private Timer() {
  }

  public static Timer getTimer() {
    if (t == null) {
      t = new Timer();
    }
    return t;
  }

  //save current system timer
  public void start() {
    start = System.currentTimeMillis();
  }

  public long getStartTime() {
    return start;
  }
  
  //compare with saved start time.
  public boolean isTimeOut() {
    long current = System.currentTimeMillis();
    return (current - start) > (LIMIT * 1000);
  }
}
