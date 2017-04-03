import io.easyb.domain.BehaviorFactory
import io.easyb.listener.ResultsCollector
import io.easyb.listener.BroadcastListener
import io.easyb.report.TxtStoryReportWriter
import io.easyb.listener.ResultsAmalgamator

def testSourceDir = System.getProperty("easyb.test.source.dir")
def reportsDir = System.getProperty("easyb.reports.dir")

before_each "initialize the collectors", {
  and
  given "the collectors are initialized", {
   // broadcastListener = new BroadcastListener();
  //  resultsCollector = new ResultsCollector();
//    broadcastListener.registerListener(resultsCollector);
  }
}

scenario "nested scenarios", {
  given "a story file with nested scenarios", {
    storyBehavior = BehaviorFactory.createBehavior(new File("${testSourceDir}/groovy/io/easyb/bdd/reporting/txt/NestedScenarios.story"))
  }

  when "the specification is executed", {
    storyBehavior.execute()
  }

  and
  when "the reports are written", {
    txtReportLocation = "${reportsDir}/NestedScenarios-report.txt"
    new TxtStoryReportWriter(txtReportLocation).writeReport(new ResultsAmalgamator(storyBehavior))
  }
  
  then "the resulting txt should include 2 scenarios", {
    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(txtReportLocation))))
    int scenariosCount = 0
    
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      if (line.matches(".*(parent|child).*")) {
        scenariosCount ++
      }
    }
    
    scenariosCount.shouldBe 2
  }
}