package Furlenco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sachin on 30/6/18.
 There are Q queues of students.Each queue contains Ni (1≤i≤Q) number of students. You have to distribute chocolates to K students. Also each student will only be happy if he gets countj (1≤j≤Ni) number of chocolates. Find the minimum number of chocolates that you need to make K students happy.

 Note:-

 You have to follow all the properties of a queue while distributing the chocolates. That is, if a student standing in front of a queue gets chocolate(s) and he is happy, he will leave the queue and the next student in queue comes in front. You can give chocolates only to the students standing in the front of the queue.
 Also if K is greater than the total number of students then you simply fulfill everyone's requirement.

 ---------------
 First line: T i.e number of testcases
 For each test case:
 First line: Two space-separated integers Q and K
 For each queue :
 First line: N i.e number of students in that queue.
 Second line: N space-separated integers denoting requirement of each student.

 Format of the output file:
 For each testcase, print the minimum number of chocolates as asked in the statement.
 Answer for each test case should come in a new line.

 -----------
 Sample Input
 1
 3 5
 2
 1 6
 3
 2 3 4
 1
 5

 Sample Output
 15

 *
 *
 */
public class ChocolateDistribution {

    static     String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {

            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));
            inp = inpReader.readLine();

            int test= Integer.parseInt(inp);
            int queues =0,studentsTosatisfy=0;
            while (test>0){
                inp = inpReader.readLine();

                queues = Integer.parseInt(inp.split(" ")[0]);

                studentsTosatisfy = Integer.parseInt(inp.split(" ")[1]);
                int studentSatisfied=0;
                int moneySpent=0;
            //parse input

                List<Queue<Integer>> queuesList= new LinkedList<>();
                while (queues >0){
                    inp = inpReader.readLine();
                    int studentCount = Integer.parseInt(inp);

                    inp = inpReader.readLine();
                    String[] studentRow = inp.split(" ");

                    Queue<Integer> students = new ArrayDeque<>(studentCount);

                    for (int i = 0; i < studentCount; i++) {
                        inp = studentRow[i];
                        students.add(Integer.parseInt(inp));
                    }
                    queuesList.add(students);
                    queues--;
                }



                while (studentSatisfied<studentsTosatisfy){

                    //min of front of all studentQueues

                    int minFront=9999;
                    int queueTopop=0;
                    int i=0;
                    boolean isStudentLeft=false;
                    for (Queue<Integer> queue: queuesList) {
                        i++;
                        if (!isStudentLeft && queue.isEmpty()){
                            isStudentLeft=false;
                        }

                        if(!queue.isEmpty() && minFront>queue.peek()){
                            isStudentLeft=true;
                            queueTopop=i;
                            minFront = queue.peek();
                        }
                    }

                    if (!isStudentLeft)
                        break;

                    moneySpent += queuesList.get(queueTopop-1).poll();
                    studentSatisfied++;
                }

                System.out.println(moneySpent);

                test--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
