package string;

public class ValidPalindrome {
    // Given a string, determine if it is a palindrome, considering only alphanumeric characters('0'-'9','a'-'z','A'-'Z') and ignoring cases.
    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        test.valid(new String("FQJKY$jB3Qd-fSOUAI`^iAUOSfdQ3BjyKJQF"));
    }

    public boolean valid(String input) {
        if(input == null || input.length() == 0){
            return true;
        }

        int i = 0;
        int j = input.length() - 1;

        while(i < j){
            if(! valid(i, input)){
                i++;
            }
            else if(! valid(j, input)){
                j--;
            }
            else{
                if(input.charAt(i) != input.charAt(j) && Math.abs(input.charAt(i) - input.charAt(j)) != 32){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean valid(int i, String input){
        int tmp = (int)input.charAt(i);
        return (tmp >= 48 && tmp <= 57) || (tmp >= 65 && tmp <= 90) || (tmp >= 97 && tmp <= 122);
    }
}
