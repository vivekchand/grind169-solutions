public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        
        while(low <= high) {
            int mid =  low + (high - low) / 2;
            if(isBadVersion(mid) && isBadVersion(mid-1)) {
                high = mid - 1;
            } else if (isBadVersion(mid)) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}