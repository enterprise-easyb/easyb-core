package io.easyb.bdd.prototype

import io.easyb.BehaviorCategory

public class ExtendedCategories {  
  static void betterBe(Object self, value) {
    BehaviorCategory.shouldBe(self, value)
  }
}