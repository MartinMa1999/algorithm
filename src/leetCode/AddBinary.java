package leetCode;

public class AddBinary {
    // leetcode 67
    // Given two binary strings a and b, return their sum as a binary string.

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        addBinary.addBinary("11", "1");
    }
    public String addBinary(String a, String b) {
        String tmp1 = reverse(a);
        String tmp2 = reverse(b);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int value = 0;
        while(i < a.length() || i < b.length() || value != 0){
            if(i < a.length()){
                value += tmp1.charAt(i) - '0';
            }

            if(i < b.length()){
                value += tmp2.charAt(i) - '0';
            }

            if(value < 2){
                sb.append(value); // bug!StringBuilder可以直接加数字
                value = 0;
            }
            else{
                sb.append(value % 2);  // bug! 进制必须用%和/进行计算
                value /= 2;
            }
            i++;
        }

        String s = sb.toString();
        return reverse(s);
    }

    private String reverse(String s){
        char[] tmp = s.toCharArray();
        int left = 0;
        int right = tmp.length - 1;
        while(left < right){
            char c = tmp[left];
            tmp[left] = tmp[right];
            tmp[right] = c;
            left++;
            right--;
        }

        return new String(tmp);
    }
}
