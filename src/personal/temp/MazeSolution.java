package personal.temp;

/**
 * Created by ctsuser on 11/9/16.
 */
public class MazeSolution {
    public static void main(String args[]) {
        int[][] maze = new int[][]{
                {1, 0, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        MazeSolution obj = new MazeSolution();
        int[][] sol =new int[maze.length][maze[0].length];
        if(obj.mazeTraversal(maze,0,0,sol))
        {
            System.out.println("Final...");
            obj.print(sol);
        }

    }


    boolean mazeTraversal(int[][] m,int row,int col,int[][] sol){

        print(sol);

        System.out.println("Row :"+row +" Col"+col);
        boolean pathExist = false;
        if(row == m.length - 1 && col ==m[0].length -1)
        {
            sol[row][col] = 1;
            return true;
        }
        if(isSafe(m,row,col,sol)){

            sol[row][col] = 1;
            if(mazeTraversal(m,row+1,col,sol)) return true;//down
            if(mazeTraversal(m,row,col+1,sol)) return true;//right
            if(mazeTraversal(m,row-1,col,sol)) return true;//up
            if(mazeTraversal(m,row,col-1,sol)) return true;//left


                sol[row][col] = 0;

        }

       /* if(row >= 0 && row < m.length -1 &&
                col  >= 0 && col < m[0].length -1) {
            sol[row][col] = 0;
        }*/

     return pathExist;
    }

    boolean isSafe(int[][] m , int row , int col,int[][] sol) {
        boolean isSafe = true;
        if(row < 0 || row > m.length -1 ||
                col <0 || col > m[0].length -1 || m[row][col] == 0 || sol[row][col] == 1)
        {

             isSafe = false;
        }

        return isSafe;
    }

    void print(int sol[][])
    {
        System.out.println("inside print ");
        for (int i=0;i<sol.length;i++)
        {
            for(int j=0;j<sol[0].length;j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}