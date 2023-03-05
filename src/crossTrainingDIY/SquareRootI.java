package crossTrainingDIY;

public class SquareRootI {

    public int sqrt(int x) {
        int left = 0; // 注意必须从0开始找，否则就把0丢了，而且有可能找的值会出问题
        int right = x;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if((long)mid * mid > x){
                right = mid - 1;
            }
            else if((long)mid * mid == x){
                return mid;
            }
            else{
                left = mid;
            }
        }
        if(right * right <= x){
            return right;
        }

        return left;
    }
}
