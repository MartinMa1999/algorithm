package leetCode;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    // leetcode 28
    public int strStr(String haystack, String needle) {
        if(haystack == null && needle == null){
            return 0;
        }
        if(haystack == null || needle == null){
            return -1;
        }
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }

        char start = needle.charAt(0);
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == start){
                int count = 1;
                for(int j = 1; j < needle.length() && j + i < haystack.length(); j++){
                    if(needle.charAt(j) != haystack.charAt(j + i)){
                        break;
                    }
                    count++;
                }
                if(count == needle.length()){
                    return i;
                }
            }
        }

        return -1;



    }
}
