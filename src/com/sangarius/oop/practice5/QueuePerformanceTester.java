package com.sangarius.oop.practice5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QueuePerformanceTester {

    public void testQueuePerformance(Queue<String> queue, String collectionType, int dataSize) {
        System.out.println("Testing " + collectionType + " performance...");

        // Operations
        addElementsToQueue(queue, dataSize);
        pollFromQueue(queue);
        testFilter(queue);
        testSort(queue);
        testFind(queue);
        testConcat(queue, dataSize);
        testReduce(queue);
        testMatch(queue);
        testCounting(queue);
        testSum(queue);
        testAverage(queue);

        System.out.println();
    }

    private void addElementsToQueue(Queue<String> queue, int dataSize) {
        long startTime = System.nanoTime();

        Random random = new Random();
        queue.addAll(IntStream.range(0, dataSize)
            .mapToObj(i -> "Element" + random.nextInt(dataSize))
            .toList());

        long addTime = System.nanoTime() - startTime;

        System.out.println("Add elements time: " + addTime / 1e6 + " ms");
    }

    private void pollFromQueue(Queue<String> queue) {
        long startTime = System.nanoTime();

        while (!queue.isEmpty()) {
            queue.poll();
        }

        long pollElapsedTime = System.nanoTime() - startTime;

        System.out.println("Poll elements time: " + pollElapsedTime / 1e6 + " ms");
    }

    private void testFilter(Queue<String> queue) {
        // Filter elements that contain the letter 'e'
        long startTime = System.nanoTime();

        queue.stream().filter(s -> s.contains("e")).count();

        long filterTime = System.nanoTime() - startTime;

        System.out.println("Filter elements containing 'e' time: " + filterTime / 1e6 + " ms");
    }

    private void testSort(Queue<String> queue) {
        // Sort elements
        long startTime = System.nanoTime();

        queue.stream().sorted().collect(Collectors.toCollection(LinkedList::new));

        long sortTime = System.nanoTime() - startTime;

        System.out.println("Sort elements time: " + sortTime / 1e6 + " ms");
    }

    private void testFind(Queue<String> queue) {
        // Find the first element starting with "Element"
        long startTime = System.nanoTime();

        queue.stream().filter(s -> s.startsWith("Element")).findFirst().orElse(null);

        long findTime = System.nanoTime() - startTime;

        System.out.println("Find element starting with 'Element' time: " + findTime / 1e6 + " ms");
    }

    private void testConcat(Queue<String> queue, int dataSize) {
        // Concatenate two queues
        Queue<String> anotherQueue = new LinkedList<>();
        addElementsToQueue(anotherQueue, dataSize);

        long startTime = System.nanoTime();

        Queue<String> concatenatedQueue = new LinkedList<>(queue);
        concatenatedQueue.addAll(anotherQueue);

        long concatTime = System.nanoTime() - startTime;

        System.out.println("Concatenate two queues time: " + concatTime / 1e6 + " ms");
    }

    private void testReduce(Queue<String> queue) {
        // Reduce the elements to a single concatenated string
        long startTime = System.nanoTime();

        queue.stream().reduce(String::concat).orElse("");

        long reduceTime = System.nanoTime() - startTime;

        System.out.println("Reduce elements to a single string time: " + reduceTime / 1e6 + " ms");
    }

    private void testMatch(Queue<String> queue) {
        // Check if any element contains the letter 'x'
        long startTime = System.nanoTime();

        queue.stream().anyMatch(s -> s.contains("x"));

        long matchTime = System.nanoTime() - startTime;

        System.out.println("Match elements containing 'x' time: " + matchTime / 1e6 + " ms");
    }

    private void testCounting(Queue<String> queue) {
        long startTime = System.nanoTime();

        queue.stream().count();

        long countingTime = System.nanoTime() - startTime;

        System.out.println("Counting elements time: " + countingTime / 1e6 + " ms");
    }

    private void testSum(Queue<String> queue) {
        // Sum the lengths of all elements
        long startTime = System.nanoTime();

        queue.stream().mapToInt(String::length).sum();

        long sumTime = System.nanoTime() - startTime;

        System.out.println("Sum lengths of elements time: " + sumTime / 1e6 + " ms");
    }

    private void testAverage(Queue<String> queue) {
        // Calculate the average length of elements
        long startTime = System.nanoTime();

        queue.stream().mapToInt(String::length).average().orElse(0.0);

        long averageTime = System.nanoTime() - startTime;

        System.out.println("Average length of elements time: " + averageTime / 1e6 + " ms");
    }
}
