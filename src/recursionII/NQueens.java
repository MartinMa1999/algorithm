package recursionII;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    //Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
    public List<List<Integer>> nQueens(int n){
        List<List<Integer>> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        findAll(list ,result, n);
        return result;
    }
    private void findAll(List<Integer> list,  List<List<Integer>> result, int n){
        if(list.size() == n){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < n; i++){
            if(valid(list, n)){
                list.add(n);
                findAll(list, result, n);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> list, int n){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == n){
                return false;
            }
            if(Math.abs(n - list.get(i)) == Math.abs(list.size() - i)){
                return false;
            }
        }

        return true;
    }
}
