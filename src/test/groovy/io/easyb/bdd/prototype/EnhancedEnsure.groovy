package io.easyb.bdd.prototype

import io.easyb.exception.VerificationException

class EnhancedEnsure {

  def verify

  void isPositive() {
    if(verify < 0){
      throw new VerificationException("value of ${verify} wasn't postitive")
    }
  }

  def getProperty(String property) {
    if(property == "isPositive"){
      isPositive()
    }
  }
}