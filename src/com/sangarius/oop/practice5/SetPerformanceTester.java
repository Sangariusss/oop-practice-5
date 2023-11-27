package com.sangarius.oop.practice5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetPerformanceTester {

    public void testSetPerformance(Set<String> set, String collectionType, int dataSize) {
        System.out.println("Testing " + collectionType + " performance...");

        // Operations
        addElementsToSet(set, dataSize);
        searchInSet(set);
        removeElementFromSet(set);
        filterSet(set);
        sortSet(set);

        Set<String> anotherSet = createAnotherSet(dataSize);
        concatenateSets(set, anotherSet);

        reduceSetToSingleValue(set);
        matchElementsInSet(set);
        countElementsInSet(set);
        sumElementsInSet(set);
        averageElementsInSet(set);

        System.out.println();
    }

    private Set<String> createAnotherSet(int dataSize) {
        Set<String> anotherSet = new HashSet<>();
        addElementsToSet(anotherSet, dataSize);
        return anotherSet;
    }

    private void addElementsToSet(Set<String> set, int dataSize) {
        long startTime = System.nanoTime();

        Random random = new Random();
        set.addAll(IntStream.range(0, dataSize)
            .mapToObj(i -> "Element" + random.nextInt(dataSize))
            .collect(Collectors.toSet()));

        long addTime = System.nanoTime() - startTime;

        System.out.println("Add elements time: " + addTime / 1e6 + " ms");
    }

    private void removeElementFromSet(Set<String> set) {
        // Random element removal
        long startTime = System.nanoTime();

        String randomElement = set.iterator().next();
        set.remove(randomElement);

        long removeTime = System.nanoTime() - startTime;

        System.out.println("Remove element time: " + removeTime / 1e6 + " ms");
    }

    private void searchInSet(Set<String> set) {
        // Random element search
        long startTime = System.nanoTime();

        String randomElement = "Element" + new Random().nextInt(set.size());
        set.contains(randomElement);

        long searchTime = System.nanoTime() - startTime;
        System.out.println("Search time: " + searchTime / 1e6 + " ms");
    }

    private void filterSet(Set<String> set) {
        long startTime = System.nanoTime();


        set = set.stream()
            .filter(s -> s.startsWith("Element"))
            .collect(Collectors.toSet());

        long filterTime = System.nanoTime() - startTime;

        System.out.println("Filter elements time: " + filterTime / 1e6 + " ms");
    }

    private void sortSet(Set<String> set) {
        // Сети не підтримують порядок, але можна створити новий сет або використати TreeSet.
        long startTime = System.nanoTime();

        Set<String> sortedSet = new TreeSet<>(set);

        long sortTime = System.nanoTime() - startTime;

        System.out.println("Sort elements time: " + sortTime / 1e6 + " ms");
    }

    private void concatenateSets(Set<String> set1, Set<String> set2) {
        long startTime = System.nanoTime();

        set1.addAll(set2);

        long concatTime = System.nanoTime() - startTime;

        System.out.println("Concatenate sets time: " + concatTime / 1e6 + " ms");
    }

    private void reduceSetToSingleValue(Set<String> set) {
        long startTime = System.nanoTime();

        set.stream().collect(Collectors.joining());

        long reduceTime = System.nanoTime() - startTime;

        System.out.println("Reduce set time: " + reduceTime / 1e6 + " ms");
    }

    private void matchElementsInSet(Set<String> set) {
        // Перевірка, чи існує елемент, який починається з "Element"
        long startTime = System.nanoTime();

        set.stream().anyMatch(s -> s.startsWith("Element"));

        long matchTime = System.nanoTime() - startTime;

        System.out.println("Match elements time: " + matchTime / 1e6 + " ms");
    }

    private void countElementsInSet(Set<String> set) {
        long startTime = System.nanoTime();

        set.stream().filter(s -> s.startsWith("Element")).count();

        long countTime = System.nanoTime() - startTime;

        System.out.println("Count elements time: " + countTime / 1e6 + " ms");
    }

    private void sumElementsInSet(Set<String> set) {
        // Для стрічок можна використовувати довжину як суму
        long startTime = System.nanoTime();

        set.stream().mapToLong(String::length).sum();

        long sumTime = System.nanoTime() - startTime;

        System.out.println("Sum elements time: " + sumTime / 1e6 + " ms");
    }

    private void averageElementsInSet(Set<String> set) {
        // Середню довжину елементів можна визначити як суму довжин поділену на кількість елементів
        long startTime = System.nanoTime();

        set.stream().mapToLong(String::length).average().orElse(0.0);

        long averageTime = System.nanoTime() - startTime;

        System.out.println("Average elements time: " + averageTime / 1e6 + " ms");
    }
}
