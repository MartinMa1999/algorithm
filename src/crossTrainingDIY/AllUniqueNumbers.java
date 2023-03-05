package crossTrainingDIY;

public class AllUniqueNumbers {
    public boolean allUnique(String word){
        int x = 0;
        for(int i = 0; i < word.length(); i++){
            int tmp = word.charAt(i) - 'a';
            if(((x >> tmp) & 1) == 1){
                return false;
            }
            else {
                x |= (1 << tmp);
            }
        }
        return true;
    }
}
