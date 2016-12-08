docker run -d \
  --net netlab \
  --ip 172.18.0.11 \
  --name zookeeper1 \
  --hostname zookeeper1 \
  -v /bigdatalabs/opt/zookeeper/conf:/opt/zookeeper/conf \
  -v /bigdatalabs/opt/zookeeper/node1/data:/opt/zookeeper/data \
  -v /bigdatalabs/var/lib/zookeeper/logs:/var/lib/zookeeper/logs \
  infobarbosa/zookeeper

