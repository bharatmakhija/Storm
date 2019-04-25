# Storm Basics
This is a leisure time project to understand apache storm working and its basics.
# Installing Maven on ubuntu

Verify java is installed using 

```$xslt
java --version
```

If not, first install java.

If java is installed it will give something like this 

```$xslt
java version "1.8.0_91"
Java(TM) SE Runtime Environment (build 1.8.0_91-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.91-b14, mixed mode)

```


Then run following step by step to install maven:

```$xslt
cd /opt/
wget http://www-eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
sudo su # go superuser
tar -xvzf apache-maven-3.3.9-bin.tar.gz
mv apache-maven-3.3.9 maven
vim /etc/profile.d/mavenenv.sh
```

Add following lines in mavenenv.sh

```$xslt
export M2_HOME=/opt/maven
export PATH=${M2_HOME}/bin:${PATH}
```

Give proper rights to the sh file and source it.

```$xslt
sudo chmod +x /etc/profile.d/mavenenv.sh
sudo source /etc/profile.d/mavenenv.sh
```

- Finally verify your installation:

```$xslt
$ mvn --version

Apache Maven 3.3.9 ..)
Maven home: /opt/maven
Java version: 1.8.0_101, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-oracle/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "3.13.0-32-generic", arch: "amd64", family: "unix"
```
[ZX]:https://www.vultr.com/docs/how-to-install-apache-maven-on-ubuntu-16-04 
- For any issues while installation, refer [how-to-install-apache-maven-on-ubuntu-16-04][ZX].

[AB]: https://mvnrepository.com/
- Any maven dependecy to be added can be searched [here][AB].

#Storm dependeny to add in Projects


```$xslt
    <dependency>
        <groupId>org.apache.storm</groupId>
        <artifactId>storm-core</artifactId>
        <version>1.1.1</version>
        <scope>compile</scope>
    </dependency>
```

[FR]: https://mvnrepository.com/artifact/org.apache.storm

- Any Storm maven dependency can be found [here][FR].


# We Also Need Zookeeper
[D-zookeeper]: http://mirrors.estointernet.in/apache/zookeeper/stable/

- [Download Stable zookeeper][D-zookeeper].
- Move downloaded tar to opt/

```$xslt
$ cd opt/
$ tar -zxf zookeeper-3.4.6.tar.gz
$ cd zookeeper-3.4.6
$ mkdir data
```

- Open configuration file named “conf/zoo.cfg” using the command "vi conf/zoo.cfg" and setting all the following parameters as starting point.
  

```$xslt
$ vi conf/zoo.cfg
tickTime=2000
dataDir=/path/to/zookeeper/data
clientPort=2181
initLimit=5
syncLimit=2
```

- start zookeeper server.

```$xslt
$ bin/zkServer.sh start
```

It should show a response like this:

```$xslt
$ JMX enabled by default
$ Using config: /Users/../zookeeper-3.4.6/bin/../conf/zoo.cfg
$ Starting zookeeper ... STARTED

```

- Connecting to zookeeper via command line

```$xslt
 bin/zkCli.sh
```

Output:

```$xslt
Connecting to localhost:2181
................
................
................
Welcome to ZooKeeper!
................
................
WATCHER::
WatchedEvent state:SyncConnected type: None path:null
[zk: localhost:2181(CONNECTED) 0]
```

- Stop zookeeper:

```$xslt
bin/zkServer.sh stop
```
# References
[L1]: https://www.youtube.com/watch?v=0mIEUibjtzk

- [Apache Storm Example | Edureka][L1]
