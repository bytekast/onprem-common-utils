package com.rowellbelen.onprem.commons.utils

import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * @author Rowell Belen
 */
class NumberWordsUtilTest {

  def numberUtil

  @Before
  void setup() {
    numberUtil = new NumberWordsUtil()
  }

  @Test
  void testConvertToWords() {
    assertEquals("minus twelve thousand, three hundred forty-five",
        numberUtil.convertToWords(-12345))
    assertEquals("zero", numberUtil.convertToWords(0))
    assertEquals("five", numberUtil.convertToWords(5))
    assertEquals("fifty", numberUtil.convertToWords(50))
    assertEquals("fifty-five", numberUtil.convertToWords(55))
    assertEquals("one hundred", numberUtil.convertToWords(100))
    assertEquals("one hundred twenty-three", numberUtil.convertToWords(123))
    assertEquals("one thousand, two hundred thirty-four", numberUtil.convertToWords(1234))
    assertEquals("twelve thousand, three hundred forty-five", numberUtil.convertToWords(12345))
    assertEquals("one hundred twenty-three thousand, four hundred fifty-six",
        numberUtil.convertToWords(123456))
    assertEquals("one million, two hundred thirty-four thousand, five hundred sixty-seven",
        numberUtil.convertToWords(1234567))
    assertEquals("twelve million, three hundred forty-five thousand, six hundred seventy-eight",
        numberUtil.convertToWords(12345678))
  }
}
