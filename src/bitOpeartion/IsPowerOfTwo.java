package bitOpeartion;

class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(IsPowerOfTwo.betterWay(4));
    }
    public static boolean method1(int num){
        if(num <= 0){
            return false;
        }

        while(num % 2 == 0){
            num = num / 2;
        }

        return num == 1;
    }

    public static boolean Method2(int x){
        //bit operation, if x == 10000000, bug
        if(x <= 0){
            return false;
        }

        int count = 0;
        for(int i = 0; i < 32; i++){
            int tmp = (x >> i) & 1;
            count = tmp == 1 ? count + 1 : count;
        }
        return count == 1;
    }

    public static boolean betterWay(int x){
        //bits operation, check x & x - 1 and 0
        return x > 0 && (x & (x - 1)) == 0;//不加括号会出bug
    }
}
