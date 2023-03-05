package DFSBackTracking;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    // You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
    // you and your friend take turns to flip two consecutive "++" into "--".
    // The game ends when a person can no longer make a move and therefore the other person will be the winner.

    // Write a function to compute all possible states of the string after one valid move.

    public List<String> generatePossibleNextMoves(String input) {
        List<String> result = new ArrayList<>();
        if(input == null || input.length() <= 1){
            return result;
        }

        char[] array = input.toCharArray();
        for(int i = 0; i + 1 < array.length; i++){
            if(array[i] == '+' && array[i + 1] == '+'){
                array[i] = '-';
                array[i + 1] = '-';
                result.add(new String(array));
                array[i] = '+';
                array[i + 1] = '+';
            }
        }
        return result;
    }
}
