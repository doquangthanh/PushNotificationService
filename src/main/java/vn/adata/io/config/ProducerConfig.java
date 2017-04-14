package vn.adata.io.config;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.adata.io.entitys.Config;

@Configuration
public class ProducerConfig {

	public ProducerConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Bean
	public Producer<String, String> kafkaProducer() {
		ConvertConfig convert = new ConvertConfig();
		Config config = convert.getproperties();
		Properties properties = new Properties();
		properties.put("bootstrap.servers", config.getBootstrap_servers());
		properties.put("key.serializer", StringSerializer.class.getName());
		properties.put("value.serializer", StringSerializer.class.getName());
		properties.put("acks", config.getRequest_required_acks());
		properties.put("max.block.ms", config.getMax_block_ms());
		properties.put("block.on.buffer.full", config.getBlock_on_buffer_full());
		properties.put("batch.size", config.getBatch_size());
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		return producer;
	}
}
