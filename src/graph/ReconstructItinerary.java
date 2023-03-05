package graph;

import java.util.*;

public class ReconstructItinerary {
    // Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct
    // the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

    // If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    //All airports are represented by three capital letters (IATA code).
    //You may assume all tickets form at least one valid itinerary.


    //用map存顺序，然后每次验证一下取出来的是不是valid。如果取出来的是个死胡同，或者取出来的下一个是个死胡同，则判断一下此时list的长度。如果只有这一个可以拿，说明
    // 走到头了，直接拿出来；否则就先放着，拿下一个试试
    public static void main(String[] args) {
        ReconstructItinerary test = new ReconstructItinerary();
        test.findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}});
    }

    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if(tickets == null || tickets.length == 0){
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for(String[] array : tickets){
            if(! map.containsKey(array[0])){
                map.put(array[0], new ArrayList<>());
            }
            map.get(array[0]).add(array[1]);
            Collections.sort(map.get(array[0]));
        }
        List<String> helper = new ArrayList<>();
        result.add("JFK");
        String tmp = "JFK";
        while(! map.get(tmp).isEmpty()){
            List<String> list = map.get(tmp);
            String s = list.get(0);
            if(! map.containsKey(s)){
                list.remove(0);
                helper.add(s);
            }
            else if(map.get(s).isEmpty()){
                if(list.size() == 1){
                    result.add(s);
                    break;
                }
                s = list.get(1);
                if(! map.containsKey(s)){
                    list.remove(0);
                    helper.add(s);
                }
                else{
                    result.add(s);
                    list.remove(1);
                    tmp = s;
                }
            }
            else{
                list.remove(0);
                result.add(s);
                tmp = s;
            }
        }
        result.addAll(helper);
        return result;
    }
}
