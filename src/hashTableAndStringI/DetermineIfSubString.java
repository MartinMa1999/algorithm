package hashTableAndStringI;

public class DetermineIfSubString {
    //Determine if a small string is a substring of another large string
    //Return the index of the first occurrence of the small string in the large string
    public int isSubStringOrNot(String large, String small){
        if(large == null || small == null || small.length() > large.length()){
            return -1;
        }

        if(small.length() == 0){
            return 0;
        }
        for(int i = 0; i < large.length(); i++){
            for(int j = 0; j < small.length(); j++){
                if(large.charAt(i) != small.charAt(j)){
                    break;
                }

                if(j == small.length() - 1){
                    return i;
                }
            }
        }

        return -1;
    }
}
