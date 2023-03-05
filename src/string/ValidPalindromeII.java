package string;

public class ValidPalindromeII {

    // Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

    public boolean validPalindrome(String input) {
        if(input == null || input.length() == 0){
            return true;
        }

        int i = 0;
        int j = input.length() - 1;
        boolean visited = false;
        while(i < j){
            if(input.charAt(i) == input.charAt(j)){
                i++;
                j--;
            }
            else{
                if(visited){
                    return false;
                }

                if(j - i == 1){
                    i++;
                    j--;
                }
                else if(input.charAt(i + 1) == input.charAt(j) && input.charAt(j - 1) == input.charAt(i)){//考虑不知道怎么走，就都走一下试试
                    return valid(i + 1, j, input) || valid(i, j - 1, input);
                }
                else if(input.charAt(i + 1) == input.charAt(j)){
                    i++;
                    visited = true;
                }
                else if(input.charAt(j - 1) == input.charAt(i)){
                    j--;
                    visited = true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    private boolean valid(int i, int j, String input){
        while(i < j){
            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
