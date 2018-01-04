package com.company.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sachin on 2/1/18.
 *
 Monk visits the land of Islands. There are a total of N islands numbered from 1 to N.
 Some pairs of islands are connected to each other by Bidirectional bridges running over water.
 Monk hates to cross these bridges as they require a lot of efforts. He is standing at Island #1 and wants to reach the Island #N.
 Find the minimum the number of bridges that he shall have to cross, if he takes the optimal route.

 Input:
 First line contains T. T testcases follow.
 First line of each test case contains two space-separated integers N, M.
 Each of the next M lines contains two space-separated integers X and Y , denoting that there is a bridge between Island X and Island Y.

 Output:
 Print the answer to each test case in a new line.
 *
 *
 *SAMPLE INPUT
 2
 3 2
 1 2
 2 3
 4 4
 1 2
 2 3
 3 4
 4 2

 SAMPLE OUTPUT
 2
 2

 */
public class MonkIsland {


    private int graphSize=0;
    private LinkedList<Integer> adjList[];

    MonkIsland(int size){
    this.graphSize =size;
    adjList = new LinkedList[graphSize];

        //visited =  new boolean[this.graphSize];
       /* for (LinkedList<Integer> list :adjList  ) {
            list = new LinkedList<>();
        }*/

        for (int i=0; i<graphSize; ++i)
            adjList[i] = new LinkedList();
    }


    private void addUndirEdge(int to ,int from){

        adjList[to].add(from);
        adjList[from].add(to);
    }


    public static void main(String[] args) {

        BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int test =   Integer.parseInt(inpReader.readLine());
            String tempString = "";
            MonkIsland monk;
            while(test>0){
                tempString = inpReader.readLine();

                monk= new  MonkIsland(Integer.parseInt(tempString.split(" ")[0])); // make graph
                int islandEdges = Integer.parseInt(tempString.split(" ")[1]);

                // construct graph
                while (islandEdges > 0){
                    tempString = inpReader.readLine();

                    monk.addUndirEdge(Integer.parseInt(tempString.split(" ")[0])-1,Integer.parseInt(tempString.split(" ")[1])-1);

                    islandEdges--;
                }

                //System.out.println("\n\n "+ monk.adjList);
                // solve BFS
                //monk.visited[0]=true;
               //monk.BFS(0,0);
                monk.BFS(0);

                System.out.println(monk.depth+1);
                test--;
            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    boolean visited[] =null;

    int depth = 999999999;

    // search in tree max value
    // partial correct function
    void DFS( int x,int depth){

        depth++;

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

      visited[x]=true;
        queue.add(x);

           int now = queue.poll();
           // System.out.print(now + " ");


            Iterator<Integer> i = adjList[now].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }

        while (queue.size() !=0){
            if (queue.peek() == this.graphSize-1){
                if(this.depth > depth || this.depth == 999999999) {
                    this.depth = depth;
                }
            }
//            System.out.println( depth + " << depth || MAX >>"+queue.peek() );

            DFS(queue.poll(),depth);
        }
    }


    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[this.graphSize];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
        queue.add(-1);
        int depth = 0;

        while (queue.size() != 0)
        {

            // Dequeue a vertex from queue and print it
            s = queue.poll();
           // System.out.print(s+" ");
            if (s==-1){
                depth++;
                queue.add(-1);
                if (queue.peek()==-1){
                    //no more node exists
                    break;
                }
                continue;
            }
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();

                if (n == this.graphSize-1 && !visited[n] ){
                    this.depth = depth;
                   // System.out.println("came ");
                }

                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }


        }
    }

}
