package jan_circuit;

import com.company.algo.PrimsMST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sachin on 21/1/18.


 */
public class Roads {

    static String inp="";
    static BufferedReader inpReader ;//= new BufferedReader(new InputStreamReader(System.in));

    static class Node{
        int name;
        int distance;

        Node(int name ,int distance){
            this.name = name;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return " (name >"+name + "  >> distance"+distance+") ";
        }
    }


    static LinkedList<Node>[] graph;

    static void addNode(int name,Node node){
        graph[name].add(node);
    }


    static void printList(LinkedList<Node>[] list){

        int i= 0;
        for (LinkedList<Node> mst: list) {
            System.out.print(i +" >>>>>> [ ");
            Iterator<Node> itr = mst.listIterator();
            while (itr.hasNext()){
                Node temp = itr.next();
                System.out.print( temp  );
                if(itr.hasNext()){
                    System.out.print(",");
                }
            }
            System.out.println("] ");
            i++;
        }
    }
    
    public static void main(String[] args) {

        int len, time;

        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));

            inp = inpReader.readLine();
            len = Integer.parseInt(inp.split(" ")[0]);
            time = Integer.parseInt(inp.split(" ")[1]);

            int[] arr = new int[len];
            inp = inpReader.readLine();
            String[] strings = inp.split(" ");

            //int source =Integer.parseInt(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }

            graph = new LinkedList[len];

            for (int i = 0; i < len; i++) {
                graph[i] = new LinkedList<>();
            }
            Node source = new Node(0,arr[0]);

            for (int i = 0; i < len; i++) {

                for (int j = i+1 ; j < len ; j++) {
                    addNode(i,new Node(j,arr[j]));
                }
            }

            printList(graph);

            // print max path of time K;


            findPath(graph,time,source);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // apply DFS only to find sets
    static void findPath(LinkedList<Node>[] graph,int time , Node source){


    }

}
