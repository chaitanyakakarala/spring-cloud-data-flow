package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableTask
@SpringBootApplication
public class DataFlowSink {

	public static Logger log = LoggerFactory.getLogger(DataFlowSink.class);

	public static void main(String[] args) {
		SpringApplication.run(DataFlowSink.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return strings ->
				System.out.println("Executed at :>>>---->" +
						new SimpleDateFormat().format(new Date()));
	}
}
