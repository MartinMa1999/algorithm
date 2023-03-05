package DPIV;

import java.util.Arrays;

public class LargestSetOfPointsWithPositiveSlope {
    // Given an array of 2D coordinates of points (all the coordinates are integers),
    // find the largest number of points that can form a set such that any pair of points in the set
    // can form a line with positive slope. Return the size of such a maximal set.
    public int findMax(Point[] points){
        if(points == null || points.length == 0){
            return -1;
        }

        Arrays.sort(points, (o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x);

        Point[] helper = new Point[points.length + 1];
        int len = 1;
        helper[len] = points[0];
        for(int i = 1; i < points.length; i++){
            if(points[i].x > helper[len].x && points[i].y > helper[len].y){
                helper[++len] = points[i];
            }
            else{
                int left = 1;
                int right = len;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    if(helper[mid].y < points[i].y){
                        left = mid + 1;
                    }
                    else{
                        right = mid;
                    }
                }
                if(len == 1 || left < len){//考虑两种情况，一种是x增大y没变，此时不能改，一种是只有一个元素，此时len = left
                    helper[left] = points[i];
                }
            }
        }
        return len == 1 ? 0 : len;
    }
}

class Point {
  public int x;
  public int y;
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}