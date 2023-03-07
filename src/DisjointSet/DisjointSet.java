package DisjointSet;

import java.util.Arrays;

public class DisjointSet {
    // only for lower-case letters
    private final int[] array;
    DisjointSet(){
        array = new int[26];
        Arrays.fill(array, -1);
    }

    public void union(int a, int b){
        int parent1 = findParent(a);
        int parent2 = findParent(b);
        if(parent1 == parent2){
            return;
        }
        else if(parent1 > parent2){
            array[parent1] = parent2;
        }
        else{
            array[parent2] = array[parent1];
        }
    }

    public int findParent(int num){
        if(array[num] < 0){
            return num;
        }
        array[num] = findParent(array[num]);

        return array[num];
    }
    
}
