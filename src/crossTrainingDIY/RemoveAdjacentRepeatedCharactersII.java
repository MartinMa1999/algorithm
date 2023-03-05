package crossTrainingDIY;

public class RemoveAdjacentRepeatedCharactersII {
    public String deDup(String input) {
        if(input == null || input.length() <= 2){
            return input;
        }
        char[] array = input.toCharArray();
        int i = 2;
        int j = 2;
        while(j < array.length){
            if(array[j] != array[i - 2]){
                array[i++] = array[j++];
            }
            else{
                while(j < array.length && array[j] == array[i - 2]){
                    j++;
                }
            }
        }
        return new String(array, 0, i);
    }
}
