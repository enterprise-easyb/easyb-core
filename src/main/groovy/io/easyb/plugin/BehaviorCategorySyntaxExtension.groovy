/*
 * Using this extension allows those who wish to, to add BehaviorCategory behavior to when and given
 */
package io.easyb.plugin

import io.easyb.BehaviorCategory;
public class BehaviorCategorySyntaxExtension implements SyntaxExtension {
  def boolean autoLoad() {
    return false 
  }

  def String getName() {
    return "behaviorCategory"
  }

  def Map<String, Closure> getSyntax() {
    return [:]
  }

  def Class[] getExtensionCategories() {
    return [BehaviorCategory.class]
  }
}