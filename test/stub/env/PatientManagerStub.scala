package stub.env

import akka.actor
import akka.actor.{Actor, Props}
import com.typesafe.scalalogging.LazyLogging
import protocols.AppProtocol._

object PatientManagerStub {
  def props: Props = actor.Props(new PatientManagerStub)
}

class PatientManagerStub extends Actor with LazyLogging {

  override def receive: Receive = {
    case CreatePatient(patient) =>
      println(s"FAKE_PATIENT:$patient")
      sender() ! createPatient(patient)
  }

  def createPatient(patient: Patient): Patient = {
    patient
  }

}
