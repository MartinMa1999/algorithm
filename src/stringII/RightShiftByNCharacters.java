package stringII;

public class RightShiftByNCharacters {
    // require in-place move
    public String rightShift(String s, int n){
        if(s == null || s.length() == 0 || n <= 0){
            return s;
        }
        //相当于把左边这么多个char移到右边去
        int realNum = n % s.length();
        char[] array = s.toCharArray();
        reverse(array, 0, realNum - 1);
        reverse(array, realNum, array.length - 1);
        reverse(array, 0, array.length - 1);

        return new String(array);
    }
    private void reverse(char[] array, int i, int j){
        while(i < j){
            char tmp = array[i];
            array[i++] = array[j];
            array[j--] = tmp;
        }
    }
}
