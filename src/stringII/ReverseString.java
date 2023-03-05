package stringII;

public class ReverseString {
    // assume the given string is not null
    public String reverse(String s){
        if(s.length() == 0){
            return s;
        }

        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            swap(array, i, j);
            i++;
            j--;
        }

        return new String(array);
    }
    private void swap(char[] array, int i, int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
