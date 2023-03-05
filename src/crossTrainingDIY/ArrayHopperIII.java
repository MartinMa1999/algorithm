package crossTrainingDIY;

public class ArrayHopperIII {
    // jump out of array
    public static void main(String[] args) {
        ArrayHopperIII test = new ArrayHopperIII();
        test.minJump(new int[]{2,4,1,1,1,1});
    }
    public int minJump(int[] array) {
        if(array == null || array.length <= 1){
            return -1;
        }

        int[] helper = new int[array.length];
        for(int i = array.length - 1; i >= 0; i--){
            if(array[i] == 0){
                helper[i] = -1;
            }
            if(i + array[i] >= array.length){
                helper[i] = 1;
            }
            else{
                int min = Integer.MAX_VALUE;
                for(int j = 1; j <= array[i] && j + i < array.length; j++){
                    if(helper[i + j] > 0){//注意是和helper的值作比较
                        min = Math.min(min, helper[i + j] + 1);//注意是和helper的值作比较
                    }
                }
                helper[i] = min == Integer.MAX_VALUE ? -1 : min;
            }
        }
        return helper[0];
    }

    public int MethodTwo(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int globalMin = Integer.MAX_VALUE;
        int[] helper = new int[array.length];// 一个记走到当前的最短距离，一个记从当前能不能走出去，如果能走出去的最短距离
        if(array[0] >= array.length){
            return 1;
        }
        for(int i = 1; i < array.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(array[j] + j >= i){
                    min = Math.min(min, helper[j] + 1);
                }
            }
            if(min == Integer.MAX_VALUE){
                min = -1;
            }
            helper[i] = min;
            if(array[i] + i >= array.length){
                if(min > 0){
                    globalMin = Math.min(globalMin, min + 1);
                }
            }
        }
        if (globalMin == Integer.MAX_VALUE){
            return -1;
        }
        return globalMin;
    }
}
