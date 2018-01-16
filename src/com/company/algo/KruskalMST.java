package com.company.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by fran on 1/15/18.
 *
 */
public class KruskalMST {
        static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));
        static String inp="";

        class Edge implements Comparable<Edge>{
            int src;
            int dest;
            int weight;

            @Override
            public int compareTo(Edge o) {
                return this.weight - ((Edge)o).weight ;
            }


            @Override
            public String toString() {
                return " src >>"+src+ " | dest >>"+dest+" |weight >"+weight;
            }
        }


        int vertices,edgeCount;

        Edge[] edge ;
        
        KruskalMST(int v,int e){

            this.vertices = v;
            this.edgeCount = e;
            edge = new Edge[e];

            for (int i = 0; i < edgeCount; i++) {
                edge[i] = new Edge();
            }

        }


        public static void main(String[] args) {

            KruskalMST graph = new KruskalMST(4,5);          //edges >>> 01 , 12 ,02

// add edge 0-1
            graph.edge[0].src = 0;
            graph.edge[0].dest = 1;
            graph.edge[0].weight = 10;

            // add edge 0-2
            graph.edge[1].src = 0;
            graph.edge[1].dest = 2;
            graph.edge[1].weight = 6;

            // add edge 0-3
            graph.edge[2].src = 0;
            graph.edge[2].dest = 3;
            graph.edge[2].weight = 5;

            // add edge 1-3
            graph.edge[3].src = 1;
            graph.edge[3].dest = 3;
            graph.edge[3].weight = 15;

            // add edge 2-3
            graph.edge[4].src = 2;
            graph.edge[4].dest = 3;
            graph.edge[4].weight = 4;
            //System.out.println( graph.containCycle(graph));


            graph.MST(graph);
        }



        void MST(KruskalMST graph){

            // sorted all edges in graph based on weight
            Arrays.sort(graph.edge);

            System.out.println(Arrays.toString(edge));

            // output will be selected min. edges

            Edge[] selectedEdges = new Edge[vertices];
            for (int i = 0; i < selectedEdges.length; i++) {
                selectedEdges[i] = new Edge();
            }


            int[] parent = new int[this.vertices];

            for (int i = 0; i < vertices; i++) {
                parent[i]=-1;
            }


            for (int i = 0; i < edgeCount; i++) {
                Edge edge=  graph.edge[i];

                int x = graph.find(parent, edge.src);
                int y = graph.find(parent, edge.dest);
                System.out.println(Arrays.toString(parent));
                if (x != y) {
                    graph.Union(parent, x, y);
                    selectedEdges[i]=edge;
                }
            }

            System.out.println(Arrays.toString(parent));
            System.out.println(Arrays.toString(selectedEdges));
        }




        // A utility function to find the subset of an element i
        int find(int parent[], int i)
        {
            if (parent[i] == -1)
                return i;
            return find(parent, parent[i]);
        }

        // A utility function to do union of two subsets
        void Union(int parent[], int x, int y)
        {
            int xset = find(parent, x);
            int yset = find(parent, y);
            parent[xset] = yset;
        }

        boolean containCycle(KruskalMST graph){


            int[] parent = new int[this.vertices];

            for (int i = 0; i < vertices; i++) {
                parent[i]=-1;
            }

            for (int i = 0; i < graph.edgeCount; ++i)
            {
                int x = graph.find(parent, graph.edge[i].src);
                int y = graph.find(parent, graph.edge[i].dest);
                System.out.println(Arrays.toString(parent));
                if (x == y)
                    return true;

                graph.Union(parent, x, y);
            }

            return false;
    }

}
