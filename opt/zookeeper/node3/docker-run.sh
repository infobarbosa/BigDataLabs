docker run -d \
  --net netlab \
  --ip 172.18.0.13 \
  --name zookeeper3 \
  --hostname zookeeper3 \
  -v /bigdatalabs/opt/zookeeper/conf:/opt/zookeeper/conf \
  -v /bigdatalabs/opt/zookeeper/node3/data:/opt/zookeeper/data \
  -v /bigdatalabs/var/lib/zookeeper/logs:/var/lib/zookeeper/logs \
  infobarbosa/zookeeper

