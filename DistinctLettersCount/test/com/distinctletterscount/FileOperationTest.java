package com.distinctletterscount;

import org.junit.Test;

public class FileOperationTest {

  @Test(expected = ConstraintException.class)
  public void testValidation_Exception_1() {
    FileOperation.validateLine("");
  }

  @Test(expected = ConstraintException.class)
  public void testValidation_Exception_2() {
    String s = String.format("%0" + 30001 + "d", 0).replace('0', 'a');
    FileOperation.validateLine(s);
  }

  @Test(expected = ConstraintException.class)
  public void testValidation_Exception_3() {
    FileOperation.validateLine("AASD");
  }

}
