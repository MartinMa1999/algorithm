package bitOpeartion;

public class BitTesterOrExtractor {
    public static void main(String[] args){
       System.out.println(BitTesterOrExtractor.getIt(3,0));
    }
    //assume we wanna get the k index of number of an integer
    public static int getIt(int x, int k){
        if(k < 0 || k > 31){
            return -1;
        }

        return (x >> k) & 1;
    }
}
