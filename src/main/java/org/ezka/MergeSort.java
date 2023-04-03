package org.ezka;

import java.util.ArrayList;
import java.util.List;


public class MergeSort<T extends Comparable<T>> {

    // This part of the sorting algo initiates the sorting of a list of any objects
    public void sort(List<T> list) {
        if (list.size() > 1) { // Checking if a list has more than one object
            int mid = list.size() / 2;

            // Splitting the list into two parts
            List<T> left = new ArrayList<>(list.subList(0, mid));
            List<T> right = new ArrayList<>(list.subList(mid, list.size()));

            sort(left); // Recursively splitting the left side of the list until it has one object
            sort(right); // Recursively splitting the right side of the list until it has one object

            merge(list, left, right); // Calling merge function
        }
    }

    // This function sorts the lists of objects and merges them to make the main list
    private void merge(List<T> list, List<T> left, List<T> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            // Checking which side of the list has bigger values and adding the bigger value to the list first
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            }
            else {
                list.set(k++, right.get(j++));
            }
        }

        // Adding all remaining values
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}
