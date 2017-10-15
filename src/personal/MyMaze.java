package personal;

/**
 * Created by ctsuser on 11/10/16.
 */
public class MyMaze {
    static int[][] maze = {
            {0,0,0,0},
            {1,0,1,0},
            {1,0,0,0}
    };


    static int numrows = 3;
    static int numcols = 4;
    static int startrow=0;
    static int startcol =0;

    static int exitrow=1;
    static int exitcol =3;

    static int shortestLength =0;

    public static void main(String args[])
    {
        int[] tempPath;
        int tempLength;
        //intializr array
        MyMaze  m = new MyMaze();
        tempPath = new int[m.numrows * m.numcols];
        for(int i = 0; i < numrows*numcols; i++)
        {
            tempPath[i] = -1;
        }

        MyMaze.shortestLength = numrows * numcols + 1;
        tempLength = 0;
        m.findPath(startrow,startcol,tempPath,tempLength);

        int finalValue = (m.shortestLength == numrows * numcols + 1) ?  -1 : (m.shortestLength -1 );

        System.out.print(finalValue);

    }

    void findPath(int row,int col,int[] currentPath,int currentPathLength)
    {
        //base conditions
        if(row < 0 || col < 0 || row >= numrows || col >= numcols)
            return;
        if(maze[row][col] == 1 )
            return;
        if(isVisitedBefore(row,col,currentPath,currentPathLength))
            return;

        currentPath[currentPathLength++] = row * numcols + col;

        if(row == exitrow && col == exitcol){

            //System.out.println("Found path of length " + currentPathLength + "!:");

            if(currentPathLength <= shortestLength)
            {
                shortestLength = currentPathLength;
                //System.out.println("New shortest length : "+currentPathLength);
            }
            return;

        }

        findPath(row-1,col,currentPath,currentPathLength);
        findPath(row,col-1,currentPath,currentPathLength);
        findPath(row,col+1,currentPath,currentPathLength);
        findPath(row+1,col,currentPath,currentPathLength);

    }

    boolean isVisitedBefore(int row,int col,int[] currentPath,int currentPathLength)
    {
        int target = row*numcols + col; // one square uniue value

        for(int i=0;i<currentPathLength;i++)
        {
            if(currentPath[i] == target)
                return true;
        }
        return false;
    }





}
