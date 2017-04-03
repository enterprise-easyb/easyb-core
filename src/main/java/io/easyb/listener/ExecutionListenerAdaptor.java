package io.easyb.listener;

import io.easyb.domain.Behavior;
import io.easyb.BehaviorStep;
import io.easyb.result.ReportingTag;
import io.easyb.result.Result;

public class ExecutionListenerAdaptor implements ExecutionListener {
    public void startBehavior(Behavior behavior) {
    }

    public void stopBehavior(BehaviorStep step, Behavior behavior) {
    }

    public void tag(ReportingTag tag) {    
    }

    public void startStep(BehaviorStep step) {
    }

    public void describeStep(String description) {
    }

    public void stopStep() {
    }

    public void gotResult(Result result) {
    }

    public void completeTesting() {
    }
}
