package nov_curcuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by fran on 11/21/17.
 */
public class Magic {

    static HashMap<Integer,BigInteger > fiboMap;
    static int maxKnownFibo =0;

    static HashMap<Integer,BigInteger > factorial;
    static int maxKnownFactorial =0;


    public static void main(String[] args) {

        fiboMap =new HashMap<>();
        fiboMap.put(0,new BigInteger("1"));
        fiboMap.put(1,new BigInteger("1"));
        maxKnownFibo = 1;

        factorial =new HashMap<>();
        factorial.put(0,new BigInteger("1"));
        factorial.put(1,new BigInteger("1"));
        maxKnownFactorial = 1;

        int test = 0;

        try {

            BufferedReader str  = new BufferedReader(new InputStreamReader(System.in));
            test = Integer.parseInt(str.readLine());

            while (test>0){

             String nmk =   str.readLine();
             int N = Integer.parseInt(nmk.split(" ")[0]);
             int M = Integer.parseInt(nmk.split(" ")[1]);
             int K = Integer.parseInt(nmk.split(" ")[2]);

             BigInteger iterationSum   =     findSum(N,M);

             BigInteger outPut= new BigInteger("0");
             outPut = iterationSum.divide(new BigInteger(K+""));

             outPut = outPut.mod(new BigInteger("1000000007"));

             System.out.println(outPut);


                test--;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    private static BigInteger findSum(int N , int M){

        BigInteger sum=new BigInteger("0");
        BigInteger result=new BigInteger("0");
        System.out.println( "fact time :"+System.currentTimeMillis());
        for (int i = N; M >= i ; i++) {

            result = getFactorial(i).multiply(getFibonacci(i));
            sum = sum.add(result);
            //System.out.println( "sum "+sum);
            //sum = sum.mod(new BigInteger("1000000007"));
            System.out.println( i+">>fact time :"+System.currentTimeMillis());
        }
        System.out.println( "fact time :"+System.currentTimeMillis());
        //System.out.println( " \n total sum "+sum);
        return  sum;

    }


    private static BigInteger getFactorial (int number ){

        BigInteger result=null;

        if(factorial.containsKey(number)){
            return factorial.get(number);
        }

        result = factorial.get(maxKnownFactorial);

        while (number != maxKnownFactorial){

            maxKnownFactorial++;
            result = result.multiply(new BigInteger(maxKnownFactorial+""));

            //result = result.mod(new BigInteger("1000000007"));

            factorial.put(maxKnownFactorial,result);
        }

        //System.out.println( "factorial "+result);

        return result;

    }



    private static BigInteger getFibonacci(int number){
        BigInteger result=null;


        if(fiboMap.containsKey(number)){
            return fiboMap.get(number);
        }

        result = fiboMap.get(maxKnownFibo);

        while (number != maxKnownFibo){

        result = result.add(fiboMap.get(maxKnownFibo -1));

        //result = result.mod(new BigInteger("1000000007"));

        maxKnownFibo++;

        fiboMap.put(maxKnownFibo,result);

        }
        // System.out.println( "fibo "+result);
        return result;
    }

}
