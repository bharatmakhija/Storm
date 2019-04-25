package UnderstandStormReplayOnFailure;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;

public class IntegerSpout extends BaseRichSpout {

    SpoutOutputCollector spoutOutputCollector;
    private Integer index = 0;

    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {

        this.spoutOutputCollector = spoutOutputCollector;

    }

    public void nextTuple() {

        if(this.index < 100){

            this.spoutOutputCollector.emit(new Values(this.index));
            this.index +=1;
        }

    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("field"));
    }
}
