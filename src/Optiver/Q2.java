package Optiver;

import java.util.*;

public class Q2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");
        if(! valid(array)){
            System.out.println("E1");
        }
        else{
            String result = checkTree(array);
            System.out.println(result);
        }

    }

    private static boolean valid(String[] array){
        for(String s : array){
            if(s.length() != 5){
                return false;
            }
            if(s.charAt(0) != '(' || s.charAt(2) != ',' || s.charAt(4) != ')'){
                return false;
            }
            if(s.charAt(1) < 'A' || s.charAt(1) > 'Z' || s.charAt(3) < 'A' || s.charAt(3) > 'Z'){
                return false;
            }
        }
        return true;
    }

    private static String checkTree(String[] array){
        Map<Character, PriorityQueue<Character>> map = new HashMap<>();
        boolean[] hasRoots = new boolean[26];
        Set<Character> set = new HashSet<>();
        char start = 'Z';
        for(String s : array){
            char parent = s.charAt(1);
            char child = s.charAt(3);
            if(hasRoots[child - 'A']){
                return "E5";
            }
            if(! map.containsKey(parent)){
                map.put(parent, new PriorityQueue<Character>());
            }
            if(map.get(parent).contains(child)){
                return "E2";
            }
            if(map.get(parent).size() == 2){
                return "E3";
            }
            map.get(parent).offer(child);
            set.add(parent);
            set.add(child);
            hasRoots[child - 'A'] = true;
            if(start - parent > 0){
                start = parent;
            }
        }
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        stack.offerFirst(start);
        sb.append('(');
        sb.append(start);
        set.remove(start);
        while(! stack.isEmpty()){
            if(! map.containsKey(start) || map.get(start).isEmpty()){
                sb.append(')');
                stack.pollFirst();
                if(stack.isEmpty()){
                    break;
                }
                start = stack.peekFirst();

            }
            else{
                char tmp = map.get(start).poll();
                sb.append('(');
                sb.append(tmp);
                stack.offerFirst(tmp);
                start = tmp;
            }
            set.remove(start);
        }

        if(! set.isEmpty()){
            return "E4";
        }


        return sb.toString();
    }
}
