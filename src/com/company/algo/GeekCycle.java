package com.company.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by fran on 1/11/18.
 *
 *
 *      ### Detect Cycle in a Directed Graph #####
 *
 *      ## solution ##
 *      take a list of visited vertices .
 *      perform DFS on all vertices, if a edge found which connect a already visited node then it has a cycle
 *
 */
public class GeekCycle {

    // reader
    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));
    static String inp="";


    static LinkedList<Integer>[] adjList;
    static   int nodes,edges;

    static void  addEdge(int to , int from){
        adjList[to].add(from);
    }

    static void makeGraph(){

        try {
            adjList = new LinkedList[nodes];

            for (int i = 0; i < adjList.length; i++) {
                adjList[i] = new LinkedList<>();
            }

            //make graph

            while (edges > 0) {

                inp = inpReader.readLine();
                addEdge(Integer.parseInt(inp.split(" ")[0]), Integer.parseInt(inp.split(" ")[1]));
                edges--;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {


        try {

            nodes = Integer.parseInt(inpReader.readLine());
            edges = Integer.parseInt(inpReader.readLine());

            makeGraph();

            //find cycle
            DFS(0);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static ArrayList<Integer> visitedNodes;

    static boolean cycleFound=false;


    static void DFS(int source){

        visitedNodes = new ArrayList<>(nodes);

        boolean[] visited =new boolean[nodes];


        for (int i = 0; i < adjList.length; i++) {
            if (!visited[i]){
                DFSUtil(source,visited);
            }
        }

    }


    static void DFSUtil(int node,boolean[] visited){

        visited[node] = true;
        visitedNodes.add(node);

        if (visitedNodes.contains(node)){
            cycleFound = true;

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
