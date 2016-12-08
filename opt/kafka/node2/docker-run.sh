docker run -d \
  --net netlab \
  --ip 172.18.0.22 \
  --name kafka2 \
  --hostname kafka2 \
  -v /bigdatalabs/opt/kafka/node2/config/server.properties:/opt/kafka/config/server.properties \
  -v /bigdatalabs/var/lib/kafka/node2/logs:/var/lib/kafka/logs \
  infobarbosa/kafka

