import io.easyb.delegates.RichEnsureProxyDelegate
import io.easyb.delegates.EnsuringDelegate
import io.easyb.bdd.prototype.EnhancedEnsure
import io.easyb.exception.VerificationException

EnsuringDelegate.metaClass.ensure = { final Object value, final Closure closure ->
  closure.delegate = new EnhancedEnsure(verify:value)
  closure.call()
}

//RichEnsureProxyDelegate.mixin EnhancedEnsure

//RichEnsureProxyDelegate.metaClass.invokeMethod = {meth, params ->
//  println "testing?!"
//  //super.invokeMethod(meth, params)
//}



scenario "the ensure syntax should be extensible", {
  given "a postive value", {
    var = 45
  }
  then "one should be able to ensure something non-easyb implemented", {
    ensure(var) {
      isPositive
    }
  }
}

scenario "the ensure syntax should be extensible and actually throw errors", {
  given "some negative value", {
    var = (-45)
  }
  then "one should be able to ensure something non-easyb implemented", {
    try{
      ensure(var) {
        isPositive
      }
    }catch(e){
       e.shouldBeA VerificationException
    }
  }
}