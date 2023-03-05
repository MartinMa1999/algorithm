package DPIII;

public class LargestSquareOfMatches {
    public int largest(int[][] matrix){
        int[][] row = new int[matrix.length][matrix[0].length];
        int[][] col = new int[matrix.length][matrix[0].length];

        int globalMax = 0;
        //因为我只知道往右和往下有没有，所以只能算出来往左和往上的情况，因此从右下角开始遍历
        //当遇到值为3的时候，说明这个点可以往右下走，此时去刚才遍历过来的表里面找就可以
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 0; j--){
                if(matrix[i][j] == 1 || matrix[i][j] == 3) {
                    row[i][j] = row[i][j + 1] + 1;
                }
                if(matrix[i][j] == 2 || matrix[i][j] == 3){
                    col[i][j] = col[i + 1][j] + 1;
                }
                if(matrix[i][j] == 3){
                    int tmp = Math.min(row[i][j], col[i][j]);
                    while(tmp > 0){
                        if(row[i + tmp][j] >= tmp && col[i][j + tmp] >= tmp){//因为他这个是按点来的，所以不需要减一
                            globalMax = Math.max(globalMax, tmp);
                            break;
                        }
                        tmp--;
                    }
                }
            }
        }
        return globalMax;
    }
}
