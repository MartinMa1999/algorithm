package crossTrainingI;

public class Move0sToEndII {
    public int[] move(int[] array){
        if(array == null || array.length == 0){
            return array;
        }

        int i = 0;
        int j = 0;
        while(j < array.length){
            if(array[j] != 0){
                array[i++] = array[j++];
            }
            else{
                j++;
            }
        }
        for(; i < array.length; i++){
            array[i] = 0;
        }
        return array;
    }
}
