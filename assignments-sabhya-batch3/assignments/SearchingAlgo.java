
// write program for all searching alogrithms
// write java code for linear seacrh
// write java code for binary search

public class SearchingAlgo {
    //write java code for linear seacrh

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    //write java code for binary search 
    public static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

 //write java code for jump search 
    public static int jumpSearch(int[] arr, int key) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }
        while (arr[prev] < key) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }
        if (arr[prev] == key) {
            return prev;
        }
        return -1;
    }

    //write java code for interpolation search 
    public static int interpolationSearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end && key >= arr[start] && key <= arr[end]) {
            int pos = start + ((key - arr[start]) * (end - start) / (arr[end] - arr[start]));
            if (arr[pos] == key) {
                return pos;
            }
            if (arr[pos] < key) {
                start = pos + 1;
            } else {
                end = pos - 1;
            }
        }
        return -1;
    }

    //write java code for exponential search 
    public static int exponentialSearch(int[] arr, int key) {
        int n = arr.length;
        if (arr[0] == key) {
            return 0;
        }
        int i = 1;
        while (i < n && arr[i] <= key) {
            i = i * 2;
        }
        return binarySearch(arr, key, i / 2, Math.min(i, n));
    }

    public static int binarySearch(int[] arr, int key, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int key = 5;
        System.out.println("Linear Search: " + linearSearch(arr, key));
        System.out.println("Binary Search: " + binarySearch(arr, key));
        System.out.println("Jump Search: " + jumpSearch(arr, key));
        System.out.println("Interpolation Search: " + interpolationSearch(arr, key));
        System.out.println("Exponential Search: " + exponentialSearch(arr, key));
    }
    

    
}
