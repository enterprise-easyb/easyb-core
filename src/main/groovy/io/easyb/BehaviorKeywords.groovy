package io.easyb

import io.easyb.delegates.NarrativeDelegate
import io.easyb.listener.BroadcastListener
import io.easyb.listener.ExecutionListener
import io.easyb.listener.ResultsReporter
import io.easyb.listener.ResultsCollector
import io.easyb.util.BehaviorStepType

class BehaviorKeywords {
    ExecutionListener listener
    BehaviorStepStack stepStack

    BehaviorKeywords(ExecutionListener listener) {
        this.listener = listener

      stepStack = new BehaviorStepStack(listener)
    }

    def narrative(description, closure) {
        stepStack.startStep BehaviorStepType.NARRATIVE, description
        listener.describeStep description
        closure.delegate = new NarrativeDelegate(listener, stepStack)
        closure()
        stepStack.stopStep()
    }

    def description(description) {
        stepStack.startStep BehaviorStepType.DESCRIPTION, description
        listener.describeStep(description)
        stepStack.stopStep()
    }
  
    ResultsReporter easybResults() {
        if (listener instanceof BroadcastListener) {
            BroadcastListener broadcaster = (BroadcastListener) listener
            return new ResultsReporter(broadcaster.getResultsCollector().getGenesisStep())
        } else if ( listener instanceof ResultsCollector ) {
          return new ResultsReporter(listener.genesisStep)
        }

        throw new IllegalStateException('No results collector available to provide easyb results')
    }
}