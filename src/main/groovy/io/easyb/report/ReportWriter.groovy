package io.easyb.report

import io.easyb.listener.ResultsAmalgamator

/**
 * Common interface for easyb reports
 */
interface ReportWriter {
  void writeReport(ResultsAmalgamator results)
}