package graphSearchAlgorithmsIII;

import java.util.*;

public class WordLadder {
    //Given a beginning word, an end word and a dictionary, find the least number transformations from begin word to end word,
    //and return the length of the transformation sequence. Return 0 if there is no such transformations.

    public int findLeast(String begin, String end, List<String> dict){
        //assume begin and end are both in list
        Queue<String> queue = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        queue.offer(begin);
        map.put(begin, 1);
        if(begin.equals(end)){
            return 1;
        }

        while (! queue.isEmpty()){
            String tmp = queue.poll();
            char[] array = tmp.toCharArray();
            for(int i = 0; i < array.length; i++){
                char tmpWord = array[i];
                for(char c = 'a'; c <= 'z'; c++){
                    if(c != tmpWord){
                        array[i] = c;
                        String newWord = new String(array);
                        if(dict.contains(newWord) && !map.containsKey(newWord)){
                            if(newWord.equals(end)){
                                return map.get(tmp) + 1;
                            }
                            queue.offer(newWord);
                            map.put(newWord, map.get(tmp) + 1);
                        }
                    }
                }
                array[i] = tmpWord;
            }
        }
        return 0;
    }
}
