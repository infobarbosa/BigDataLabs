package com.infobarbosa.spark.streaming

import com.datastax.spark.connector
import com.datastax.spark.connector._
import com.datastax.spark.connector.cql
import com.datastax.spark.connector.cql._
import com.datastax.spark.connector.cql.CassandraConnector
import com.datastax.spark.connector.cql.CassandraConnector._
import com.datastax.spark.connector.streaming._

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import kafka.serializer.StringDecoder
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.cassandra
import org.apache.spark.sql.cassandra._

import java.util.UUID

object Demo
{
	/**
	* TODO 
	* Alterar esse codigo para receber uma linha do bolsa familia e retornar uma tupla de um (UUID, linha de pagamento)
	*/
	def parse(line: String): (UUID, String) = {
		val uuid = UUID.randomUUID()
		return (uuid, line)
	}

	/*Main*/
	def main(args: Array[String])
	{
		val conf = new SparkConf( true )
			.setAppName("spark-streaming-demo")
			.set("spark.cassandra.connection.host", "cassandra1,cassandra2,cassandra3")

		//Define um contexto com o cluster
		val ssc = new StreamingContext(conf, Seconds(1) ) //StreamingContext

                val kafkaParams = Map[String, Object](
                        "bootstrap.servers" -> "kafka1:9092,kafka2:9092,kafka3:9092",
                        "key.deserializer" -> classOf[StringDeserializer],
                        "value.deserializer" -> classOf[StringDeserializer],
                        "group.id" -> "bolsafamilia-group",
                        "auto.offset.reset" -> "latest",
                        "enable.auto.commit" -> (false: java.lang.Boolean)
                )

		val topics = Array("bolsaf")
		
		val lines = KafkaUtils.createDirectStream[String, String](
  				ssc, 
				PreferConsistent, 
				Subscribe[String,String](topics, kafkaParams)
			    ).map(record => record.value)

		val tuples = lines.map(parse)

		tuples.saveToCassandra("bolsafamilia", "raw_data", SomeColumns("id", "data"))

		ssc.start()
		ssc.awaitTermination()
	}
}
