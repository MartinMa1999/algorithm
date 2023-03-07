package leetCode;

public class FruitIntoBaskets {
    // leetcode 904

    public int totalFruit(int[] fruits) {
        if(fruits == null){
            return 0;
        }

        if(fruits.length <= 2){
            return fruits.length;
        }
        int start = 0;
        int end = 0;
        int result = 0;
        for(int i = 1; i < fruits.length; i++){
            if(fruits[i] != fruits[0]){
                end = i;
                result = i + 1;
                break;
            }
        }

        if(end == 0){
            return fruits.length;
        }
        int[][] visited = new int[2][2];
        visited[0][0] = fruits[end - 1];
        visited[0][1] = end - 1;
        visited[1][0] = fruits[end];
        visited[1][1] = end;
        for(int i = end + 1; i < fruits.length; i++){
            if(fruits[i] == visited[0][0]){
                visited[0][1] = i;
            }
            else if (fruits[i] == visited[1][0]){
                visited[1][1] = i;
            }
            else{
                result = Math.max(result, end - start + 1);
                int type = fruits[i - 1];
                if(visited[0][0] == type){
                    start = visited[1][1] + 1;
                    visited[1][0] = fruits[i];
                    visited[1][1] = i;
                }
                else{
                    start = visited[0][1] + 1;
                    visited[0][0] = fruits[i];
                    visited[0][1] = i;
                }
            }
            end = i;
        }

        return Math.max(result, end - start + 1);
    }
}
