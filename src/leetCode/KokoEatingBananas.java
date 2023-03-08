package leetCode;

public class KokoEatingBananas {
    // leetcode 875

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        kokoEatingBananas.minEatingSpeed(new int[]{30,11,23,4,20}, 6);
    }
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null || piles.length == 0){
            return Integer.MAX_VALUE;
        }

        int max = piles[0];
        for(int i : piles){
            max = Math.max(max, i);
        }

        int left = 1; // bug!!速度不可能是0，否则算的时候可能会出现分母为0的情况
        int right = max;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isValid(piles, mid, h)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return right;
    }
    private boolean isValid(int[] piles, int speed, int h){
        int result = 0;
        for(int i : piles){
            result += i % speed == 0 ? i / speed : i / speed + 1; // bug! 不一定是+1，如果整除就不是
        }

        return result <= h;
    }
}
