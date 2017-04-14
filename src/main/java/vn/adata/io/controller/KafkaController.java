package vn.adata.io.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.adata.io.entitys.Content;
import vn.adata.io.service.ProducerDispatcher;

@RestController
public class KafkaController {

	@Autowired
	private ProducerDispatcher producerDispatcher;

	@RequestMapping(value = "/ProducerService/", method = RequestMethod.POST)
	public ResponseEntity<Void> sendmsg(final @RequestBody List<Content> contents) {
		System.out.println("************************  Start ***********************");
		System.out.println("Size : " + contents.size());
		Thread thread = new Thread(new Runnable() {
			public void run() {
				for (Content content : contents) {
					if (content != null) {
						Pattern pattern = Pattern.compile("\\w{1,}");
						Matcher matcher = pattern.matcher(content.getTopic());
						if (matcher.matches()) {
							if (!producerDispatcher.dispatch(content.getTopic(), content.getMsg())) {
								// return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
								System.out.println("Error not send message");
							}
						}
					}
				}
			}
		});
		thread.start();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
