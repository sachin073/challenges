package jan_circuit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sachin on 28/1/18.
 */
public class ClassicTask {

    static     String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    static LinkedList<Integer>[] adjList;
    static  int connectionCount=0;
    static int size;
    static private void addEdge(int to,int from){
        adjList[to].add(from);
       // adjList[from].add(to);
    }

    static void makeGraph(int size){

        adjList = new LinkedList[size];

        for (int i = 0; i < adjList.length ; i++) {
            adjList[i] = new LinkedList<>();
        }


    }



    public static void main(String[] args) {


        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));

            inp = inpReader.readLine();
            int connectionSet = Integer.parseInt(inp.split(" ")[1]);
            size = Integer.parseInt(inp.split(" ")[0]);
            size = size+1;
             makeGraph(size);

             while (connectionSet > 0){

                 inp = inpReader.readLine();

                 int a = Integer.parseInt(inp.split(" ")[0]);
                 int b = Integer.parseInt(inp.split(" ")[1]);

                 int decrementer = b;
                 for (int i = a; i <=b ; i++,decrementer--) {
                     addEdge(i,decrementer);
                 }
                 connectionSet--;
             }

             //printList();

            DFS();

            connectionCount--;
            System.out.println(connectionCount);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void printList(){
        for (int i = 0; i < adjList.length; i++) {
            System.out.println( i+ " >>>>"+adjList[i]);
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

    // The function to do DFS traversal. It uses recursive DFSUtil()
    static void DFS()
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[size];

        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        for (int i=0; i<size; ++i)
            if (visited[i] == false) {
                connectionCount++;
                DFSUtil(i, visited);
            }
    }
}
