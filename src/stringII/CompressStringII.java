package stringII;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

public class CompressStringII {
    //从后面看前面，需要单独check最后一个是不是单独字母
    public String compress(String input) {
        if(Objects.equals(input, "") || input.length() == 0){
            return input;
        }
        if(input.length() == 1){
            char[] array = new char[2];
            array[0] = input.charAt(0);
            array[1] = (char) (1 + '0');
            return new String(array);
        }
        char[] array = input.toCharArray();
        int i = 0;
        int j = 0;
        //通过后一个来判断前一个, 记录总体单个字母的个数，因为通过后一个来判断前一个，因此必须要考虑长度为1的情况
        //由于最后一个没法判断，且是in-place操作会改变值，所以提前判断最后一个是不是单独的字母
        int singleSum = array[array.length - 1] == array[array.length - 2] ? 0 : 1;
        int singleNum = 0;//计算每个遇到的字母的个数
        while(j < array.length){
            if(j == 0){
                array[i++] = array[j++];
                singleNum = 1;
            }
            else{
                if(array[j] != array[j - 1]){
                    array[i++] = array[j++];
                    if(singleNum == 1){
                        singleSum++;
                    }
                    singleNum = 1;
                }
                else{
                    while(j < array.length && array[j] == array[j - 1]){
                        j++;
                        singleNum++;
                    }

                    int count = singleNum;
                    Deque<Integer> stack = new ArrayDeque<>();
                    while(count % 10 != 0 || count / 10 != 0){ // count == 10, count % 10 = 0
                        stack.offerFirst(count % 10);
                        count /= 10;
                    }

                    while(! stack.isEmpty()){
                        array[i++] = (char)(stack.pollFirst() + '0');
                    }
                }
            }

        }

        if(singleSum == 0){
            return new String(Arrays.copyOf(array, i));
        }

        char[] result = Arrays.copyOf(array, i + singleSum);

        j = i - 1;
        i = result.length - 1;
        while(i >= 0 && j >= 0){
            if(result[j] - '0' < 10){
                result[i--] = result[j--];
            }
            else{
                if(i < result.length - 1 && result[i + 1] - '0' < 10){//说明此时前一个是数字
                    result[i--] = result[j--];
                }
                else{
                    result[i--] = '1';
                    result[i--] = result[j--];
                }
            }
        }

        return new String(result);
    }

    public String officialWay(String input){
        if(input == null || input.length() == 0){
            return  input;
        }

        char[] array = input.toCharArray();
        return encode(array);
    }
    private String encode(char[] input){
        int slow = 0;
        int fast = 0;
        int newLength = 0;
        while(fast < input.length){
            int begin = fast;
            while(fast < input.length && input[fast] == input[begin]){
                fast++;
            }
            input[slow++] = input[begin];
            if(fast - begin == 1){
                newLength += 2;
            }
            else{
                int len = copyDigits(input, slow, fast - begin);
                slow += len;
                newLength += len + 1;
            }
        }
        char[] result = new char[newLength];
        fast = slow - 1;
        slow = result.length - 1;
        while(fast >= 0){
            if(Character.isDigit(input[fast])){
                while(fast >= 0 && Character.isDigit(input[fast])){
                    result[slow--] = input[fast--];
                }
            }
            else {
                result[slow--] = 1;
            }
            result[slow--] = input[fast--];
        }
        return new String(result);
    }
    private int copyDigits(char[] input, int index, int count){
        int len = 0;
        for(int i = count; i > 0; i /= 10){
            index++;
            len++;
        }
        for(int i = count; i > 0; i /= 10){
            int digit = count % 10;
            input[--index] = (char) (digit + '0');
        }
        return len;
    }
}
