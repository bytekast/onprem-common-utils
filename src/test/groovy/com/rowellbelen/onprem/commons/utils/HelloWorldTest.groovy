package com.rowellbelen.onprem.commons.utils

import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals

class HelloWorldTest {

  def subject;

  @Before
  void setup() {
    subject = new HelloWorld();
  }

  @Test
  void testGetMessage() {
    assertEquals("Hello World!", subject.getMessage(false));
    assertEquals("Hello Universe!", subject.getMessage(true));
  }
}
