package personal.temp;

/**
 * Created by ctsuser on 11/8/16.
 */
public class Maze
{

    public static void main(String args[])
    {
        Maze m = new Maze();
        int i =0,j=0;
        int [][] maze = new int[][]{
                {1,1,1,1},
                {0,1,0,1},
                {0,1,1,1}
        };

        m.solveMaze(maze);
    }

    int solveMaze(int [][] m)
    {
        int sol[][] = new int[m.length][m[0].length];

        if(solveMazeUtil(m,0,0,sol) == 0)
        {
            System.out.print("inside if -- no path");
            return 0;
        }
        System.out.print("outside if --  path");
        print(sol);
        return 1;

    }

    void print(int sol[][])
    {
        System.out.print("inside print ");
        for (int i=0;i<sol.length;i++)
        {
            for(int j=0;j<sol[0].length;j++)
                System.out.print(sol[i][j]);
        }
    }

    int solveMazeUtil(int [][] m ,int x,int y, int[][] sol) {
        int rowLength = m.length - 1;
        int colLength = m[0].length - 1;
        if (x == m.length - 1 && y == m[0].length - 1)
            sol[x][y] = 1;//found exit

        if (isSafe(m, x, y, sol) == 1) {
            sol[x][y] = 1;

            if (solveMazeUtil(m, x + 1, y, sol) == 1) return 1;
            if (solveMazeUtil(m, x, y + 1, sol) == 1) return 1;
            if (solveMazeUtil(m, x - 1, y, sol) == 1) return 1;
            if (solveMazeUtil(m, x, y - 1, sol) == 1) return 1;
            sol[x][y] = 0;
            return 0;
        }
        return 0;
    }



/*
    i = row
    j=column
    1 - ground
    0 - wall
 */
    int isSafe(int[][] maze,int i,int j,int [][] path)
    {
        int rowLength = maze.length -1;
        int colLength = maze[0].length -1;
        if(i >=0 && i <rowLength && j >=0 && j< colLength && maze[i][j] == 1  && path[i][j] != 1)
        {
            return 1;
        }
        return 0;

    }



}
