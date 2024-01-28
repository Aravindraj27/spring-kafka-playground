### Setting Up Kafka in Local
Kafka can be downloaded from https://kafka.apache.org/downloads this link. It is safe to download the latest version of Kafka.

1. **Downloading Kafka** : Once the download is complete unzip the dowloaded file.
```bash
cd <unzipped_kafka_folder>
```
2. **Starting the zookeeper** : Once you go into the Kafka folder using the above command we can start the zookeeper with the following command.

```bash
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

One of the issues I faced during this is a build error as follows.
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
Classpath is empty. Please build the project first.
```
to fix this I first ran the following command
```bash
 ./gradlew jar -PscalaVersion=2.13.11
```
Once this command is completed you can try the zookeeper command once again it should start smoothly.
3. **Starting the Brokers** : Next step is to start the Kafka broker service with the following command. `Note : Kafka brokers by default use port 9092` incase you are running any other application on the same port please changes accordingly.

```bash
$ bin/kafka-server-start.sh config/server.properties
```
`Note: you should open two terminals and run step 1 and 2 simultaneously.`
4. **Creating the topics** : The topics can be created using the following commands.
```bash
$ bin/kafka-topics.sh --create --topic <Your_Topic_Name> --bootstrap-server localhost:9092
```
you can check the topic configuration like partition counts using the following command.
 ```bash
 bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/Users/aravindrajganesan/Workspace/BackendDevelopment/kafka-3.6.1-src/tools/build/dependant-libs-2.13.11/slf4j-reload4j-1.7.36.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/Users/aravindrajganesan/Workspace/BackendDevelopment/kafka-3.6.1-src/trogdor/build/dependant-libs-2.13.11/slf4j-reload4j-1.7.36.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.Reload4jLoggerFactory]
Topic: quickstart-events	TopicId: KD_gpUa2SFC0gMd6IjxYNw	PartitionCount: 1	ReplicationFactor: 1	Configs:
	Topic: quickstart-events	Partition: 0	Leader: 0	Replicas: 0	Isr: 0
```
5. **Write some data to the topic** : The below command will spin up a producer that will publish a message to the give topic
```bash
bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
>I am here
>I am your father
>What are you
```
6. **Consume messages from the topic** : The below command can be use to consume a message from the topic
```bash
$ bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
I am here
I am your father
What are you
```
