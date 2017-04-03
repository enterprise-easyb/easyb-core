package io.easyb.plugin

import io.easyb.bdd.prototype.ExtendedCategories

class BetterBePlugin extends BasePlugin {

  public String getName() {
    return "BetterBe";
  }

  public Object beforeStory(Binding binding) {
    Object.mixin ExtendedCategories
  }

}