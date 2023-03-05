package DPI;

public class Fibonacci {
    public long fibonacci(int n){
        if(n <= 0){
            return 0;
        }
        long prev = 0;
        long result = 1;
        while(n > 1){
            long tmp = prev + result;
            prev = result;
            result = tmp;
            n--;
        }
        return result;
    }
}
