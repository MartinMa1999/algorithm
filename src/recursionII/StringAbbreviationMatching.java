package recursionII;

public class StringAbbreviationMatching {
    public boolean matching(String input, String pattern){
        // assume input and pattern cannot be null
        if(input.length() == 0 && pattern.length() == 0){
            return true;
        }
        if(input.length() == 0 || pattern.length() == 0){
            return false;
        }

        return match(input, pattern, 0, 0);
    }
    private boolean match(String input, String pattern, int i, int j){
        if(i == input.length() && j == pattern.length()){
            return true;
        }

        if(i >= input.length() || j >= pattern.length()){
            return false;
        }

        if(Character.isDigit(pattern.charAt(j))){
            int sum = 0;
            while(j < pattern.length() && Character.isDigit(pattern.charAt(j))){
                sum += sum * 10 + pattern.charAt(j) - '0';
                j++;
            }
            return match(input, pattern, i + sum, j);
        }
        else{
            if(pattern.charAt(j) != input.charAt(i)){
                return false;
            }

            return match(input ,pattern, i + 1, j + 1);
        }


    }
}
