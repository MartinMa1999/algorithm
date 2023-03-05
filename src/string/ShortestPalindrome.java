package string;

public class ShortestPalindrome {
    // Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
    // Find and return the shortest palindrome you can find by performing this transformation.

    // 每次都想象往前面加k个元素，则从0 - input.length() - 1 - k一定是个palindrome

    public String shortestPalindrome(String input) {
        if(input == null || input.length() == 0){
            return input;
        }
        int tmp = 0;
        for(int i = input.length() - 1; i > 0; i--){
            if(isPalindrome(input, 0, i)){
                tmp = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = input.length() - 1; i > tmp; i--){
            sb.append(input.charAt(i));
        }

        return sb.toString() + input;
    }
    private boolean isPalindrome(String input, int i, int j){
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
