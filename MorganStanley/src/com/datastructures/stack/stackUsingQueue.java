package com.datastructures.stack;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class stackUsingQueue {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        blockingQueue.put(100);

    }
}
