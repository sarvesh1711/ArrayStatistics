package com.aurionpro.test;
public class ArrayStatistics {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input provided.");
            return;
        }

        int[] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + args[i] + " is not an integer.");
                return;
            }
        }

        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        int[] frequency = new int[101]; // Assuming numbers are in the range 0 to 100

        for (int num : numbers) {
            sum += num;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            frequency[num]++;
        }

        double average = (double) sum / numbers.length;

        // Median calculation
        int median;
        if (numbers.length % 2 == 0) {
            int mid1 = numbers.length / 2;
            int mid2 = mid1 - 1;
            median = (numbers[mid1] + numbers[mid2]) / 2;
        } else {
            median = numbers[numbers.length / 2];
        }

        // Displaying the results
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Median: " + median);
        System.out.println("Frequency of each number in the array:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + ": " + frequency[i]);
            }
        }
    }
}
