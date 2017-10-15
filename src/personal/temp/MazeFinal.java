package personal.temp;/*

	Backtracking/recursion to solve a maze.

	The program will output all the paths it finds and then output (again)
	in the end the last shortest path found.


	I found it easiest to simply hardcode the maze in the variables below.
	It is IMPORTANT to note there is no error checking.  So if the end
	state is unreachable, an unexpected result/crash is likely.

*/


import java.io.*;

public class MazeFinal {

    static int numrows = 3;
    static int numcols = 4;
    static int startrow = 0;
    static int startcol = 0;
    static int endrow = 1;
    static int endcol = 3;

    static int myMaze[][] =
            {       {0, 0, 0, 0},
                    {1, 0, 1, 0},
                    {1, 0, 0, 0}
            };

    /*these two variables keep track of the shortest path found so far*/
    static int shortestpath[] = new int[numrows * numcols];
    static int shortestlength;

    /*******************************************************************/

    boolean beenhere(int row, int col, int pathsofar[], int lengthsofar) {
		/*this private boolean function tells if this spot (row,col) has
		  been visited before*/

        int x;
        int target = row * numcols + col;  /*this computation gives a unique
										id to each maze square*/

        for (x = 0; x < lengthsofar; x++)
            if (pathsofar[x] == target) return true;

        return false;
    }


    public void findpath(int row, int col, int pathsofar[], int lengthsofar) {

        if (row < 0 || col < 0 || row >= numrows || col >= numcols)
            return;
        if (myMaze[row][col] == 1) return;
        if (beenhere(row, col, pathsofar, lengthsofar)) return;

        int mypath[] = new int[lengthsofar + 1];

       System.arraycopy(pathsofar, 0, mypath, 0, lengthsofar);
			/*for local copy for proper backtracking*/


        mypath[lengthsofar++] = row * numcols + col;  /*adds this square to
													traveled path*/

        if (row == endrow && col == endcol) {
			/*Reached the end, thus finding a valid path*/

            System.out.println("Found path of length " + lengthsofar + "!:");

            if (lengthsofar <= shortestlength) { /*New shortest path?*/
                shortestlength = lengthsofar;
                System.arraycopy(mypath, 0, shortestpath, 0, lengthsofar);
                System.out.println(" (New shortest path of length " + lengthsofar + ")");
            }
            System.out.println("");
            return;
        }

		/*Below, recursively call to go to other squares*/

        findpath(row - 1, col, mypath, lengthsofar);
        findpath(row, col - 1, mypath, lengthsofar);
        findpath(row, col + 1, mypath, lengthsofar);
        findpath(row + 1, col, mypath, lengthsofar);

    }


    /*******************************************************************/
    public static void main(String[] args) {
		/* The main function initializes appropriate variables,
			outputs the initial maze, finds the path, and outputs it*/

        try {

            int pathsofar[];		/*Path to get started with*/
            int lengthsofar;		/*length to get started with*/

            MazeFinal daMaze = new MazeFinal();	  /*the maze object*/

            pathsofar = new int[daMaze.numrows * daMaze.numcols];  /*for max size*/

            for (int x = 0; x < daMaze.numrows * daMaze.numcols; x++) {
                daMaze.shortestpath[x] = -1;  /* initializing the path arrays*/
                pathsofar[x] = -1;
            }

		/*initial lengths*/
            daMaze.shortestlength = daMaze.numrows * daMaze.numcols + 1;
            lengthsofar = 0;


            daMaze.findpath(startrow, startcol, pathsofar, lengthsofar);
            System.out.println("The shortest path found was the following of length " + daMaze.shortestlength);


        } catch (Exception e) {
            System.out.print(-1);
        }
    }
}