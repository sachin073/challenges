package com.company.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by fran on 1/10/18.
 *
 *

 Matt loves Graph Theory. He recently enrolled into the Algorithms course and started liking it too.
 His teacher understood his love for graphs and decided to give him a problem.

 She gives him a Tree and asks him to write a program to find if it's connected or not.
 She realizes that Matt would do this in no time. So, instead she gives him a Graph and then removes a vertex from it and now asks him to find if the resultant graph is connected or not.

 Since he is new to programming and algorithms, you have to help him solve this problem.

 Input

 First line contains a single integer N denoting the number of vertices in the graph.
 Second line contains a single integer k denoting the number of edges in the graph.
 k lines follow each containing two space separated integers a and b denoting the edge between the vertices a and b.
 Then, the last line contains a single integer x which denotes the vertex that is removed from the graph.

 Output

 "Connected" (without quotes) if the resultant graph is connected. "Not Connected" (without quotes), otherwise.

 SAMPLE INPUT
 4
 3
 3 0
 0 1
 1 2
 2

 SAMPLE OUTPUT
 Connected

 */
public class MattBook {



    static LinkedList<Integer>[] adjList;
    static   int nodes,edges;
    static void  addEdge(int to , int from){

        adjList[to].add(from);
        adjList[from].add(to);
    }

    public static void main(String[] args) {



        String inp="";
        BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));



        try {
           // inp = inpReader.readLine();

            nodes = Integer.parseInt(inpReader.readLine());
            edges = Integer.parseInt(inpReader.readLine());

            adjList = new LinkedList[nodes];

            for (int i = 0; i <adjList.length; i++) {
                adjList[i] = new LinkedList<>();
            }

            //make graph

            while (edges > 0){

                inp = inpReader.readLine();

                addEdge(Integer.parseInt(inp.split(" ")[0]),Integer.parseInt(inp.split(" ")[1]));
                edges--;
            }

            int edgeRemoved = Integer.parseInt(inpReader.readLine());

/*
            for (LinkedList<Integer> list :adjList) {
                if (list.contains(edgeRemoved)){
                    list.remove(list.indexOf(edgeRemoved));
                }
            }
*/

            //printList();
            Iterator<Integer> i = adjList[edgeRemoved].listIterator();

            while (i.hasNext())
            {
                int n = i.next();
                if (adjList[n].contains(edgeRemoved)){
                    adjList[n].remove(adjList[n].indexOf(edgeRemoved)) ;
                }
            }
           // printList();


            // graph completed

            int start =0;

            if (edgeRemoved ==0){
             start =1;
            }

            DFS(start);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    static void DFS(int start)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[nodes];

        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        /*for (int i=0; i<V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);*/
        DFSUtil(start, visited);

        boolean isConnected=true;
        boolean first=false;
        for (boolean visit :visited) {
            if (!visit){
                if (first){
                    isConnected =false;
                    break;
                }

                first =true;

            }
        }
        if (isConnected){
            System.out.println("Connected ");
        }else {
            System.out.println("Not Connected");
        }

    }



  static void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        //System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }


  static void printList(){
        for (int i = 0; i < adjList.length; i++) {
            System.out.println( i+ " >>>>"+adjList[i]);
        }

    }
}
