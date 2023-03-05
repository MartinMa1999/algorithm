package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    // Given an array of words and a length L, format the text such that each line has exactly L characters and is
    // fully (left and right) justified. For the last line, it should be left justified and no extra space is inserted between words.

    // 分两种情况，需要两端对齐的一行一定不是最后一行且里面的单词超过一个，需要左侧对齐的则是最后一行或者只有一个单词。特殊情况是一行的长度刚好是L，此时按照两端对齐
    // 的方法处理
    public static void main(String[] args) {
        TextJustification test = new TextJustification();
        test.fullJustify(new String[]{"This", "is", "my"}, 5);
    }
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<>();
        if(words == null || words.length == 0){
            return result;
        }
        int i = 0;
        while(i < words.length){
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            int count = 0;
            int tmp = i;
            while(sum <= L && i < words.length){
                sum += words[i].length();
                count++;
                if(count > 1){
                    sum++;
                }
                i++;
            }

            if(sum > L){
                i--;
                count--;
                sum -= words[i].length() + 1;
            }
            if((i < words.length && i - tmp > 1) || sum == L){
                int dif = L - sum;
                int space = dif / (count - 1);
                int mode = dif % (count - 1);
                boolean first = false;
                while(tmp < i){
                    sb.append(words[tmp]);
                    if(i - tmp == 1){
                        break;
                    }
                    for(int j = 0; j <= space; j++){
                        sb.append(' ');
                    }
                    if(! first){
                        first = true;
                        for(int j = 0; j < mode; j++){
                            sb.append(' ');
                        }
                    }
                    tmp++;
                }
                result.add(sb.toString());
            }
            else{
                if(count == 1){
                    sb.append(words[tmp]);
                    for(int j = 0; j < L - sum; j++){
                        sb.append(' ');
                    }
                    result.add(sb.toString());
                    continue;
                }

                while(tmp < i) {
                    sb.append(words[tmp]);
                    sb.append(' ');
                    tmp++;
                }
                int length = sb.length();
                while(length < L){
                    sb.append(' ');
                    length++;
                }
                result.add(sb.toString());
            }

        }

        return result;
    }
}
