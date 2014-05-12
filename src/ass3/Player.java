

package ass3;

import java.awt.Color;
import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author wang w
 */
public class Player {
    Cell c;
    String name;

        Player(Cell c, String name) {
            this.c = c;
            this.name = name;
        }

        public Point placeDisc() {
          Point p = null;
          Scanner s = new Scanner(System.in);
          if (c == Cell.BLACK)
            System.out.println("Black's turn");
          else
            System.out.println("White 's turn");
          System.out.println("Please input the location of point(x,y)\nx=");
          int x = s.nextInt();
          System.out.println("y=");
          int y = s.nextInt();

          p = new Point(x, y);
          return p;
        }

        public Cell getCell() {
          return c;
        }
 
}
