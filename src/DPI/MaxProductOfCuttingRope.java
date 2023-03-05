package DPI;

public class MaxProductOfCuttingRope {
    public int max(int length){
        if(length <= 1){
            return 0;
        }
        int[] helper = new int[length + 1];
        helper[0] = 0;
        helper[1] = 0;
        for(int i = 2; i < helper.length; i++){
            int max = 0;
            for(int j = 1; j < i; j++){
                int tmp = Math.max(helper[j], j);//必须考虑左边有可能是不切的时候乘积更大的可能
                max = Math.max(max, tmp * (i - j));
            }
            helper[i] = max;
        }
        return helper[length];
    }
}
