package ass3;

public class AIPlayer extends Player {
  CellMatrix cm;

  AIPlayer(Cell c, String name, CellMatrix cm) {
    super(c, name);
    this.cm = cm;
  }

  @Override
  public String input() {

    next = cm.getLegalMove(c);
    System.out.println("AI respond: (" + next.x + ", " + next.y + ")");

    return "point";
  }

}
