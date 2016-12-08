FROM openjdk:8-jre-alpine
MAINTAINER Marcelo Barbosa <infobarbosa@yahoo.com.br>

ARG MIRROR=http://apache.mirrors.pair.com
ARG VERSION=0.10.1.0
ARG SCALA_VERSION=2.11

LABEL name="kafka" version=$VERSION

RUN apk add --no-cache wget bash \
    && mkdir /opt \
    && wget -q -O - $MIRROR/kafka/$VERSION/kafka_$SCALA_VERSION-$VERSION.tgz | tar -xzf - -C /opt \
    && mv /opt/kafka_$SCALA_VERSION-$VERSION /opt/kafka \ 
    && mkdir -p /var/lib/kafka/logs

EXPOSE 9092

WORKDIR /opt/kafka

ENTRYPOINT ["/opt/kafka/bin/kafka-server-start.sh", "/opt/kafka/config/server.properties"]

