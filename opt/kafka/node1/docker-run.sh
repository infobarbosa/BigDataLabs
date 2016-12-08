docker run -d \
  --net netlab \
  --ip 172.18.0.21 \
  --name kafka1 \
  --hostname kafka1 \
  -v /bigdatalabs/opt/kafka/node1/config/server.properties:/opt/kafka/config/server.properties \
  -v /bigdatalabs/var/lib/kafka/node1/logs:/var/lib/kafka/logs \
  infobarbosa/kafka

