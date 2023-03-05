package DFSII;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomMaze {
    public int[][] generateMaze(int n){
        if(n <= 1){
            return new int[][]{};
        }
        int[][] maze = new int[n][n];
        for(int[] array : maze){
            Arrays.fill(array, 1);
        }
        maze[0][0] = 0;
        generate(maze, 0, 0);
        return maze;
    }
    private void generate(int[][] maze, int x, int y){
        Dir[] Dirs = Dir.values();
        shuffle(Dirs);
        for(Dir dir : Dirs){
            if(valid(maze, dir, x, y)){
                x = x + dir.getX();
                y = y + dir.getY();
                maze[x][y] = 0;
                generate(maze, x, y);
            }
        }
    }
    private void shuffle(Dir[] dirs){
        for(int i = 0; i < dirs.length; i++){
            Random random = new Random();
            int index = random.nextInt(dirs.length - i) + i;
            swap(dirs, i, index);
        }
    }
    private void swap(Dir[] dirs, int i, int j){
        Dir tmp = dirs[i];
        dirs[i] = dirs[j];
        dirs[j] = tmp;
    }
    private boolean valid(int[][] maze, Dir dir, int x, int y){
        x += dir.getX();
        y += dir.getY();
        if(x < 0 || x > maze.length || y < 0 || y > maze.length){
            return false;
        }

        int count = 0;
        for(int m = x - 1; m < maze.length && m <= x + 1; m += 2){
            if(maze[m][y] == 0){
                count++;
            }
        }
        for(int n = y - 1; n < maze.length && n <= y + 1; n += 2){
            if(maze[x][n] == 0){
                count++;
            }
        }
        return count == 1;
    }
}
enum Dir{
    North(0, 1),
    South(0, -1),
    East(1, 0),
    West(-1, 0);
    private final int x;
    private final int y;
    private Dir(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int  getY(){
        return this.y;
    }
}
