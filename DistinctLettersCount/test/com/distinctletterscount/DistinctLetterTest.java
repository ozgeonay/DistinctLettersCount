package com.distinctletterscount;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class DistinctLetterTest {

  @Test
  public void testProcess() {

    assertEquals(Arrays.asList(1, 6, 0, 4), DistinctLetter.process(Arrays.asList(
        "aaaabbbb",
        "ccaaffddecee",
        "eeee",
        "example")));
  }
}
