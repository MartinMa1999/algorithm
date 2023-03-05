package crossTrainingDIY;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringReplace {
    public static void main(String[] args) {
        String input = "aaaaa";
        String a = "aa";
        String b= "bbb";
        StringReplace test = new StringReplace();
        test.replace(input, a, b);

    }
    public String replace(String input, String source, String target) {
        Set<Integer> begin = new HashSet<>();
        Set<Integer> end = new HashSet<>();

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == source.charAt(0)){
                int count = 0;
                for(int k = 0; k < source.length() && i + k < input.length(); k++){
                    if(input.charAt(i + k) == source.charAt(k)){
                        count++;
                    }
                }
                if(count == source.length()){
                    begin.add(i);
                    end.add(i + count - 1);
                    i += source.length() - 1; // bug!! 必须要跳过去，否则上面的例子跑不过；必须要减一，因为走到上面for loop又会自动加一
                }
            }
        }
        char[] array = input.toCharArray();
        if(target.length() <= source.length()){
            int i = 0;
            int j = 0;
            while(j < array.length){
                if(! begin.contains(j)){
                    array[i++] = array[j++];
                }
                else{
                    for(int k = 0; k < target.length(); k++){
                        array[i++] = target.charAt(k);
                    }
                    j = j + source.length();
                }
            }
            return new String(array, 0, i);
        }
        else{
            int size = target.length() - source.length();
            char[] newArray = Arrays.copyOf(array, array.length + end.size() * size);
            int i = newArray.length - 1;
            int j = array.length - 1;
            while(j >= 0){
                if(! end.contains(j)){
                    newArray[i--] = newArray[j--];
                }
                else{
                    for(int k = target.length() - 1; k >= 0; k--){
                        newArray[i--] = target.charAt(k);
                    }
                    j = j - source.length();
                }
            }
            return new String(newArray);
        }
    }
}
