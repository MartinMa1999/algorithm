package crossTrainingDIY;

import java.util.Arrays;

public class DecompressStringI {
    // 只有一个字母的时候不用动
    public String decompress(String input) {
        if(input == null || input.length() == 0){
            return input;
        }

        char[] array = input.toCharArray();
        int length = 0;
        for(int i = 1; i < array.length; i++){
            if(Character.isDigit(array[i]) && array[i] - '0' > 2){
                length += array[i] - '0' - 2;
            }
        }
        int j = array.length - 1;
        array = Arrays.copyOf(array, array.length + length);
        int i = array.length - 1;
        while (j >= 0){
            if(Character.isLetter(array[j])){
                array[i--] = array[j--];
            }
            else{
                if(array[j] - '0' == 2){
                    array[i--] = array[j - 1];
                }
                else{
                    int count = array[j] - '0' - 1;
                    while(count > 0){
                        array[i--] = array[j - 1];
                        count--;
                    }
                }
                j--;
            }
        }
        return new String(array);
    }
}
