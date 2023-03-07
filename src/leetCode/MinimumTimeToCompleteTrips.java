package leetCode;

public class MinimumTimeToCompleteTrips {
    // leetcode 2187
    public long minimumTime(int[] time, int totalTrips) { // binary search
        long max = time[0];
        for (int i : time){
            max = Math.max(max, (long) i);
        }
        long left = 0;
        long right = max * totalTrips;
        while(left < right - 1){
            long mid = left + (right - left) / 2;
            if(isValid(time, mid, totalTrips)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return isValid(time, left, totalTrips) ? left : right;
    }
    private boolean isValid(int[] time, long res, int totalTrips){
        if(res <= 0){
            return false;
        }
        long result = 0;
        for(int i : time){
            result +=  res / i;
        }

        return result >= (long)totalTrips;
    }
}
