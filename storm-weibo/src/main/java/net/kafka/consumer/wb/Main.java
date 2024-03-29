package net.kafka.consumer.wb;

//import java.util.ArrayList;
//import java.util.List;
//
//import storm.kafka.KafkaConfig.StaticHosts;
//import storm.kafka.SpoutConfig;
//import storm.kafka.StringScheme;
import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;

public class Main {

	public static void main(String[] args) throws Exception {

		// List<String> hosts = new ArrayList<String>();
		// hosts.add("master");
		// hosts.add("data-test-210");
		// hosts.add("data-test-211");

		// SpoutConfig spoutConf = new SpoutConfig(StaticHosts.fromHostString(
		// hosts, 10), "weibo-test1", "/weibo", "weibo");
		// spoutConf.scheme = new StringScheme();
		// spoutConf.zkPort = 2181;
		// spoutConf.forceStartOffsetTime(-2); // To start from beginning of
		// topic
		// KafkaSpout kafkaSpout = new KafkaSpout(kafkaConf);
		// WbSpout spout = new WbSpout();

		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout", new WbSpout(), 4);
		builder.setBolt("content-pict", new ContentPictBolt()).shuffleGrouping(
				"spout");
		builder.setBolt("wb-count", new WbCountBolt()).shuffleGrouping(
				"content-pict");

		Config config = new Config();
		// config.setDebug(true);
		config.setNumWorkers(4);
		config.setMaxSpoutPending(1000);
		StormSubmitter.submitTopology("wb-topology", config,
				builder.createTopology());

	}
}
