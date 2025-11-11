/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6_sortingalgorithms;
import java.util.Arrays;
/**
 *
 * @author caryd
 */
class ArraySorting {


    static void bubbleSort(int[] arr) {
        System.out.println("\nBefore Bubble Sort: " + Arrays.toString(arr));
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("After Bubble Sort:  " + Arrays.toString(arr));
    }


    static void selectionSort(int[] arr) {
        System.out.println("\nBefore Selection Sort: " + Arrays.toString(arr));
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("After Selection Sort:  " + Arrays.toString(arr));
    }


    static void insertionSort(int[] arr) {
        System.out.println("\nBefore Insertion Sort: " + Arrays.toString(arr));
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("After Insertion Sort:  " + Arrays.toString(arr));
    }
}


class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " (" + grade + ")";
    }
}

class StudentSorter {


    static void sortByGrade(Student[] students) {
        System.out.println("\nBefore Sorting by Grade:");
        display(students);
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].grade > students[j + 1].grade) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("After Sorting by Grade:");
        display(students);
    }

    static void sortByName(Student[] students) {
        System.out.println("\nBefore Sorting by Name:");
        display(students);
        for (int i = 0; i < students.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < students.length; j++) {
                if (students[j].name.compareToIgnoreCase(students[minIndex].name) < 0) {
                    minIndex = j;
                }
            }
            Student temp = students[i];
            students[i] = students[minIndex];
            students[minIndex] = temp;
        }
        System.out.println("After Sorting by Name:");
        display(students);
    }

    static void display(Student[] students) {
        for (Student s : students)
            System.out.print(s + " | ");
        System.out.println();
    }
}


public class Lab6Main {
    public static void main(String[] args) {


        System.out.println("=== TASK 1: ARRAY-BASED SORTING ===");
        int[] arr1 = {5, 2, 9, 1, 5, 6};
        ArraySorting.bubbleSort(arr1.clone());

        int[] arr2 = {8, 3, 7, 4, 2};
        ArraySorting.selectionSort(arr2.clone());

        int[] arr3 = {9, 5, 1, 4};
        ArraySorting.insertionSort(arr3.clone());


        System.out.println("\n=== TASK 2: OBJECT-BASED SORTING ===");
        Student[] students = {
            new Student("Carlos", 85),
            new Student("Anna", 92),
            new Student("Ben", 75),
            new Student("Diana", 88)
        };

        StudentSorter.sortByGrade(students.clone());
        StudentSorter.sortByName(students.clone());


        System.out.println("\n=== TASK 3: MANUAL TRACE (Array: [7, 3, 9, 2, 5]) ===");
        int[] traceArr = {7, 3, 9, 2, 5};
        manualTraceBubble(traceArr);


        practiceProblems();
    }


    static void manualTraceBubble(int[] arr) {
        System.out.println("Initial: " + Arrays.toString(arr));
        int comparisons = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("Pass " + (i + 1) + "." + (j + 1) + ": " + Arrays.toString(arr));
            }
        }
        System.out.println("Sorted:  " + Arrays.toString(arr));
        System.out.println("Total comparisons: " + comparisons);
    }

    static void practiceProblems() {

        System.out.println("\n\n=== PRACTICE PROBLEM 1: Sort Student Grades ===");
        int[] grades = {89, 75, 92, 64, 88};
        ArraySorting.bubbleSort(grades.clone());
        ArraySorting.selectionSort(grades.clone());
        ArraySorting.insertionSort(grades.clone());

        System.out.println("\n=== PRACTICE PROBLEM 2: Alphabetical Sort ===");
        String[] names = {"Zara", "Mike", "Alex", "John", "Bella"};
        selectionSortNames(names);

        System.out.println("\n=== PRACTICE PROBLEM 3: Leaderboard Ranking ===");
        int[] scores = {450, 700, 600, 850, 300};
        insertionSortDescending(scores);
    }

    static void selectionSortNames(String[] names) {
        System.out.println("Before Sorting: " + Arrays.toString(names));
        for (int i = 0; i < names.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < names.length; j++) {
                if (names[j].compareToIgnoreCase(names[minIndex]) < 0)
                    minIndex = j;
            }
            String temp = names[i];
            names[i] = names[minIndex];
            names[minIndex] = temp;
        }
        System.out.println("After Sorting:  " + Arrays.toString(names));
    }

    static void insertionSortDescending(int[] arr) {
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("After Sorting (Descending): " + Arrays.toString(arr));
    }
}