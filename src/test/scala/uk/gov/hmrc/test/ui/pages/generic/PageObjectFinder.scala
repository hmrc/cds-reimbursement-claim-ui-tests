/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages.generic

import java.io.{File, FileNotFoundException}

import org.apache.commons.io.FileUtils
import org.scalatest.exceptions.TestFailedException
import uk.gov.hmrc.test.ui.pages.BasePage

import scala.collection.JavaConverters._

object PageObjectFinder extends BasePage {

  override val title: String = ""
  override val url: String = ""

  private val files = {
    val directories = Seq(
      file("src/test/scala/uk/gov/hmrc/test/ui/pages/")
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
