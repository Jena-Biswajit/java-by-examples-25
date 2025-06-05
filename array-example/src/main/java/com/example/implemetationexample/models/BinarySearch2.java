package com.example.implemetationexample.models;

import static java.util.spi.ToolProvider.findFirst;

// find 1st and last occurrence of target
public class BinarySearch2 {
    public int[] findFirstAndLatOccurrence(int[] arr, int target) {
        int first = findIndex(arr, target, true);
        int last = findIndex(arr, target, false);
        return new int[]{first, last};
    }

    private int findIndex(int[] arr, int target, boolean findFirstOccurr) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                result = mid;
                if (findFirstOccurr) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }
        return result;
    }
}
