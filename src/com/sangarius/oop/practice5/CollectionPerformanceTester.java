package com.sangarius.oop.practice5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;

public class CollectionPerformanceTester {

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose the data size
        System.out.println("Choose data size:");
        System.out.println(ANSI_GREEN + "1. Small (50000)" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "2. Medium (500000)" + ANSI_RESET);
        System.out.println(ANSI_RED + "3. Large (1000000)" + ANSI_RESET);

        int choice = scanner.nextInt();
        int dataSize = getDataSize(choice);


        ListPerformanceTester listTester = new ListPerformanceTester();
        SetPerformanceTester setTester = new SetPerformanceTester();
        QueuePerformanceTester queueTester = new QueuePerformanceTester();
        MapPerformanceTester mapTester = new MapPerformanceTester();

        // Testing lists
        listTester.testListPerformance(new ArrayList<>(), "ArrayList", dataSize);
        listTester.testListPerformance(new LinkedList<>(), "LinkedList", dataSize);

        // Testing sets
        setTester.testSetPerformance(new HashSet<>(), "HashSet", dataSize);
        setTester.testSetPerformance(new TreeSet<>(), "TreeSet", dataSize);

        // Testing queues
        queueTester.testQueuePerformance(new LinkedList<>(), "LinkedList (as Queue)", dataSize);
        queueTester.testQueuePerformance(new ArrayDeque<>(), "ArrayDeque", dataSize);

        // Testing maps
        mapTester.testMapPerformance(new HashMap<>(), "HashMap", dataSize);
        mapTester.testMapPerformance(new LinkedHashMap<>(), "LinkedHashMap", dataSize);
        mapTester.testMapPerformance(new TreeMap<>(), "TreeMap", dataSize);
        mapTester.testMapPerformance(new ConcurrentHashMap<>(), "ConcurrentHashMap", dataSize);

        System.out.println(ANSI_GREEN + "Test completed");
    }

    private static int getDataSize(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println(ANSI_GREEN + "Small data size (50000)" + ANSI_RESET);
                return 50000;
            }
            case 2 -> {
                System.out.println(ANSI_YELLOW + "Medium data size (500000)" + ANSI_RESET);
                return 500000;
            }
            case 3 -> {
                System.out.println(ANSI_RED + "Large data size (1000000)" + ANSI_RESET);
                return 1000000;
            }
            default -> {
                System.out.println("Invalid choice, using medium data size (500000).");
                return 500000;
            }
        }
    }
}