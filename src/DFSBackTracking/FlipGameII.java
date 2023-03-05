package DFSBackTracking;

import java.util.ArrayList;
import java.util.List;

public class FlipGameII {
    // Write a function to determine if the starting player can guarantee a win.

    //难点在于，对于A和B两个玩家来说，一定获胜的情况是不同的。当轮到A的时候，就是A只要有一个结果是一定赢就可以；当轮到B的时候，无论B怎么走，A都应才可以。
    public boolean canWin(String input) {
        if(input == null || input.length() <= 1){
            return false;
        }

        return findAll(input, 0);
    }
    private boolean findAll(String input, int level){
        char[] array = input.toCharArray();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == '+' && array[i + 1] == '+'){
                array[i] = '-';
                array[i + 1] = '-';
                list.add(new String(array));
                array[i] = '+';
                array[i + 1] = '+';
            }
        }
        if(list.isEmpty()){
            return level % 2 != 0;
        }

        if(level % 2 == 0){ // 考虑当A走的时候，只要A有一种走法一定赢就可以了
            boolean visited = false;
            for(String s : list){
                if(findAll(s, level + 1)){
                    visited = true;
                }
            }
            return visited;
        }

        for(String s : list){ // 考虑当B走的时候，此时无论B怎么走，都得是A赢，才能保证A一定获胜
            if(! findAll(s, level + 1)){
                return false;
            }
        }
        return true;
    }
}
