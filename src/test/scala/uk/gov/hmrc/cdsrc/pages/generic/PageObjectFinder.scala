/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.cdsrc.pages.generic

import java.io.{File, FileNotFoundException}
import org.apache.commons.io.FileUtils
import org.scalatest.exceptions.TestFailedException
import uk.gov.hmrc.cdsrc.pages.BasePage

import scala.collection.JavaConverters._

object PageObjectFinder extends BasePage {

  override val title: String = ""
  override val url: String = ""

  private val files = {
    val directories = Seq(
      file("src/test/scala/uk/gov/hmrc/cdsrc/pages/")
    )

    val fileList: File => List[File] = f => FileUtils
      .listFiles(f, Array("scala"), true)
      .asScala.toList

    directories.flatMap(fileList)
  }

  def page(page: String): BasePage =
    files.find(_.getName == s"$page.scala")
      .map(_.getAbsolutePath.replaceAll(".*/(uk/.*).scala", "$1").replaceAll("/", "."))
      .map(str => Class.forName(str + "$").getField("MODULE$").get(classOf[BasePage]).asInstanceOf[BasePage])
      .getOrElse(throw new TestFailedException(s"$page does not exist in tests, or it does not conform to Web page format", new FileNotFoundException(), 12))

  def file(path: String): File = {
    new File(path)
  }

}
