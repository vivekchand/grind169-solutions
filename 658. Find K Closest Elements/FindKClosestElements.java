class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);
        int left = index - 1, right = index + 1;
        List<Integer> result = new ArrayList<>();
        result.add(arr[index]);
        while (result.size() < k) {
            if (left < 0) {
                result.add(arr[right++]);
            } else if (right >= arr.length || x - arr[left] <= arr[right] - x) {
                result.add(0, arr[left--]);
            } else {
                result.add(arr[right++]);
            }
        }
        return result;
    }
    
    private int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0) {
            return 0;
        }
        if (left >= arr.length) {
            return arr.length - 1;
        }
        return (x - arr[right] <= arr[left] - x) ? right : left;
    }
}
