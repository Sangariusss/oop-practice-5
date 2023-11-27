package com.sangarius.oop.practice5;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapPerformanceTester {

    public void testMapPerformance(Map<Integer, String> map, String collectionType, int dataSize) {
        System.out.println("Testing " + collectionType + " performance...");

        // Operations
        addElementsToMap(map, dataSize);
        searchInMap(map);
        filterMapKeys(map);
        concatenateMapValues(map);
        combineMapValues(map);
        mapContainsValue(map, "Element123");
        countMapEntries(map);
        sumMapKeys(map);
        averageMapValues(map);

        System.out.println();
    }

    private void addElementsToMap(Map<Integer, String> map, int dataSize) {
        long startTime = System.nanoTime();

        Random random = new Random();
        map.putAll(IntStream.range(0, dataSize)
            .boxed()
            .collect(Collectors.toMap(i -> i, i -> "Element" + random.nextInt(dataSize))));

        long addTime = System.nanoTime() - startTime;

        System.out.println("Add elements time: " + addTime / 1e6 + " ms");
    }

    private void searchInMap(Map<Integer, String> map) {
        // Random key search
        long startTime = System.nanoTime();

        int randomKey = new Random().nextInt(map.size());
        boolean keyExists = map.containsKey(randomKey);

        // Do something with the result, for example, log it
        System.out.println("Key " + randomKey + " exists in the map: " + keyExists);

        long searchTime = System.nanoTime() - startTime;

        System.out.println("Search time: " + searchTime / 1e6 + " ms");
    }

    private void filterMapKeys(Map<Integer, String> map) {
        long startTime = System.nanoTime();

        map.keySet().removeIf(key -> key % 2 == 0);

        long filterTime = System.nanoTime() - startTime;

        System.out.println("Filter keys time: " + filterTime / 1e6 + " ms");
    }

    private void concatenateMapValues(Map<Integer, String> map) {
        long startTime = System.nanoTime();

        map.values().stream().collect(Collectors.joining());

        long concatTime = System.nanoTime() - startTime;

        System.out.println("Concatenate values time: " + concatTime / 1e6 + " ms");
    }

    private void combineMapValues(Map<Integer, String> map) {
        long startTime = System.nanoTime();

        map.values().stream().collect(Collectors.joining(", "));

        long combineTime = System.nanoTime() - startTime;

        System.out.println("Combine values time: " + combineTime / 1e6 + " ms");
    }

    private void mapContainsValue(Map<Integer, String> map, String target) {
        long startTime = System.nanoTime();

        map.containsValue(target);

        long matchTime = System.nanoTime() - startTime;

        System.out.println("Matching time: " + matchTime / 1e6 + " ms");
    }

    private void countMapEntries(Map<Integer, String> map) {
        long startTime = System.nanoTime();

        map.size();

        long countTime = System.nanoTime() - startTime;

        System.out.println("Counting time: " + countTime / 1e6 + " ms");
    }

    private void sumMapKeys(Map<Integer, String> map) {
        long startTime = System.nanoTime();

        map.keySet().stream().mapToInt(Integer::intValue).sum();

        long sumTime = System.nanoTime() - startTime;

        System.out.println("Summation time: " + sumTime / 1e6 + " ms");
    }

    private void averageMapValues(Map<Integer, String> map) {
        long startTime = System.nanoTime();

        map.values().stream().mapToDouble(String::length).average().orElse(0);

        long avgTime = System.nanoTime() - startTime;

        System.out.println("Averaging time: " + avgTime / 1e6 + " ms");
    }
}
