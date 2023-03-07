package leetCode;

public class ZigzagConversion {
    // 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列
    // P   A   H   N
    // A P L S I I G
    // Y   I   R
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        ZigzagConversion test = new ZigzagConversion();
        test.convert(s, 3);
    }
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0){
            return s;
        }
        int r = numRows;
        int length = s.length();

        if(r == 1 || r >= length){
            return s;
        }

        StringBuilder sb= new StringBuilder();
        int t = 2 * r - 2;
        for(int i = 0; i < r; i++){// 遍历每一行
            for(int j = 0; j < length - i; j += t){ // j表示每一个循环的第一个字母对应的index，之所以是j < length - i是因为要保证 i + j 不超界
                sb.append(s.charAt(i + j));
                if(i > 0 && i < r - 1 && t + j - i < length){ // j + t - i 就是同一个循环里对应的下一个字母
                    sb.append(s.charAt(j + t - i));
                }
            }

        }
        return sb.toString();
    }

    public String myWay(String s, int numRows) { // my own way
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = 2 * numRows - 2;
        for(int i = 0;  i < numRows; i++){
            if(i == 0 || i == numRows - 1){
                for(int j = i; j < s.length(); j += n){
                    sb.append(s.charAt(j));
                }
            }
            else{
                for(int j = i; j < s.length(); j += n){
                    sb.append(s.charAt(j));
                    if(j + n - 2 * i < s.length()){
                        sb.append(s.charAt(j + n - 2 * i));
                    }
                }
            }
        }

        return sb.toString();
    }
}
