/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basic.sorting.algorithms;

import java.util.Arrays;

class Student {
    String name;
    int grade;

    Student(String n, int g) {
        name = n;
        grade = g;
    }

    @Override
    public String toString() {
        return name + " (" + grade + ")";
    }
}

public class SortingLab {

    // =====================
    // Array-Based Sorting
    // =====================
    static void bubbleSort(int[] arr) {
        System.out.println("Before Bubble Sort: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("After Bubble Sort : " + Arrays.toString(arr) + "\n");
    }

    static void selectionSort(int[] arr) {
        System.out.println("Before Selection Sort: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("After Selection Sort : " + Arrays.toString(arr) + "\n");
    }

    static void insertionSort(int[] arr) {
        System.out.println("Before Insertion Sort: " + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("After Insertion Sort : " + Arrays.toString(arr) + "\n");
    }

    // =====================
    // Object-Based Sorting
    // =====================
    static void bubbleSortByGrade(Student[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].grade > arr[j + 1].grade) {
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void selectionSortByName(Student[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].name.compareToIgnoreCase(arr[minIndex].name) < 0) {
                    minIndex = j;
                }
            }
            Student temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // =====================
    // Main Method
    // =====================
    public static void main(String[] args) {
        // Task 1: Array-Based Sorting
        int[] arr1 = {7, 3, 9, 2, 5};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        bubbleSort(arr1);
        selectionSort(arr2);
        insertionSort(arr3);

        // Task 2: Object-Based Sorting
        Student[] students = {
                new Student("Emma", 88),
                new Student("Liam", 95),
                new Student("Ava", 70),
                new Student("Noah", 82)
        };

        System.out.println("Before Sorting Students: " + Arrays.toString(students));

        bubbleSortByGrade(students);
        System.out.println("After Sorting by Grade: " + Arrays.toString(students));

        selectionSortByName(students);
        System.out.println("After Sorting by Name : " + Arrays.toString(students) + "\n");

        // Practice Problem 1: Sort Grades
        int[] grades = {88, 95, 70, 82, 91};
        insertionSort(grades);

        // Practice Problem 2: Alphabetical Sort
        String[] names = {"Liam", "Noah", "Ava", "Emma"};
        System.out.println("Before Name Sort: " + Arrays.toString(names));
        for (int i = 0; i < names.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < names.length; j++) {
                if (names[j].compareToIgnoreCase(names[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = names[i];
            names[i] = names[minIndex];
            names[minIndex] = temp;
        }
        System.out.println("After Name Sort : " + Arrays.toString(names) + "\n");

        // Practice Problem 3: Leaderboard Ranking (Descending)
        int[] scores = {1200, 900, 1500, 1100};
        System.out.println("Before Leaderboard Ranking: " + Arrays.toString(scores));
        for (int i = 1; i < scores.length; i++) {
            int key = scores[i];
            int j = i - 1;
            while (j >= 0 && scores[j] < key) { // descending order
                scores[j + 1] = scores[j];
                j--;
            }
            scores[j + 1] = key;
        }
        System.out.println("After Leaderboard Ranking: " + Arrays.toString(scores));
    }
}
