package bitOpeartion;

class ReverseBits {
    public int reverse(int num){

        int i = 0;
        int j = 31;
        while(i < j){
            //不等于的时候相当于直接取反
            if(((num >> i) & 1) != ((num >> j) & 1)){
                num = num ^ ((1 << i) + (1 << j));
            }
        }
        return num;
    }
}
