package org.disco.easyb.report

import org.disco.easyb.result.Result
import org.disco.easyb.util.BehaviorStepType

class TxtStoryReportWriter implements ReportWriter {

  def easybXmlLocation
  def writer

  TxtStoryReportWriter(outputReport, easybXmlLocation) {
    this.easybXmlLocation = easybXmlLocation
    writer = new BufferedWriter(new FileWriter(new File(outputReport.location)))
  }

  void writeReport() {

    def easybXml = new XmlSlurper().parse(new File(easybXmlLocation))

    def count = easybXml.stories.@scenarios.toInteger()
    writer.writeLine("${(count > 1) ? "${count} scenarios" : " 1 scenario"}" + " (including ${easybXml.stories.@pendingscenarios.toInteger()} pending) executed" +
            "${easybXml.stories.@failedscenarios.toInteger() > 0 ? ", but status is failure!" : " successfully"}" +
            "${easybXml.stories.@failedscenarios.toInteger() > 0 ? " Total failures: ${easybXml.stories.@failedscenarios}" : ""}")

    handleElement(easybXml.stories)
    writer.close()
  }

  def handleElement(element) {
    writeElement(element)
    element.children().each {
      handleElement(it)
    }
  }

  def writeElement(element) {
    switch (element.name()) {
      case BehaviorStepType.STORY:
        writer.newLine()
        writer.write("${' '.padRight(2)}Story: ${element.@name}")
        break
      case BehaviorStepType.DESCRIPTION:
      	writer.write("${' '.padRight(3)} ${element.text()}")
      	writer.newLine()
      	break
      case BehaviorStepType.SCENARIO:
        writer.newLine()
        writer.write("${' '.padRight(4)}scenario ${element.@name}")
        break
      case BehaviorStepType.GIVEN:
        writer.write("${' '.padRight(6)}given ${element.@name}")
        break
      case BehaviorStepType.WHEN:
        writer.write("${' '.padRight(6)}when ${element.@name}")
        break
      case BehaviorStepType.THEN:
        writer.write("${' '.padRight(6)}then ${element.@name}")
        break
      case BehaviorStepType.AND:
        writer.write("${' '.padRight(6)}and")
        break
      default:
        //no op to avoid having alerts in story text
        break
    }

    if (element.@result == Result.FAILED) {
      writer.newLine()
      writer.newLine()
      writer.write("	Failure -> ${element.name()} ${element.@name}")
      writer.newLine()
      writer.write("${element.failuremessage}")
    }
    if (element.@result == Result.PENDING) {
      writer.write(" [PENDING]")
    }
    writer.newLine()

  }
}