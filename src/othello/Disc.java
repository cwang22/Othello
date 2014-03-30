package othello;
public class Disc {
  private boolean isBlack;
  
  public Disc(boolean isBlack) {
    this.isBlack = isBlack;
  }
  
  public boolean isBlack(){
    return isBlack;
  }
  
  public void turn() {
    isBlack = !isBlack;
  }
 
}
