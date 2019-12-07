package com.springcloudstreamkafka.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcloudstreamkafka.chnnel.MyChnnel;
@Service
@EnableBinding(MyChnnel.class)
public class ConsumerService {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@StreamListener(target = MyChnnel.SHOP_INPUT)
	@Transactional
	public void consumeProject(String messageJson) throws IOException {
		System.out.println("====   "+messageJson+"   ======11111");
		logger.info("**********  Project Message Received  ***************  ");
		logger.info("Project Name: {}", messageJson);
	}

	@StreamListener(target = MyChnnel.SHOP_INPUT)
	@Transactional
	public void consumeAddress(String messageJson) throws IOException {
		System.out.println("====   "+messageJson+"   ======22222");
		logger.info("********** Address Message Received  ****************  ");
		logger.info("Address City: {}", messageJson);
	}
}
