package string;

public class ValidAnagram {
    // Given two strings s and t, write a function to determine if t is an anagram of s.

    public boolean isAnagram(String source, String target) {
        if(source == null && target == null){
            return true;
        }
        if(source == null || target == null){
            return false;
        }
        if(source.length() == 0 && target.length() == 0){
            return true;
        }
        if(source.length() != target.length()){
            return false;
        }

        int[] array = new int[26];
        int count = 0;
        for(int i = 0; i < source.length(); i++){
            int tmp = source.charAt(i) - 'a';
            array[tmp]++;
            count++;
        }
        for(int i = 0; i < target.length(); i++){
            int tmp = target.charAt(i) - 'a';
            if(array[tmp] == 0){
                return false;
            }
            array[tmp]--;
            count--;
            if(array[tmp] == 0){
                if(count == 0){
                    return true;
                }
            }
        }

        return false;
    }
}
