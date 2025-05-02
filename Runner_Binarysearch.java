public class Runner_Binarysearch {
    public Boolean iterativebinarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return false;
        } else {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = left + (left - right) / 2;
                if (arr[mid] == target) {
                    return true;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return false;
    }
    
    public Boolean recursivebinarySearch(int[] arr, int target, int left, int right) {
        if (left >= right) {
            return false;
        }
        else {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                return recursivebinarySearch(arr, target, mid + 1, right);
            } else {
                return recursivebinarySearch(arr, target, left, mid - 1);
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Runner_Binarysearch runner = new Runner_Binarysearch();
        System.out.println(runner.iterativebinarySearch(arr, 3));
    }
}
