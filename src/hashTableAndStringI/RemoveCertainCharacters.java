package hashTableAndStringI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    public String remove(String input, String target){
        // cannot retain relative order
        char[] inputArray = input.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < target.length(); i++){
            set.add(target.charAt(i));
        }

        int j = 0;
        int k = inputArray.length - 1;
        while(j <= k){
            if(set.contains(inputArray[j])){
                swap(inputArray, j, k);
                k--;
            }
            else{
                j++;
            }
        }
        return new String(Arrays.copyOf(inputArray, j));
    }
    private void swap(char[] array, int i, int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public String remove2(String input, String target){
        // can remain relative number
        char[] inputArray = input.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < target.length(); i++){
            set.add(target.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (char c : inputArray) {
            if (!set.contains(c)) {
                sb.append(c);
            }
        }

        return sb.toString();


    }
}
