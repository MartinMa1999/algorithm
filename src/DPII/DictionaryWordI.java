package DPII;

public class DictionaryWordI {
    //Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.
    //切字符串，要求各部分都是在词典里的
    public boolean dictionaryWord(String input, String[] dict){
        //assume input and dict cannot be null and length > 0
        boolean[] helper = new boolean[input.length() + 1];//表示长度为i的input是否满足条件
        helper[0] = true;//保证一刀不切的时候只需要判断右边
        for(int i = 1; i < input.length(); i++){
            for(int j = 0; j < i; j++){
                if(helper[j] && contains(dict, input.substring(j, i))){
                    helper[i] = true;
                    break;
                }
            }
        }
        return helper[helper.length - 1];
    }
    private boolean contains(String[] dict, String target){
        for (String s : dict) {
            if (s.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
