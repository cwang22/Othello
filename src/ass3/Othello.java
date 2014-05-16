package ass3;

public class Othello {

  private CellMatrix cm;

  public static void main(String[] args) {
    new Othello();
  }

  public Othello() {
    cm = new CellMatrix();
    cm.start();
  }
}
