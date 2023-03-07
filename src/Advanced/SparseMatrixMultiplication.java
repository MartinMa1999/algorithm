package Advanced;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication {

    // Given two sparse matrices A and B, return the result of AB.

    public int[][] multiply(int[][] A, int[][] B) {
        Map<Integer, Map<Integer, Integer>> map1 = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> map2 = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            map1.put(i, new HashMap<>());
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] != 0){
                    map1.get(i).put(j, A[i][j]);
                }
            }
        }

        for(int i = 0; i < B.length; i++){
            for(int j = 0; j < B[0].length; j++){
                if(! map2.containsKey(j)){
                    map2.put(j, new HashMap<>());
                }
                if(B[i][j] != 0){
                    map2.get(j).put(i, B[i][j]);
                }
            }
        }

        int[][] result = new int[A.length][B[0].length];
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                Map<Integer, Integer> tmp1 = map1.get(i);
                Map<Integer, Integer> tmp2 = map2.get(j);
                for(int k : tmp1.keySet()){
                    if(tmp2 != null && tmp2.containsKey(k)){
                        result[i][j] += tmp1.get(k) * tmp2.get(k);
                    }
                }
            }
        }
        return result;

    }
}
