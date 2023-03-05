package string;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    //Given a non-negative number represented as an array of digits, plus one to the number.

    public int[] plus(int[] digits) {
        if(digits == null || digits.length == 0){
            return digits;
        }

        reverse(digits);
        int value = 1;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < digits.length || value != 0){
            if(i < digits.length){
                value += digits[i];
                i++;
            }
            if(value != 0){
                list.add(value % 10);
                value /= 10;
            }
        }

        int[] result = new int[list.size()];
        for(int j = 0; j < result.length; j++){
            result[j] = list.get(list.size() - 1 - j);
        }
        return result;
    }
    private void reverse(int[] array){
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }
}
