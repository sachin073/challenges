package com.company.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sachin on 10/1/18.
 *
 Monk and his graph problems never end. Here is one more from our own Monk:
 Given an undirected graph with N vertices and M edges,
 what is the maximum number of edges in any connected component of the graph.
 In other words, if given graph has
 k connected components,
 E1,E2,....Ek be the number of edges in the respective connected component, then find
 max(E1,E2,....,Ek) .

 The graph may have multiple edges and self loops. The
 N vertices are numbered as
 1,2,...,N.

 Input Format:
 The first line of input consists of two space separated integers
 N and M,
 denoting number of vertices in the graph and number of edges in the graph respectively.
 Following M lines consists of two space separated each
 a and b, denoting there is an edge between vertex
 a and vertex b.

 Output Format:
 The only line of output consists of answer of the question asked by Monk.


 SAMPLE INPUT
 6 3
 1 2
 2 3
 4 5

 SAMPLE OUTPUT
 2

 */


public class ConnectedComponent {


    static LinkedList<Integer>[] adjList;
    static  int nodes,edges;

    static private void addEdge(int to,int from){
        adjList[to].add(from);
        adjList[from].add(to);
    }



    public static void main(String[] args) {

        String input="";
        BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            input = inpReader.readLine();


            nodes = Integer.parseInt(input.split(" ")[0]);
            edges = Integer.parseInt(input.split(" ")[1]);


            adjList = new LinkedList[nodes];

            for (int i = 0; i <adjList.length ; i++) {
                adjList[i] = new LinkedList<>();
            }
            while (edges > 0){
                input = inpReader.readLine();

                addEdge(Integer.parseInt(input.split(" ")[0]),Integer.parseInt(input.split(" ")[1]));

                edges--;
            }

            //graph created

            // connected component by DFS
            DFS();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void DFS(){

        visitedNodes = new ArrayList<>(nodes);

        boolean[] visited =new boolean[nodes];

        int components=0;
        for (int i = 0; i < adjList.length; i++) {

            if (!visited[i]){
                components++;
                DFSUtil(i,visited);
            }
        }
        System.out.println(components);
        System.out.println(Arrays.toString(visited));

    }

    static ArrayList<Integer> visitedNodes;
    static void DFSUtil(int node,boolean[] visited){

        visited[node] = true;
        visitedNodes.add(node);

        if (visitedNodes.contains(node)){
           // cycleFound = true;

            System.out.println( " found at node " + node ); // cycle printing???
        }

        Iterator<Integer> list = adjList[node].listIterator();

        while (list.hasNext()){

            int i= list.next();
            if (!visited[i]){
                DFSUtil(i,visited);
            }

        }


    }


}
