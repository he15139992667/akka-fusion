package fusion.kafka

import akka.actor.{ExtendedActorSystem, Extension, ExtensionId, ExtensionIdProvider}
import akka.kafka.ConsumerSettings

final class FusionKafkaConsumer private (system: ExtendedActorSystem) extends Extension {
  def consumer: ConsumerSettings[String, String] = consumers.component
  val consumers = new ConsumerComponents(system)
}

object FusionKafkaConsumer extends ExtensionId[FusionKafkaConsumer] with ExtensionIdProvider {
  override def createExtension(system: ExtendedActorSystem): FusionKafkaConsumer = new FusionKafkaConsumer(system)
  override def lookup(): ExtensionId[_ <: Extension] = FusionKafkaConsumer
}
