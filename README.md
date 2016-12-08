Big Data Labs

Projeto de composição de uma solução big data fim a fim.

No meu ambiente eu criei um diretório raiz chamado /bigdatalabs. 
Debaixo desse diretório pretendo emular os diretórios /opt e /var (e outros onde for o caso).

A solução será baseada em Docker então os commits desse projeto incluirão os Dockerfiles.
No momento já tenho o Zookeeper, Kafka e Flume. Agora estou instalando o Cassandra.
Mais tarde eu monto um roadmap pra que os amigos possam acompanhar.

Criação de um diretório que simula o diretorio raiz do linux
  
  sudo mkdir /bigdatalabs
  chown -R barbosa:barbosa /bigdatalabs

  mkdir -p /bigdatalabs/var/lib
  mkdir -p /bigdatalabs/opt

