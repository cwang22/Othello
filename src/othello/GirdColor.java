package othello;

public enum GirdColor {
  EMPTY("-"),BLACK("x"),WHITE("o");
  
  private String s;
  
  GirdColor(String s){
    this.s = s;
  }

  public void print() {
    System.out.print(s);
  }

  public GirdColor oppoent() {
    return this == BLACK ? WHITE : BLACK;
  }
}
