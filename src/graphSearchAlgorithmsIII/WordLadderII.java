package graphSearchAlgorithmsIII;

import java.util.*;

public class WordLadderII {
    // Given a beginning word, an end word and a dictionary, find the least number transformations from begin word to end word,
    // and return the transformation sequences. Return empty list if there is no such transformations.
    public static void main(String[] args) {
        String a =  "red";
        String b = "tax";
        List<String> dict = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");
        WordLadderII test = new WordLadderII();
        test.findLadders(a, b, dict);
    }

    public List<List<String>> findLadders(String begin, String end, List<String> dict){
        // assume input string cannot be null and length > 0
        Map<String, List<String>> map = new HashMap<>();//存反着指的map，方便在做完bfs之后做dfs
        Queue<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        queue.offer(begin);
        set.add(begin);//必须一开始放进去，因为是依据set里面有没有元素来判断的，否则会循环走回来

        breakpoint1:
        while(! queue.isEmpty()){
            int size = queue.size();
            Set<String> tmpSet = new HashSet<>();
            while(size > 0) {
                String tmp = queue.poll();
                if (tmp.equals(end)) {
                    break breakpoint1;
                }
                char[] array = tmp.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    char tmpLetter = array[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != tmpLetter) {
                            array[i] = c;
                            String newString = new String(array);
                            if (dict.contains(newString) && !set.contains(newString)) {
                                if (!map.containsKey(newString)) {
                                    map.put(newString, new ArrayList<>());
                                    queue.offer(newString);//必须是第一次来才能加进去，否则如果一轮里面两次碰到，就会加两次
                                }
                                map.get(newString).add(tmp);
                                tmpSet.add(newString);

                            }
                        }
                    }
                    array[i] = tmpLetter;//记得最后要变回来！！
                }
                size--;
            }
            set.addAll(tmpSet);
        }
        if(! set.contains(end)){//有可能没找到
            return result;
        }

        List<String> list = new ArrayList<>();
        findAll(map, list, result, end);
        return result;
    }
    private void findAll(Map<String, List<String>> map ,List<String> list, List<List<String>> result, String root){
        if(! map.containsKey(root)){
            list.add(root);
            result.add(reverse(new ArrayList<>(list)));
            list.remove(list.size() - 1);
            return;
        }

        list.add(root);
        for(String s : map.get(root)){
            findAll(map, list, result, s);
        }
        list.remove(list.size() - 1);
    }
    private List<String> reverse(List<String> list){
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            String tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
            i++;
            j--;
        }
        return list;
    }
}
