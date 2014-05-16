package othello;

public enum Cell implements Cloneable {
  BLACK("x"), WHITE("o"), EMPTY("-");

  String s;

  Cell(String s) {
    this.s = s;
  }

  public String print() {
    return s;
  }

}
