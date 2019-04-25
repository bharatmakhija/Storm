package UnderstandStormReplayOnFailure;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class MainTopology {
    public static void main(String[] args) {
        TopologyBuilder topologyBuilder = new TopologyBuilder();

        topologyBuilder.setSpout("IntegerSpout",new IntegerSpout());
        topologyBuilder.setBolt("MultiplierBolt", new MultiplierBolt()).shuffleGrouping("IntegerSpout");

        // then create configuration

        Config config = new Config();
        config.setDebug(true);

        LocalCluster localCluster = new LocalCluster();
        try {
            localCluster.submitTopology("MyTopology", config, topologyBuilder.createTopology());
            Thread.sleep(1000);
        }catch (Exception e){}
        finally {
            localCluster.shutdown();
        }
    }
}
