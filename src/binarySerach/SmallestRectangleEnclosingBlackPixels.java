package binarySerach;

import java.util.*;

public class SmallestRectangleEnclosingBlackPixels {
    // An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
    // he black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically.
    // Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle
    // that encloses all black pixels.
    public static void main(String[] args) {
        SmallestRectangleEnclosingBlackPixels test = new SmallestRectangleEnclosingBlackPixels();
        test.binarySearch(new int[][]{{1}}, 0, 0);
    }

    public int minArea(int[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0){
            return 0;
        }
        int up = x;
        int down = x;
        int left = y;
        int right = y;
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(Arrays.asList(x, y));
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[x][y] = true;
        while(! queue.isEmpty()){
            List<Integer> tmp = queue.poll();
            up = Math.min(tmp.get(0), up);
            down = Math.max(tmp.get(0), down);
            left = Math.min(tmp.get(1), left);
            right = Math.max(tmp.get(1), right);


            List<List<Integer>> list = findAll(tmp, visited, image);
            for(List<Integer> newPoint : list){
                queue.offer(newPoint);
                visited[newPoint.get(0)][newPoint.get(1)] = true;
            }
        }


        return (down - up + 1) * (right - left + 1);
    }
    private List<List<Integer>> findAll(List<Integer> tmp, boolean[][] visited, int[][] matrix){
        List<Integer> list = null;
        List<List<Integer>> result = new ArrayList<>();
        int x = tmp.get(0);
        int y = tmp.get(1);
        if(x - 1 >= 0 && matrix[x - 1][y] == 1 && ! visited[x - 1][y]){
            list = Arrays.asList(x - 1, y);
            result.add(new ArrayList<>(list));
        }
        if(x + 1 < matrix.length && matrix[x + 1][y] == 1 && ! visited[x + 1][y]){
            list = Arrays.asList(x + 1, y);
            result.add(new ArrayList<>(list));
        }
        if(y - 1 >= 0 && matrix[x][y - 1] == 1 && ! visited[x][y - 1]){
            list = Arrays.asList(x, y - 1);
            result.add(new ArrayList<>(list));
        }
        if(y + 1 < matrix[0].length && matrix[x][y + 1] == 1 && ! visited[x][y + 1]){
            list = Arrays.asList(x, y + 1);
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    public int binarySearch(int[][] image, int x, int y){
        int width = findLeft(image, y);
        int height = findup(image, x);

        return width * height;
    }
    private int findLeft(int[][] image, int y){
        int left = -1;
        breakpoint:
        for(int i = 0; i <= y; i++){
            for(int j = 0; j < image.length; j++){
                if(image[j][i] == 1){
                    left = i;
                    break breakpoint;
                }
            }
        }

        int right = -1;
        breakpoint:
        for(int i = image[0].length  - 1; i >= y; i--){
            for(int j = 0; j < image.length; j++){
                if(image[j][i] == 1){
                    right = i;
                    break breakpoint;
                }
            }
        }

        return right - left + 1;
    }

    private int findup(int[][] image, int x){
        int up = -1;
        breakpoint:
        for(int i = 0; i <= x; i++){
            for(int j = 0; j < image[0].length; j++){
                if(image[i][j] == 1){
                   up = i;
                   break breakpoint;
                }
            }
        }
        int down = -1;
        breakpoint:
        for(int i = image.length - 1; i >= x; i--){
            for(int j = 0; j < image[0].length; j++){
                if(image[i][j] == 1){
                    down = i;
                    break breakpoint;
                }
            }
        }

        return down - up + 1;
    }
}
