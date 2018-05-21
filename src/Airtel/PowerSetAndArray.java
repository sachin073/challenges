package Airtel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by sachin on 17/3/18.

 Odd-Even Subarrays

 You are given an array A of N positive integer values. A subarray of this array is called Odd-Even subarray if the number of odd integers in this subarray is equal to the number  of even integers in this subarray.

 Find the number of Odd-Even subarrays for the given array.

 Input Format:
 The input consists of two lines.

 First line denotes N - size of array.
 Second line contains N space separated positive integers denoting the elements of array A.

 Output Format:
 Print a single integer, denoting the number of Odd-Even subarrays for the given array.


 INP
 4
 1 2 1 2

 OUT
 4          (12 ,23 ,34 ,1234)

 */
public class PowerSetAndArray {

    static String inp="";
    static BufferedReader inpReader; //= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {


        try {
            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));

            inp = inpReader.readLine();

            int size = Integer.parseInt(inp);

            inp = inpReader.readLine();

            int[] arr = new int[size];
            int i=0;
            for (char ch:inp.toCharArray() ) {
                if (ch ==' ')continue;

                arr[i] = Integer.parseInt(Character.toString(ch));
            i++;
            }

            int ender = size;

            int broker =5;
            
            final ExecutorService service;
            final Callable<String> task1;
            final Callable<String> task2;
            final Callable<String> task3;
            final Callable<String> task4;
            final Callable<String> task5;
            
            service = Executors.newFixedThreadPool(5); // using 5 threads only

            ender = size/broker;

            task1 = new iFinder(arr,0,ender);

            task2 = new iFinder(arr,ender,ender*2);

            task3 = new iFinder(arr,ender*2,ender*3);

            task4 = new iFinder(arr,ender*3,ender*4);

            task5 = new iFinder(arr,ender*4,ender*5);

            try {
                List<Future<String>> futures = service.invokeAll(
                        Arrays.asList(task1,task2,task3,task4,task5)
                );

                int res=0;
                for(Future<String> future: futures) {
                    // The result is printed only after all the futures are complete. (i.e. after 5 seconds)
                    res += Integer.parseInt(future.get());
                }

                System.out.println(res);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch ( ExecutionException e){
                e.printStackTrace();
            }
        service.shutdown();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    static class iFinder implements Callable<String>{

        int istart;

        int[] arr;

        int iEnd;
        iFinder(int[] arr,int istart,int iEnd)
        {
            this.istart = istart;
            this.arr = arr;
            this.iEnd = iEnd;
        }

        @Override
        public String call() {
         int result=  findArray(arr,istart,iEnd);

            return Integer.toString(result);
        }

        int findArray(int[] arr,int iStart,int iEnd){

            int size =arr.length;
            int outPut=0;
            int evenCount=0;
            int oddCount =0;
            System.out.println("out"+Thread.currentThread().getName()+">>"+istart+">>"+iEnd);
            for (int j = iStart; j < iEnd; j++) {
                evenCount=0;
                oddCount=0;

                for (int i = iStart; i < size; i++) {


                    if (i % 2 == 0) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }

                    if (evenCount == oddCount) {
                        outPut++;
                    }

                }
            }
            return outPut;
        }
    }

}
