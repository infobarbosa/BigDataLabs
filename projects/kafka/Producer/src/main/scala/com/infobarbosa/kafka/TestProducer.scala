package com.infobarbosa.kafka

import kafka.producer.ProducerConfig
import java.util.Properties
import kafka.producer.Producer
import scala.util.Random
import kafka.producer.Producer
import kafka.producer.KeyedMessage
import java.util.Date
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

object TestProducer extends App {
  val topic = "bolsaf"
  val rnd = new Random()

  val props = new Properties();
  props.put("bootstrap.servers", "172.18.0.21:9092,172.18.0.22:9092,172.18.0.23:9092");
  //props.put("bootstrap.servers", "localhost:9092");
  props.put("acks", "all");
  props.put("retries", "0");
  props.put("batch.size", "16384");
  props.put("linger.ms", "1");
  props.put("buffer.memory", "33554432");
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
 
  val producer = new KafkaProducer[String, String](props)

  for (nEvents <- Range(0, 1000000)) {
    val runtime = new Date().getTime();
    val ip = "192.168.2." + rnd.nextInt(255);
    val msg = runtime + "," + nEvents + ",www.example.com," + ip;
    val data = new ProducerRecord(topic, ip, msg)

    producer.send(data);

    System.out.println(msg);
  }

  producer.close();
}

