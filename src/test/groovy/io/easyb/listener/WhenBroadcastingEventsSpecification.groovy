package io.easyb.listener
/*import FailureDetector*/
import io.easyb.result.Result
import io.easyb.listener.*

class Listener1 extends ExecutionListenerAdaptor {
  private Result result
  
  public void gotResult(Result result) {
    this.result = result
  }
  
  public boolean failuresDetected() {
    return result?.failed() 
  }
}

class Listener2 extends Listener1 {}



it "should notify all listeners of events", {
    try {
        ListenerFactory.registerBuilder(new ListenerBuilder() {public ExecutionListener get() {return new Listener1()}});
        ListenerFactory.registerBuilder(new ListenerBuilder() {public ExecutionListener get() {return new Listener2()}});
        BroadcastListener listener = new BroadcastListener()
        listener.gotResult(new Result(Result.FAILED))
        listener.getTypedListener(Listener1.class).failuresDetected().shouldBe(true)
        listener.getTypedListener(Listener2.class).failuresDetected().shouldBe(true)
    } catch (Throwable e) {
        e.printStackTrace()
    }

}
