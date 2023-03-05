package string;

public class OneEditDistance {
    // Determine if two given Strings are one edit distance.
    //
    // One edit distance means you can only insert one character/delete one character/replace
    // one character to another character in one of the two given strings so that they will become identical.

    // dp里面用过2维matrix判断增删查改，这里也可以，右下的三个点一定代表增删查改之后的样子
    public boolean oneEditDistance(String source, String target) {
        if(source == null && target == null){
            return true;
        }
        if(source == null || target == null){
            return false;
        }

        if(Math.abs(source.length() - target.length()) >= 2){
            return false;
        }

        boolean[][] matrix = new boolean[source.length()][target.length()];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(source.charAt(i) == target.charAt(j)){
                    matrix[i][j] = true;
                }
            }
        }
        int i = 0;
        int j = 0;
        while(i < source.length() && j < target.length()){
            if(matrix[i][j]){
                i++;
                j++;
            }
            else{
                if(valid(i + 1, j, matrix) || valid(i, j + 1, matrix) || valid(i + 1, j + 1, matrix)){
                    return true;
                }
                return false;
            }
        }
        return source.length() != target.length(); // bug !! 如果长度相等说明两个完全一样

    }
    private boolean valid(int i, int j, boolean[][] matrix){
        while(i < matrix.length && j < matrix[0].length){
            if(! matrix[i][j]){
                return false;
            }
            i++;
            j++;
        }
        return i >= matrix.length && j >= matrix[0].length; // bug !!如果还有没走完的，就说明需要修改的超过两步，所以肯定是false
    }
}
