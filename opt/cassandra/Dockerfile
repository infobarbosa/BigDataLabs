FROM openjdk:8-jre-alpine
MAINTAINER Marcelo Barbosa <infobarbosa@yahoo.com.br>

ARG MIRROR=http://apache.mirrors.pair.com
ARG VERSION=3.9

LABEL name="cassandra" version=$VERSION

RUN apk add --no-cache wget bash \
    && mkdir /opt \
    && wget -q -O - $MIRROR/cassandra/$VERSION/apache-cassandra-$VERSION-bin.tar.gz | tar -xzf - -C /opt \
    && mv /opt/apache-cassandra-$VERSION-bin /opt/cassandra \ 
    && mkdir -p /var/lib/cassandra/data \
    && mkdir -p /var/lib/cassandra/commitlog \
    && mkdir -p /var/lib/cassandra/saved_caches

EXPOSE 9160

WORKDIR /opt/cassandra

ENTRYPOINT ["/opt/cassandra/bin/cassandra"]

