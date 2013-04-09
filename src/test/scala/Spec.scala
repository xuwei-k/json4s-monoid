package org.json4s.test

import org.json4s.{JObject, JValue, JNothing}
import org.json4s.JValueGen.{genJValue, genObject}
import org.specs2.scalaz.Spec
import scalaz.scalacheck.ScalazProperties
import org.scalacheck.Arbitrary
import scalaz.{Monoid, Equal}

class JObjectSpec extends Spec {

  implicit def JObjectArb = Arbitrary(genObject)

  implicit def JObjectInstance: Monoid[JObject] = Monoid.instance(_ merge _, JObject(Nil))

  implicit def JObjectEqual: Equal[JObject] = Equal.equalA

  checkAll(ScalazProperties.monoid.laws[JObject])

}

class JValueSpec extends Spec {

  implicit def JValueArb = Arbitrary(genJValue)

  implicit def JValueInstance: Monoid[JValue] = Monoid.instance(_ ++ _, JNothing)

  implicit def JValueEqual: Equal[JValue] = Equal.equalA

  checkAll(ScalazProperties.monoid.laws[JValue])

}

