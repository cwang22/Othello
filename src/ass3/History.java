package ass3;

public class History {
  private Cell[][] cells;
  private Player current;
  
  public History(Cell[][] cells, Player current) {
    super();
    this.cells = cells;
    this.current = current;
  }

  public Cell[][] getCells() {
    return cells;
  }

  public Player getCurrent() {
    return current;
  }  
}
