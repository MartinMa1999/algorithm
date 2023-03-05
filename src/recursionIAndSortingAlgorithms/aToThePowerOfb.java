package recursionIAndSortingAlgorithms;

public class aToThePowerOfb {
    public long power(int a, int b){
        //return a^b
        if(a == 0 || b == 0){
            return 1;
        }
        long tmp = power(a, b / 2);

        return b % 2 == 0 ? tmp * tmp : tmp * tmp * a;
    }
}

