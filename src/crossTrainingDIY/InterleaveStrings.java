package crossTrainingDIY;

public class InterleaveStrings {
    // Given three strings A, B and C.
    // Determine if C can be created by merging A and B in a way that maintains the relative order of the characters in A and B.
    public boolean canMerge(String a, String b, String c) {
        if(a.length() == 0 && b.length() == 0 && c.length() == 0){
            return true;
        }
        if(a.length() + b.length() != c.length()){ // 题目要求必须是刚好merge成c，所以长度和必须相等
            return false;
        }
        boolean[][] helper = new boolean[a.length() + 1][b.length() + 1];
        for(int i = 0; i < helper.length; i++){
            for(int j = 0; j < helper[0].length; j++){
                if(i != 0 || j != 0){
                    int num = i + j - 1;
                    if(i > 0 && a.charAt(i - 1) == c.charAt(num) || j > 0 && b.charAt(j - 1) == c.charAt(num)){
                        if(num == 0){
                            helper[i][j] = true;
                        }
                        else{
                            if(i > 0 && helper[i - 1][j] || j > 0 && helper[i][j - 1]){
                                helper[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return helper[helper.length - 1][helper[0].length - 1];
    }
}
