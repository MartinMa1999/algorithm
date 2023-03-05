package bitOpeartion;

class NumberOfBitsDifferent {
    public static void main(String[] args) {
        System.out.println(NumberOfBitsDifferent.num(0, 7));
    }
    public static int num(int a, int b){
        if(a == b){
            return 0;
        }

        int c = a ^ b;
        int count = 0;
        for(int i = 0; i < 32; i++){
            count = ((c >> i) & 1) == 1 ? count + 1 : count;
        }

        return count;
    }
}
