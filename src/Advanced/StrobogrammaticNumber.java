package Advanced;

public class StrobogrammaticNumber {
    // A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
    //
    //Write a function to determine if a number is strobogrammatic. The number is represented as a string.

    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0){
            return false;
        }
        int i = 0;
        int j = num.length() - 1;
        while(i < j){
            if(num.charAt(i) == '6' && num.charAt(j) == '9'){
                i++;
                j--;
            }
            else if(num.charAt(i) == '9' && num.charAt(j) == '6'){
                i++;
                j--;
            }
            else if(num.charAt(i) == '1' && num.charAt(j) == '1'){
                i++;
                j--;
            }
            else if(num.charAt(i) == '8' && num.charAt(j) == '8'){
                i++;
                j--;
            }
            else if(num.charAt(i) == '0' && num.charAt(j) == '0'){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        if(i == j){
            return num.charAt(i) == '1' || num.charAt(i) == '8' || num.charAt(i) == '0';
        }
        return true;
    }
}
