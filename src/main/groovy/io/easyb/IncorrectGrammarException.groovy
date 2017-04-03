/*
  * thrown when the easyb parser encounters grammar in a location it should not be
 */
package io.easyb;


public class IncorrectGrammarException extends RuntimeException {
  public IncorrectGrammarException(String msg) {
    super(msg)
  }
}