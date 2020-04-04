package com.pandaroid.concurrent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// @SpringBootTest
class ConcurrentApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        /*TimeUnit.SECONDS.sleep(1);
        Thread t = new Thread();
        t.join();
        t.notify();
        Object obj = new Object();
        obj.wait();
        obj.notify();
        LinkedBlockingQueue<Thread> taskLinkedBlockingQueue = new LinkedBlockingQueue<>();
        taskLinkedBlockingQueue.take();
        //
        Thread.currentThread().interrupt();*/
        AtomicInteger i = new AtomicInteger();
        Thread t = new Thread(() -> {
            System.out.println("[TrustBidPrototype] Thread t running start " + i.incrementAndGet());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[TrustBidPrototype] Thread t running end " + i.incrementAndGet());
        });
        System.out.println("[TrustBidPrototype] before t.join() " + i.incrementAndGet());
        t.start();
        t.join(10000);
        System.out.println("[TrustBidPrototype] after t.join() " + i.incrementAndGet());
    }

}
