/*
 * Copyright 2021 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.helpers

object ScenarioContext {

  private var scenarioValues = Map.empty[String, Any]
  def set(key: String, value: Any) {
    scenarioValues = scenarioValues + (key -> value)
  }
  def get[T: Manifest](key: String): T =
    scenarioValues
      .get(key)
      .fold(throw new Exception(s"Key $key not found in scenario context"))(_.asInstanceOf[T])
  def reset() {
    scenarioValues.foreach(x => scenarioValues - x._1)
  }

}
