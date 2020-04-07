package com.pandaroid.concurrent.sync;

public class SyncDemo {
    public synchronized void test() {
        synchronized (this) {

        }
    }

    public synchronized static void test2() {}
}
