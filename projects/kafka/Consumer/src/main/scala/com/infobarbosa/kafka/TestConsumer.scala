package com.infobarbosa.kafka

import java.util.Properties
import java.util.concurrent._
import scala.collection.JavaConversions._
import kafka.consumer.Consumer
import kafka.consumer.ConsumerConfig
import kafka.utils._
import kafka.utils.Logging
import kafka.consumer.KafkaStream

object TestConsumer {
  def main(args: Array[String]): Unit = {
    val props = new java.util.Properties();
    props.put("zookeeper.connect", "172.18.0.11:2181,172.18.0.12:2181,172.18.0.13:2181");
    props.put("group.id", "1");
    props.put("zookeeper.session.timeout.ms", "400");
    props.put("zookeeper.sync.time.ms", "200");
    props.put("auto.commit.interval.ms", "1000");
    val config = new kafka.consumer.ConsumerConfig( props );

    val consumer=kafka.consumer.Consumer.create( config )

    val topic= "bolsaf"
    val numThread=1
    val topicCounts=Map(topic->numThread)
    val consumerMap=consumer.createMessageStreams(topicCounts)

    val consumerIterator=consumerMap.get(topic).get.head.iterator()  

    val msgs = consumerIterator.map(_.message())
  
    //the msg is a Array[Byte] type , 
    //if you want to convert the Array[Byte] to a String, 
    //you can using the new String(bytes)
    msgs.foreach(msg=>println(new String(msg)))
  }
}
