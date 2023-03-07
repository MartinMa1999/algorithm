package Advanced;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    // Write a function to generate the generalized abbreviations of a word.
    //
    //Example:
    //
    //Given word = "word", return the following list (order does not matter):
    //
    //["word", "1ord", "w1rd", "wo1d", "wor1", "2rd",
    //"w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2",
    //"2r1", "3d", "w3", "4"]

    // 相当于每次都先无脑加字母，然后再判断一下前面那个是不是数字，如果是数字就不能再加数字
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        if(word == null || word.length() == 0){
            result.add(word);
            return result;
        }

        findAll(word, 0, "", result);
        return result;
    }
    private void findAll(String word, int index, String s, List<String> result){
        if(index == word.length()){
            result.add(s);
            return;
        }

        findAll(word, index + 1, s + word.charAt(index), result);
        int length = s.length();
        if(index - 1 >= 0 && s.charAt(length - 1) > '0' && s.charAt(length - 1) <= '9'){ // 因为前面已经加过字母了，所以用这个判断可不可以加数字
            return;
        }
        for(int i = index; i < word.length(); i++){
            findAll(word, i + 1, s + (i - index + 1), result);
        }

    }
}
