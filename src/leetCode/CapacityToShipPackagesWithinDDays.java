package leetCode;

public class CapacityToShipPackagesWithinDDays {
    // leetcode 1011

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
        capacityToShipPackagesWithinDDays.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5);
    }
    public int shipWithinDays(int[] weights, int days) {
        if(weights == null || weights.length == 0){
            return Integer.MAX_VALUE;
        }
        int left = findMax(weights);
        int right = getSum(weights);
        while(left < right){
            int mid = left + (right - left) / 2;
            int day = findDays(weights, mid);
            if(day <= days){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return left;
    }

    private int findMax(int[] array){
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            max = Math.max(max, array[i]);
        }

        return max;
    }

    private int getSum(int[] array){
        int result = 0;
        for(int i = 0; i < array.length; i++){
            result += array[i];
        }

        return result;
    }

    private int findDays(int[] array, int max){
        int count = 1;
        int cur = 0;
        for(int i = 0; i < array.length; i++){
            if(cur + array[i] < max){ // bug!! 要加等号
                cur += array[i];
            }
            else{
                count++;
                cur = array[i];
            }
        }
        return count;
    }
}
