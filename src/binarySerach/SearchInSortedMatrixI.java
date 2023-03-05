package binarySerach;

class SearchInSortedMatrixI {
    public int[] searchInMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{-1, -1};
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int newRow = mid / col;
            int newCol = mid % col;
            if(matrix[newRow][newCol] < target){
                left = mid + 1;
            }
            else if(matrix[newRow][newCol] == target){
                return new int[]{newRow, newCol};
            }
            else {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
