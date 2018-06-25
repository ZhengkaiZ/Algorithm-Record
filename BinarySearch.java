class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int upperBound = array.length - 1;
        int lowerBound = 0;
        int mid = 0;
        
        if (array == null || array.length == 0) {
            return -1;
        }
        while (lowerBound + 1 < upperBound) {
            mid = lowerBound + (upperBound - lowerBound) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                upperBound = mid - 1;
            }
            if (array[mid] < target) {
                lowerBound = mid + 1;
            }
        }
        if (array[lowerBound] == target) {
            return lowerBound;
        }
        if (array[upperBound] == target) {
            return upperBound;
        }
        return -1;
    }
    
    public static int binarySearchRecursive(int[] array, int target,
                                            int lowerBound, int upperBound) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (lowerBound > upperBound) {
            return -1;
        }
        int mid = lowerBound + (upperBound - lowerBound) / 2;
        if (mid >= array.length || mid < 0) {
            return -1;
        }
        if (array[mid] > target) {
            return binarySearchRecursive(array, target, lowerBound, mid - 1);
        }
        if (array[mid] < target) {
            return binarySearchRecursive(array, target, mid + 1, upperBound);
        }
        if (array[mid] == target) {
            return mid;
        }
        return -1;
    }
    
    public static void main(String[] argv) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int t = 1;
        int a = binarySearch(array, t);
        int b = binarySearchRecursive(array, t, 0, array.length);
        System.out.println(a);
        System.out.println(b);
    }
}
