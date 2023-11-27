package com.sangarius.oop.practice5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListPerformanceTester {

    public void testListPerformance(List<String> list, String collectionType, int dataSize) {
        System.out.println("Testing " + collectionType + " performance...");

        // Operations
        addElementsToList(list, dataSize);
        sortList(list);
        filterList(list);
        findElement(list, "Element123");

        List<String> anotherList = createAnotherList(dataSize);
        concatenateLists(list, anotherList);

        reduceListToString(list);
        listContainsElement(list, "Element123");
        countElements(list);
        sumList(list);
        averageList(list);

        System.out.println();
    }

    private void addElementsToList(List<String> list, int dataSize) {
        long startTime = System.nanoTime();

        Random random = new Random();
        list.addAll(IntStream.range(0, dataSize)
            .mapToObj(i -> "Element" + random.nextInt(dataSize))
            .toList());

        long addTime = System.nanoTime() - startTime;

        System.out.println("Add elements time: " + addTime / 1e6 + " ms");
    }

    private void sortList(List<String> list) {
        long startTime = System.nanoTime();

        list.sort(String::compareTo);

        long sortTime = System.nanoTime() - startTime;
        System.out.println("Sort time: " + sortTime / 1e6 + " ms");
    }

    private void filterList(List<String> list) {
        long startTime = System.nanoTime();

        List<String> filteredList = list.stream()
            .filter(s -> s.startsWith("Element"))
            .toList();

        list.clear();
        list.addAll(filteredList);

        long filterTime = System.nanoTime() - startTime;

        System.out.println("Filter time: " + filterTime / 1e6 + " ms");
    }

    private void findElement(List<String> list, String target) {
        long startTime = System.nanoTime();

        list.contains(target);

        long findTime = System.nanoTime() - startTime;

        System.out.println("Find time: " + findTime / 1e6 + " ms");
    }

    private List<String> createAnotherList(int dataSize) {
        List<String> anotherList = new ArrayList<>();
        addElementsToList(anotherList, dataSize);
        return anotherList;
    }

    private void concatenateLists(List<String> list1, List<String> list2) {
        long startTime = System.nanoTime();

        list1.addAll(Stream.concat(list1.stream(), list2.stream())
            .toList());

        long concatTime = System.nanoTime() - startTime;

        System.out.println("Concatenation time: " + concatTime / 1e6 + " ms");
    }

    private void reduceListToString(List<String> list) {
        long startTime = System.nanoTime();

        list.stream()
            .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append);
        long reduceTime = System.nanoTime() - startTime;

        System.out.println("Reduction time: " + reduceTime / 1e6 + " ms");
    }

    private void listContainsElement(List<String> list, String target) {
        long startTime = System.nanoTime();

        list.contains(target);

        long matchTime = System.nanoTime() - startTime;

        System.out.println("Matching time: " + matchTime / 1e6 + " ms");
    }

    private void countElements(List<String> list) {
        long startTime = System.nanoTime();

        list.stream().count();

        long countTime = System.nanoTime() - startTime;

        System.out.println("Counting time: " + countTime / 1e6 + " ms");
    }

    private void sumList(List<String> list) {
        long startTime = System.nanoTime();

        list.stream().mapToInt(String::length).sum();

        long sumTime = System.nanoTime() - startTime;

        System.out.println("Summation time: " + sumTime / 1e6 + " ms");
    }

    private void averageList(List<String> list) {
        long startTime = System.nanoTime();

        list.stream().mapToInt(String::length).average().orElse(0.0);

        long avgTime = System.nanoTime() - startTime;

        System.out.println("Averaging time: " + avgTime / 1e6 + " ms");
    }
}
