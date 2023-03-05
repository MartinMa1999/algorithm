package hashTableAndStringI;

import java.util.Arrays;

public class RemoveSpaces {
    //remove all leading/trailing/duplicated empty spaces
    public static void main(String[] args) {
        RemoveSpaces test = new RemoveSpaces();
        String s = new String(" I Love  Yahoo ");
        test.removeSpaces(s);
    }
    public String removeSpaces(String input){
        if(input == null || input.length() == 0){
            return input;
        }

        char[] array = input.toCharArray();
        int i = 0;
        int j = 0;

        while(j < array.length && array[j] == ' '){
            j++;
        }

        while(j < array.length){
            if(array[j] != ' '){
                array[i++] = array[j++];
            }
            else{
                if(array[j - 1] != ' '){
                    array[i++] = array[j++];
                }
                else{
                    while(j < array.length && array[j] == ' '){
                        j++;
                    }
                }
            }
        }
        if(i == 0){//否则下面 i - 1直接out of bounds
            return new String("");
        }

        if(array[i - 1] == ' '){// 这里必须是i - 1， 因为i的物理意义是在i之前的都是排好序的，所以最后一位的index是 i - 1
            i--;
        }

        return new String(Arrays.copyOf(array, i));



    }
}
