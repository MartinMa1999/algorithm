package crossTrainingIV;

public class MajorNumberI {
    // Given an integer array of length L, find the number that occurs more than 0.5 * L times.
    public int majorNumber(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }

        int count = 1;
        int candidate = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] == candidate){
                count++;
            }
            else if(count == 0){
                candidate = array[i];
                count = 1;
            }
            else{
                count--;
            }
        }
        return candidate;
    }
}
