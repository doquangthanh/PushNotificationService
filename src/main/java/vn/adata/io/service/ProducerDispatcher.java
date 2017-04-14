package vn.adata.io.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.Gson;

import vn.adata.io.entitys.Message;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerDispatcher {

	@Autowired
	private Producer<String, String> kafkaProducer;

	Date date = new Date();
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerDispatcher.class);

	public boolean dispatch(String topic, Object msg) {
		Gson gson = new Gson();
		String message = gson.toJson(msg);

		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, message);

		try {
			this.kafkaProducer.send(record, new Callback() {

				public void onCompletion(RecordMetadata metadata, Exception exception) {
					if (exception != null) {
						exception.printStackTrace();
						System.out.println("Error : " + exception);
					} else {
						System.out.println(df.format(date) + " : " + " Add success :" + metadata.topic() + " , "
								+ metadata.partition() + " , " + metadata.offset() + " , " + metadata.toString());
					}
				}
			});
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
