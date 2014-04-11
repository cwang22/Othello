package test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import othello.Direction;

public class TestDirection {

  @Test
  public void test() {
    Point p = new Point(3,4);
    assertEquals(new Point(3,3), Direction.W.next(p));
  }

}
