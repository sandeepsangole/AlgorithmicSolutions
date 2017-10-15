package Arrays;

/**
 * Created by sandeep on 9/10/2017.
 */

/*

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
*/

import java.util.*;
public class SpiralMatrix
{

    enum Direction {
        RIGHT,DOWN,LEFT,UP
    }

    public static void main(String args[]){
            int[][] mat = {
                    {1,2,3},
                    {4,5,6},
                    {7,8,9}
            };

            printSprialMatrix(mat);
    }


    public static List<Integer> printSprialMatrix(int[][] mat){

        List<Integer> result = new ArrayList<Integer>();
        int r = 0;
        int c = 0;
        int lastRow = mat.length;
        int lastCol = mat[0].length;

        Direction dir = Direction.RIGHT;

        if(dir == Direction.RIGHT) {
            while(c < lastCol)
            {
                result.add(mat[r][c]);
                c++;
            }
            c--;
            r++;
            dir = Direction.DOWN;
        }

        if(dir == Direction.DOWN){
            while(r < lastRow){
                result.add(mat[r++][c]);
            }
            r--;
            lastCol--;
            dir = Direction.LEFT;
        }

        if(dir == Direction.LEFT){
            while(lastCol > c){
                result.add(mat[r][lastCol--]);
            }
            lastRow--;
            dir = Direction.UP;
        }

        return result;
    }

    }
