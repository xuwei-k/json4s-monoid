/*
 * Copyright 2009-2010 WorldWide Conferencing, LLC
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

// https://github.com/json4s/json4s/blob/v3.2.4_2.10/tests/src/test/scala/org/json4s/JValueGen.scala

package org.json4s

import org.scalacheck._
import Gen._
import Arbitrary.arbitrary

trait JValueGen {
  def genJValue: Gen[JValue] = frequency((5, genSimple), (1, wrap(genArray)), (1, wrap(genObject)))
  def genSimple: Gen[JValue] = oneOf(
    value(JNull),
    arbitrary[Int].map(JInt(_)),
    arbitrary[Double].map(JDouble(_)),
    arbitrary[Boolean].map(JBool(_)),
    arbitrary[String].map(JString(_)))

  def genArray: Gen[JValue] = for (l <- genList) yield JArray(l)
  def genObject: Gen[JObject] = for (l <- genFieldList) yield JObject(l)

  def genList = Gen.containerOfN[List, JValue](listSize, genJValue)
  def genFieldList = Gen.containerOfN[List, JField](listSize, genField)
  def genField = for (name <- identifier; value <- genJValue; id <- choose(0, 1000000)) yield JField(name+id, value)

  def genJValueClass: Gen[Class[_ <: JValue]] = oneOf(
    JNull.getClass.asInstanceOf[Class[JValue]], JNothing.getClass.asInstanceOf[Class[JValue]], classOf[JInt],
    classOf[JDouble], classOf[JBool], classOf[JString], classOf[JArray], classOf[JObject])

  def listSize = choose(0, 5).sample.get
}

object JValueGen extends JValueGen

