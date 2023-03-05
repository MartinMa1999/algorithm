package stringII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    //返回target的同素异形体的首位index
    //assume input cannot be null
    public List<Integer> allAnagrams(String sh, String lo){
        List<Integer> list = new ArrayList<>();
        if(sh.length() > lo.length()){
            return list;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < sh.length(); i++){
            map.put(sh.charAt(i), map.getOrDefault(sh.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = sh.length() - 1;
        while(j < lo.length()){
            if(j == sh.length() - 1){
                for(int k = 0; k <= j; k++){
                    if(map.containsKey(lo.charAt(k))){
                        map.put(lo.charAt(k), map.get(lo.charAt(k)) - 1);
                    }
                }
            }
            int count = 0;
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue() == 0){
                    count++;
                }
            }
            if(count == map.size()){
                list.add(i);
            }
            //sliding window move
            if(map.containsKey(lo.charAt(i))){
                map.put(lo.charAt(i), map.get(lo.charAt(i)) + 1);
            }
            i++;
            if(j + 1 < lo.length() && map.containsKey(lo.charAt(j + 1))){
                map.put(lo.charAt(j + 1), map.get(lo.charAt(j + 1)) - 1);
            }
            j++;
        }
        return list;
    }
}
