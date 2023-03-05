package array;

public class StringDistance {
    // Given an array of strings, and two different string s and t. We need to return the smallest indices difference between the two given strings.
    //
    //Return -1 if we can not find s or t in the array.

    public int distance(String[] array, String source, String target) {
        int min = Integer.MAX_VALUE;
        if(array == null || array.length == 0){
            return -1;
        }

        int a = -1;
        int b = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(source)){
                if(b == -1){
                    a = i;
                }
                else{
                    min = Math.min(min, Math.abs(i - b));
                    a = i;
                    b = -1;
                }

            }

            if(array[i].equals(target)){
                if(a == -1){
                    b = i;
                }
                else{
                    min = Math.min(min, Math.abs(a - i));
                    a = -1;
                    b = i;
                }

            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
