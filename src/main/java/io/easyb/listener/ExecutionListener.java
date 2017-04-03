package io.easyb.listener;

import io.easyb.BehaviorStep;
import io.easyb.domain.Behavior;
import io.easyb.result.Result;
import io.easyb.result.ReportingTag;

public interface ExecutionListener {
    void startBehavior(Behavior behavior);

    void startStep(BehaviorStep step);

    void describeStep(String description);

    void gotResult(Result result);

    void stopStep();

    void stopBehavior(BehaviorStep step, Behavior behavior);

    void tag(ReportingTag tag);

    void completeTesting();
}
