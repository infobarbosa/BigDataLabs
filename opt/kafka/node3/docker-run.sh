docker run -d \
  --net netlab \
  --ip 172.18.0.23 \
  --name kafka3 \
  --hostname kafka3 \
  -v /bigdatalabs/opt/kafka/node3/config/server.properties:/opt/kafka/config/server.properties \
  -v /bigdatalabs/var/lib/kafka/node3/logs:/var/lib/kafka/logs \
  infobarbosa/kafka

