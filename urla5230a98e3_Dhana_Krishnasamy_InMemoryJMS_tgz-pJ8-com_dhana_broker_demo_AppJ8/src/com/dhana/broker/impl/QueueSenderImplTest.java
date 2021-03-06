package com.dhana.broker.impl;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dhana.broker.Message;
import com.dhana.broker.MockMessage;
import com.dhana.broker.exceptions.DestinationClosedException;
import com.dhana.broker.impl.QueueSenderImpl;

public class QueueSenderImplTest {

	QueueSenderImpl sender;
	MockQueue mockQueue;

	@Before
	public void setUp() {
		mockQueue = new MockQueue();
	}

	@Test
	public void testPublishMessage() {
		try {
			sender = new QueueSenderImpl(mockQueue);

			Message msg = new MockMessage("testMessage");
			sender.sendMessage(msg);
			List<Message> received = mockQueue.getMessages();
			assertNotNull("Topic was sent a null message/No message sent",
					received);
			assertEquals("Unexpected number of messages were sent to topic", 1,
					received.size());
			assertEquals("Received message not equal to expected. ", msg,
					received.get(0));
		} catch (DestinationClosedException e) {
			fail("DestinationClosedException" + e.getMessage());
		}
	}

	@Test
	public void testPublishMessageSetsTTL() {
		try {
			sender = new QueueSenderImpl(mockQueue);
			Message msg = new MockMessage("testMessage");
			long now = System.currentTimeMillis();
			sender.sendMessage(msg);
			List<Message> received = mockQueue.getMessages();
			assertNotNull("Topic was sent a null message/No message sent",
					received);
			assertEquals("Unexpected number of messages were sent to topic", 1,
					received.size());
			assertEquals("Received message not equal to expected. ", msg,
					received.get(0));
			assertTrue("Received message didnt not have TTL. ", received.get(0)
					.getExpiration() >= now + 10);
		} catch (DestinationClosedException e) {
			fail("DestinationClosedException" + e.getMessage());
		}
	}

	@Test(expected = NullPointerException.class)
	public void testPublishNullMessage() {
		try {
			sender = new QueueSenderImpl(mockQueue);
			sender.sendMessage(null);
		} catch (DestinationClosedException e) {
			fail("DestinationClosedException" + e.getMessage());
		}
	}

	@Test
	public void testPublishMultipleMessagesWithOrder() {
		int noOfMessages = 3;
		try {
			LinkedList<Message> messages = new LinkedList<Message>();
			sender = new QueueSenderImpl(mockQueue);
			for (int i = 0; i < noOfMessages; i++) {
				Message msg = new MockMessage("testMessage" + i);
				sender.sendMessage(msg);
				messages.add(msg);
			}

			List<Message> received = mockQueue.getMessages();
			assertNotNull("Topic was sent a null message/No message sent",
					received);
			assertEquals("Unexpected number of messages were sent to topic",
					noOfMessages, received.size());
			assertEquals("Received message not equal to expected. ", messages,
					received);
		} catch (DestinationClosedException e) {
			fail("DestinationClosedException" + e.getMessage());
		}

	}
}
