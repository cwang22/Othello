package othello;
import java.awt.Point;
import java.util.Scanner;

public class ConsoleOthello {
  Player p1;
  Player p2;
  Player current;
  boolean isFinish;
  Board b;
  private boolean isFinished;
  
  
  public ConsoleOthello() {
    p1 = new Player(GirdColor.BLACK);
    p2 = new Player(GirdColor.WHITE);
    current = p1;
    isFinish = false;
    b = new Board();
  }

  public void start(){
    
    Scanner s = new Scanner(System.in);
    while(!isFinished){
      b.print();
      
      Point p = current.play(s);

      if(!b.hasPossibleMove(current.getGirdColor(),p)){
        System.out.println("Invalid input");
        continue;
      }
      b.update(p,current.getGirdColor());
      b.print();
      Player op = oppoent(current);
      if(b.hasPossibleMove(op.getGirdColor())){
        current = op;
      }else if(!b.hasPossibleMove(current.getGirdColor())){
        isFinished = true;
      }
    }
    s.close();
    
  }

  private Player oppoent(Player current) {
    return current == p1 ? p2 : p1;
  }

  public static void main(String[] args){
    new ConsoleOthello().start();
  }
}
