package crossTrainingDIY;

public class RemoveAdjacentRepeatedCharactersIII {
    public String deDup(String input) {
        if(input == null || input.length() <= 1){
            return input;
        }
        char[] array = input.toCharArray();
        int i = 1;
        int j = 1;
        while(j < array.length){
            if(i == 0){// bug, 如果不判断的话，下面的i - 1可能超界
                array[i++] = array[j++];
            }
            else if(array[j] != array[i - 1]){
                array[i++] = array[j++];
            }
            else{
                while(j < array.length && array[j] == array[i - 1]){
                    j++;
                }
                i--;
            }
        }
        return new String(array, 0, i);
    }
}
