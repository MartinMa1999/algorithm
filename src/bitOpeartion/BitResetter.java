package bitOpeartion;

class BitResetter {
    public static void main(String[] args) {
        System.out.println(BitResetter.resetter(4, 1));
    }
    // change 1 to 0
    public static int resetter(int x, int k){
        if(k < 0 || k > 31){
            return -1;
        }
        return (~(1 << k)) & x;
    }
}
