package string;

public class AddBinary {
    // Given two binary strings, return their sum (also a binary string).

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int val = 0;
        while(i >= 0 || j >= 0 || val != 0){
            if(i >= 0){
                if (a.charAt(i) == '1'){
                    val += 1;
                }
                i--;
            }
            if(j >= 0){
                if(b.charAt(j) == '1'){
                    val += 1;
                }
                j--;
            }

            if(val == 0 && (i >= 0 || j >= 0)){
                sb.append('0');
            }
            else{
                if(val == 1){
                    sb.append('1');
                    val = 0;
                }
                else if(val == 2){
                    sb.append('0');
                    val = 1;
                }
                else{
                    sb.append('1');
                    val = 1;
                }
            }
        }

        String result = sb.toString();
        return reverse(result);
    }
    private String reverse(String s){
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
        return new String(array);
    }
}
