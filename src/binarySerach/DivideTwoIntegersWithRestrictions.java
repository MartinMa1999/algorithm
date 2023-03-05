package binarySerach;

public class DivideTwoIntegersWithRestrictions {
    // Given two integers a and b, calculate a / b without using divide/mod operations.
    //
    //Assuming any number divided by 0 is Integer.MAX_VALUE.

    public int divide(int a, int b) {
        if(b == 0){
            return Integer.MAX_VALUE;
        }

        if(a == 0){
            return 0;
        }

        if(a == Integer.MIN_VALUE){
            if(b == -1){
                return Integer.MAX_VALUE;
            }
            if(b == 1){
                return Integer.MIN_VALUE;
            }
        }

        if(a < 0 && b < 0){
            return findIt(-(long) a, -(long) b);
        }
        if(a < 0 || b < 0){
            return -findIt(Math.abs(a), Math.abs(b));
        }

        return findIt(a, b);
    }
    private int findIt(long a, long b){// 相当于算一下a是多少个b加出来的，每次的数量翻倍，知道超界，然后把a减去已经加上的部分，再来一次
        if(a < b){
            return 0;
        }

        long sum = b;
        long count = 1;
        while(a >= sum){
            sum <<= 1;
            count <<= 1;
        }
        sum >>>= 1;
        count >>>= 1;

        return (int)(count + findIt(a - sum, b));
    }
}
