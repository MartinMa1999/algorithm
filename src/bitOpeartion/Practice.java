package bitOpeartion;

public class Practice {
    public static void main(String[] args){
        System.out.println(4 & 1);
        System.out.println(3 & 0);//一定是0，因为全一则一
        System.out.println(4 | 1);
        System.out.println(3 | 0);//一定是3，因为有1就是1
        System.out.println(~ 0);//所有位均取反
        System.out.println(~ Integer.MAX_VALUE);
        System.out.println(1 ^ 1);//相同为0，不同为1；
    }
}
