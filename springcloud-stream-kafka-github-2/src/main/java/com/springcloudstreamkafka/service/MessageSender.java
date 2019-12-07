package com.springcloudstreamkafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.springcloudstreamkafka.chnnel.MyChnnel;

@Service
@EnableBinding(MyChnnel.class)
public class MessageSender {
	private final Logger logger = LoggerFactory.getLogger(MessageSender.class);

	private MessageChannel shop_output;

	public MessageSender(MessageChannel shop_output) {
		this.shop_output = shop_output;
	}

	public void send(String jsonMessage) {
		shop_output.send(MessageBuilder.withPayload(jsonMessage).build());
		// MyChnnel.sendShopMessage().send(MessageBuilder.withPayload(jsonMessage).build());
	}
}
