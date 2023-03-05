package bitOpeartion;

public class BitSetter {
    public static void main(String[] args) {
        System.out.println(BitSetter.SetIt(1, 1));
    }
    //put the k number in the integer x to 1
    public static int SetIt(int x, int k){
        if(k < 0 || k > 31){
            return - 1;
        }

        return x | (1 << k);
    }
}
