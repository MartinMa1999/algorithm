package crossTrainingIV;

import java.util.ArrayList;
import java.util.List;

public class MajorNumberII {
    //Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.
    public List<Integer> findAll(int[] array){
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for (int j : array) {
            if (j == candidate1 && count1 > 0) {//如果先判断count的大小，就有可能两个一样的数放到两个空里面
                count1++;
            } else if (j == candidate2 && count2 > 0) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = j;
                count1++;
            } else if (count2 == 0) {
                candidate2 = j;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        int tmp1 = 0;
        int tmp2 = 0;
        for(int i : array){
            if (i == candidate1 && count1 > 0){
                tmp1++;
            }
            if(i == candidate2 && count2 > 0){
                tmp2++;
            }
        }

        if(tmp1 > array.length/ 3){
            result.add(tmp1);
        }
        if(tmp2 > array.length / 3){
            result.add(tmp2);
        }

        return result;
    }
}
