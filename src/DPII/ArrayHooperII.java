package DPII;

public class ArrayHooperII {
    // find the minimum jumps you need
    public int minJump(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        int[] helper = new int[array.length];// means that from i to end minimum jumps
        helper[array.length - 1] = 0;

        for(int i = array.length - 2; i >= 0; i--){
            if(array[i] == 0){
                helper[i] = -1;
            }
            else{
                int globalMin = Integer.MAX_VALUE;
                for(int j = 1; j <= array[i] && i + j < array.length; j++){
                    if(helper[i + j] >= 0){//只有检查大于0的才有意义，如果小于0表示没法走
                        globalMin = Math.min(globalMin, helper[i + j]);
                    }
                }
                if(globalMin == Integer.MAX_VALUE){//检查一下有没有可能都小于0
                    helper[i] = -1;
                }
                else{
                    helper[i] = globalMin + 1;
                }

            }
        }
        return helper[0];
    }
    public int method2(int[] array){
        //正着写，如果helper[i]by default，说明没走到过这里，直接写-1；否则就看array[i]是不是0，代表有没有资格往后走。且如果刚走到的点有值，那么就不用再走了，因为之前的点走到这里用的步数一定是小于等于当前情况所需要的步数
        if(array == null || array.length == 0){
            return -1;
        }

        int[] helper = new int[array.length];
        helper[0] = 0;//走到这里最短需要几步
        for(int i = 0; i < helper.length; i++){
            if(i > 0 && helper[i] == 0){
                helper[i] = -1;
            }
            else{
                if(array[i] != 0){
                    for(int j = 1; j <= array[i] && i + j < array.length; j++){
                        if(helper[i + j] == 0){
                            helper[i + j] = helper[i] + 1;
                        }
                    }
                }
            }
        }
        return helper[helper.length - 1];
    }
}
