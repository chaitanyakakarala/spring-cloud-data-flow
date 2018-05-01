package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@EnableBinding(Processor.class)
@SpringBootApplication
public class DataFlowProcessor {

	public static Logger log = LoggerFactory.getLogger(DataFlowProcessor.class);

	public static void main(String[] args) {
		SpringApplication.run(DataFlowProcessor.class, args);
	}

	@Transformer(inputChannel = Processor.INPUT,
			outputChannel = Processor.OUTPUT)
	public Object transform(Long timestamp) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:yy");
		String date = dateFormat.format(timestamp);
		return date;
	}

}
