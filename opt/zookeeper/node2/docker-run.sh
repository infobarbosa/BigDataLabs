docker run -d \
  --net netlab \
  --ip 172.18.0.12 \
  --name zookeeper2 \
  --hostname zookeeper2 \
  -v /bigdatalabs/opt/zookeeper/conf:/opt/zookeeper/conf \
  -v /bigdatalabs/opt/zookeeper/node2/data:/opt/zookeeper/data \
  -v /bigdatalabs/var/lib/zookeeper/logs:/var/lib/zookeeper/logs \
  infobarbosa/zookeeper

