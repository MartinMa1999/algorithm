package finalExam;

public class InfiniteLoopAroundTable {
    // swap swap
    public boolean canSitAsLoop(String[] array){
        if(array == null || array.length == 0){
            return false;
        }
        return helper(array, 1);
    }
    private boolean helper(String[] array, int index){
        if(index == array.length){
            return canSit(array[index - 1], array[0]);
        }

        for(int i = index; i < array.length; i++){
            if(canSit(array[index - 1], array[i])){
                swap(array, index, i);
                if(helper(array, index + 1)){
                    return true;
                }
                swap(array, index, i);
            }
        }

        return false;
    }
    private boolean canSit(String s1, String s2){
        return s1.charAt(s1.length() - 1) == s2.charAt(0);
    }
    private void swap(String[] array, int i, int j){
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
