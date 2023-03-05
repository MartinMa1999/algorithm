package crossTrainingIII;

import java.util.HashMap;
import java.util.Map;

public class MostPointsOnALine {
    public int most(Point[] points){
        int result = 0;
        for(int i = 0; i < points.length; i++){
            int same = 1;
            int sameX = 0;//考虑没有斜率的点
            int most = 0;
            Map<Double, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++){
                Point tmp = points[j];
                if(i != j){
                    if(tmp.x == points[i].x && tmp.y == points[i].y){
                        same++;
                    }
                    else if(tmp.x == points[i].x){
                        sameX++;
                    }
                    else{
                        double slope = (tmp.y - points[i].y + 0.0) / (tmp.x - points[i].x);
                        map.put(slope, map.getOrDefault(slope, 0) + 1);
                        most = Math.max(most, map.get(slope));
                    }
                }
            }
            most = Math.max(same, sameX) + most;
            result = Math.max(most, result);
        }
        return result;
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