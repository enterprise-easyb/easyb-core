package io.easyb

import io.easyb.listener.ExecutionListenerAdaptor
import io.easyb.result.Result

class FakeListener extends ExecutionListenerAdaptor {
    Result result

    void startStep(BehaviorStep step) {

    }

    void gotResult(Result result) {
        this.result = result
    }

    void stopStep() {

    }
}