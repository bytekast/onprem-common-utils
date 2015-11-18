package com.rowellbelen.onprem.commons.utils;

/**
 * @author Rowell Belen
 */
public class NumberWordsUtil {

  private static String[] zeroToNineteen = ['zero', 'one', 'two', 'three', 'four', 'five',
                                            'six', 'seven', 'eight', 'nine', 'ten', 'eleven',
                                            'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen',
                                            'seventeen', 'eighteen', 'nineteen']

  private static String[] tens = ['twenty', 'thirty', 'forty', 'fifty', 'sixty',
                                  'seventy', 'eighty', 'ninety']

  private static String[] highNumbers = ['', 'thousand', 'million', 'billion', 'trillion',
                                         'quadrillion', 'quintillion', 'sextillion', 'septillion',
                                         'octillion', 'nonillion', 'decillion', 'undecillion',
                                         'duodecillion', 'tredecillion', 'quattuordecillion',
                                         'sexdecillion', 'septendecillion', 'octodecillion',
                                         'novemdecillion', 'vigintillion']

  public String convertToWords(int val) {
    return convertNumberToWords(val.toLong())
  }

  /**
   * Handle values less than 100
   * @param val
   * @return word
   */
  private String convertTens(int val) {

    if (val < 20) {
      return zeroToNineteen[val]
    }

    def leftWord = tens[(int) (val / 10) - 2]
    if (val % 10 == 0) {
      return leftWord
    }

    return leftWord + "-" + zeroToNineteen[val % 10]
  }

  /**
   * Handle values less than 1000
   * @param val
   * @return word
   */
  private String convertHundreds(int val) {

    def rightWord = convertTens(val % 100)
    if (val <= 99) {
      return rightWord
    }

    def leftWord = zeroToNineteen[val / 100] + " hundred"
    if (val % 100 == 0) {
      return leftWord
    } else {
      return leftWord + " " + rightWord
    }
  }

  /**
   * Convert integers into words
   * @param val Integer value
   * @return word
   */
  private String convertNumberToWords(long val) {

    if (val < 0) {
      return "minus " + convertNumberToWords(-val) // handle negative values
    }

    if (val < 100) {
      return convertTens(val.toInteger())
    }

    if (val < 1000) {
      return convertHundreds(val.toInteger())
    }

    // groovy magic - break down in groups of 3 digits into a reversed list
    def groups = (((val + '') as List)
        .reverse().collate(3))
        .reverse().collect { it.reverse() }

    def index = 0
    def word = ''
    groups.reverseEach { it ->
      def currentVal = it.join('').toInteger()
      def subWord = convertHundreds(currentVal.toInteger()) + " " + highNumbers[index++]
      if (word == '') {
        if (currentVal > 0) {
          word = subWord
        }
      } else {
        word = subWord + ', ' + word
      }
    }

    return word.trim()
  }
}
