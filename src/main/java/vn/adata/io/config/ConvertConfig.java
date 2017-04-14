package vn.adata.io.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import vn.adata.io.entitys.Config;

public class ConvertConfig {

	public Config getproperties() {

		Config config = new Config();
		try {
			Properties prop = new Properties();
			String fileName = "producer.properties";
			InputStream is = new FileInputStream(System.getProperty("user.dir") + "/" + fileName);
			prop.load(is);
			config.setBootstrap_servers(prop.getProperty("bootstrap_servers"));
			config.setRequest_required_acks(prop.getProperty("acks"));
			config.setMax_block_ms(prop.getProperty("max.block.ms"));
			config.setBlock_on_buffer_full(prop.getProperty("block.on.buffer.full"));
			config.setBatch_size(prop.getProperty("batch.size"));
		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}
		return config;
	}
}
