package Airtel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by fran on 3/20/18.

 You are given a grid A of size N×M, two integers (Si,Sj) and Q tasks. Each task contains two integers, (Di,Dj).
 Each cell in the grid is either empty cells denoted by O (Capital English character 'o') or occupied cells denoted by ∗.
 Initially, you are at (Si,Sj). Find the minimum number of steps in which you have to take to reach (Di,Dj) from (Si,Sj) without traversing the occupied cells.

 In a single step, you can move from any cell (i,j) to the 4 neighboring cells i.e.
 (i−1,j), (i+1,j), (i,j−1) and (i,j+1) provided these cells are inside the grid A.

 Input Foramt
 The first line of input contains 3 space separated integers N, M and Q where N and M denotes the dimensions of the grid A and Q denotes the number of tasks.
 Each of the next N lines contain a string of length M, jth character in the ith line of which is either O or ∗ denoting that the cell (i,j) is empty or occupied.
 The next line contains 2 space separated integers Si and Sj denoting the source cell of the grid.
 This is followed by Q lines each containing 2 space separated integers Di and Dj.

 Output Format
 Print the answer to each query on a new line. If there is no path between (Si,Sj) and (Di,Dj) , print −1.

 */

public class GRID {
    static     String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));

            inp = inpReader.readLine();
            int gridI = Integer.parseInt(inp.split(" ")[0]);

            int gridJ = Integer.parseInt(inp.split(" ")[1]);

            int queries= Integer.parseInt(inp.split(" ")[2]);


            int[][] grid =new int[gridI][gridJ]; // 0 walkable , 1 not

            for (int i = 0; i < gridI; i++) {
                inp = inpReader.readLine();
                char[] ar= inp.toCharArray();
                for (int j = 0; j < gridJ; j++) {
                    grid[i][j] = ('*'==ar[j]) ? 1 : 0;
                    System.out.print(grid[i][j] );

                }
                System.out.println("");
            }

           int sourcei,sourcej;
            inp = inpReader.readLine();
            char[] ar= inp.toCharArray();
            sourcei = ar[0];
            sourcej = ar[1];

            while (queries>0){
                inp = inpReader.readLine();
                char[] dest= inp.toCharArray();
                int destI= dest[0];
                int destJ= dest[1];

                //if dest if 1 can't reach

                if (grid[destI][destJ]==1){
                    System.out.println("-1");
                }else {



                }

                queries--;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
