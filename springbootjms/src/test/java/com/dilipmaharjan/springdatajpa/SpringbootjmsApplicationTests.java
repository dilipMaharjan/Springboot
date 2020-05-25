package com.dilipmaharjan.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dilipmaharjan.springdatajpa.sender.MessageSender;

@SpringBootTest
class SpringbootjmsApplicationTests {

	@Autowired
	private MessageSender messageSender;

	@Test
	void testMsg() {
		messageSender.send("test");
	}

}
