package leetCode;

public class StringCompression {
    // leetcode 443
    public int compress(char[] chars) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(j < chars.length){
            if(chars[j] == chars[k]){
                int count = 0;
                while(j < chars.length && chars[k] == chars[j]){
                    count++;
                    j++;
                }
                if(j - k == 1){
                    chars[i++] = chars[k];
                }
                else{
                    String s = Integer.toString(count);
                    chars[i++] = chars[k];
                    for(int m = 0; m < s.length(); m++){
                        chars[i++] = s.charAt(m);
                    }
                }
                k = j;
            }
        }
        return i;
    }
}
