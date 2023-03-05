package stringII;

import java.util.Arrays;

public class DecompressStringII {
    public static void main(String[] args) {
        String s = new String("x2y0i0z3");
        DecompressStringII test = new DecompressStringII();
        test.decompress(s);
    }
    public String decompress(String input) {
        //先处理0，1，2个的，再处理需要扩容的
        if(input.length() == 0){
            return input;
        }
        char[] array = input.toCharArray();
        return encode(array);
    }
    private String encode(char[] array){
        int slow = 0;
        int fast = 0;
        int totalSum = 0;//用来记录需要变长的范围
        while(fast < array.length){
            if(Character.isLetter(array[fast])){
                array[slow++] = array[fast++];
            }
            else{
                int sum = 0;
                int begin = fast;
                while(fast < array.length && Character.isDigit(array[fast])){
                    sum = sum * 10 + (array[fast] - '0');
                    fast++;
                }
                int length = fast - begin;
                if(sum == 0){
                    slow--;//算字母的时候多算了一位，且多算了一个长度
                }
                else if(sum == 1){//此时当作无事发生
                    continue;
                }
                else if(sum == 2){
                    array[slow] = array[slow - 1];
                    slow++;
                }
                else{
                    while(begin < fast){
                        array[slow++] = array[begin++];
                    }
                    totalSum += sum - length - 1;
                }
            }
        }

        int newLength = slow + totalSum;//扩容
        char[] result = Arrays.copyOf(array, newLength);
        fast = slow - 1;
        slow = result.length - 1;

        while(fast >= 0){
            if(Character.isLetter(result[fast])){
                result[slow--] = result[fast--];
            }
            else{
                int i = 0;
                int sum = 0;
                while(Character.isDigit(result[fast])){
                    sum += Math.pow(10, i) * (result[fast] - '0');
                    i++;
                    fast--;
                }
                sum--;//刨去字母自己占的一个位置
                while(sum > 0){
                    result[slow--] = result[fast];
                    sum--;
                }
            }
        }

        return new String(result);

    }
}
