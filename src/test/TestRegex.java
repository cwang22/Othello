package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRegex {

  @Test
  public void test() {
    String s1 = "5 3";
    String s2 = "12312 123123";
    String regex = "\\d\\s\\d";
    assertTrue(s1.matches(regex));
    assertFalse(s2.matches(regex));
  }

}
