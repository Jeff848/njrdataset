/*
 * Copyright 2015-2016 the original author or authors
 *
 * This software is licensed under the Apache License, Version 2.0,
 * the GNU Lesser General Public License version 2 or later ("LGPL")
 * and the WTFPL.
 * You may choose either license to govern your use of this software only
 * upon the condition that you accept all of the terms of either
 * the Apache License 2.0, the LGPL 2.1+ or the WTFPL.
 */
package de.measite.minidns;

import de.measite.minidns.Record.TYPE;
import de.measite.minidns.cache.LRUCache;
import de.measite.minidns.dnsserverlookup.AbstractDNSServerLookupMechanism;
import de.measite.minidns.dnsserverlookup.AndroidUsingExec;
import de.measite.minidns.dnsserverlookup.AndroidUsingReflection;
import de.measite.minidns.dnsserverlookup.DNSServerLookupMechanism;
import de.measite.minidns.dnsserverlookup.HardcodedDNSServerAddresses;
import de.measite.minidns.record.A;
import de.measite.minidns.source.DNSDataSource;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import static de.measite.minidns.DNSWorld.a;
import static de.measite.minidns.DNSWorld.applyStubRecords;
import static de.measite.minidns.DNSWorld.record;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DNSClientTest {

    @Test
    public void testLookupMechanismOrder() {
        DNSClient.addDnsServerLookupMechanism(new TestDnsServerLookupMechanism(AndroidUsingExec.INSTANCE));
        DNSClient.addDnsServerLookupMechanism(new TestDnsServerLookupMechanism(AndroidUsingReflection.INSTANCE));

        List<DNSServerLookupMechanism> expectedOrder = new ArrayList<>();
        expectedOrder.add(0, AndroidUsingExec.INSTANCE);
        expectedOrder.add(1, AndroidUsingReflection.INSTANCE);
        expectedOrder.add(2, HardcodedDNSServerAddresses.INSTANCE);
        for (DNSServerLookupMechanism mechanism : DNSClient.LOOKUP_MECHANISMS) {
            if (expectedOrder.isEmpty()) {
                break;
            }
            DNSServerLookupMechanism shouldBeRemovedNext = expectedOrder.get(0);
            if (mechanism.getName().equals(shouldBeRemovedNext.getName())) {
                expectedOrder.remove(0);
            }
        }
        assertTrue(expectedOrder.isEmpty());
    }

    private static class TestDnsServerLookupMechanism extends AbstractDNSServerLookupMechanism {
        protected TestDnsServerLookupMechanism(DNSServerLookupMechanism lookupMechanism) {
            super(lookupMechanism.getName(), lookupMechanism.getPriority());
        }
        @Override
        public boolean isAvailable() {
            return true;
        }
        @Override
        public String[] getDnsServerAddresses() {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testSingleRecordQuery() throws IOException {
        DNSClient client = new DNSClient(new LRUCache(0));
        applyStubRecords(client, record("www.example.com", a("127.0.0.1")));
        DNSMessage response = client.query("www.example.com", TYPE.A);
        assertNotNull(response);
        assertEquals(1, response.answerSection.size());
        assertEquals(TYPE.A, response.answerSection.get(0).type);
        assertArrayEquals(new byte[]{127, 0, 0, 1}, ((A) response.answerSection.get(0).payloadData).getIp());
        response = client.query("www2.example.com", TYPE.A);
        assertNull(response);
        response = client.query("www.example.com", TYPE.CNAME);
        assertNull(response);
    }

    @Test
    public void testReturnNullSource() throws IOException {
        class NullSource extends DNSDataSource {
            boolean queried = false;

            @Override
            public DNSMessage query(DNSMessage message, InetAddress address, int port) {
                queried = true;
                return null;
            }
        }
        DNSClient client = new DNSClient(new LRUCache(0));
        NullSource source = new NullSource();
        client.setDataSource(source);
        DNSMessage message = client.query("www.example.com", TYPE.A);
        assertNull(message);
        assertTrue(source.queried);
    }
}
