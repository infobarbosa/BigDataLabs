docker run -d \
  --net netlab \
  --ip 172.18.0.31 \
  --name flume1 \
  --hostname flume1 \
  -v /bigdatalabs/opt/flume/conf/flume-conf.properties:/opt/flume/conf/flume-conf.properties \
  -v /bigdatalabs/opt/flume/conf/flume-env.sh:/opt/flume/conf/flume-env.sh \
  -v /bigdatalabs/var/lib/flume/data/spool_dir:/var/lib/flume/data/spool_dir \
  infobarbosa/flume

