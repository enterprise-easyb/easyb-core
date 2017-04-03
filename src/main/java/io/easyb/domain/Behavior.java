package io.easyb.domain;


import groovy.lang.Binding;
import io.easyb.BehaviorStep;
import io.easyb.listener.BroadcastListener;

import java.io.File;
import java.io.IOException;

public interface Behavior {
  String getPhrase();

  File getFile();

  String getTypeDescriptor();

  Binding getBinding();

  BroadcastListener getBroadcastListener();

  BehaviorStep execute() throws IOException;
}
