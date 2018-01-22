package nov_curcuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
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
        fiboMap.put(2,new BigInteger("1"));
        maxKnownFibo = 1;

        factorial =new HashMap<>();
        factorial.put(0,new BigInteger("1"));
        factorial.put(1,new BigInteger("1"));
        maxKnownFactorial = 1;

        int test = 0;

        try {

            BufferedReader str  = new BufferedReader(new InputStreamReader(System.in));
            test = Integer.parseInt(str.readLine());
          /*  test =2;
            while(test !=0){
                test = Integer.parseInt(str.readLine());

                getFastFibonacci(test);
            }
*/

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
       // System.out.println( "fact time :"+System.currentTimeMillis());
        for (int i = N; M >= i ; i++) {

            System.out.println("for "+i+" getFastFactorial(i) = "+getFastFactorial(i));
            System.out.println("for "+i+" getFastFibonacci(i) = "+getFastFibonacci(i));

            result = getFastFactorial(i).multiply(getFastFibonacci(i));
            sum = sum.add(result);
            //System.out.println( "sum "+sum);
            //sum = sum.mod(new BigInteger("1000000007"));
          //  System.out.println( i+">>fact time :"+System.currentTimeMillis());
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

    private static BigInteger getFastFactorial (int number ) {

        if (factorial.containsKey(number)){
           return factorial.get(number);
        }

        ArrayList<Integer> factorsOfNumber = primeFactors(number);

        System.out.println("factors "+number+"<>"+factorsOfNumber);

        ArrayList<Integer> countForFactors = new ArrayList<>();
        for (Integer factor: factorsOfNumber ) {
                int count= getFactorCount(number,factor);
                countForFactors.add(count);
        }

        System.out.println("factors "+number+"<>"+countForFactors);

        BigInteger result = new BigInteger("0") ;
        for (int i = 0; i < factorsOfNumber.size(); i++) {
            int temp = (int)Math.pow(factorsOfNumber.get(i),countForFactors.get(i));
            result = result.add(new BigInteger(temp+""));
        }

        factorial.put(number,result);
        return result;

    }


    private static int getFactorCount(int number,int div){
    int count = 1;

        while (  number/div > 0){

            count++;
            div=(int) Math.pow(div,count);
        }
        count--;
    return count;
    }


    public static ArrayList<Integer> primeFactors(int n)
    {
        ArrayList<Integer> factors = new ArrayList<>();

        // Print the number of 2s that divide n
        while (n%2==0)
        {
            if(!factors.contains(2)){
                factors.add(2);
            }
            n /= 2;
        }

        // n must be odd at this point. So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                //System.out.print(i + " ");
                if(!factors.contains(i)){
                    factors.add(i);
                }
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2){
            System.out.print(n);
            if(!factors.contains(2)){
                factors.add(2);
            }
        }
    return factors;
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


    private static BigInteger getFastFibonacci(int number){
        BigInteger result ;

        if (fiboMap.containsKey(number)){
            return fiboMap.get(number);
        }

        if(number % 2 ==0){     //F(2n) = F(n)[2*F(n+1) – F(n)]
            BigInteger fn = getFastFibonacci(number/2);
            BigInteger fn1 = getFastFibonacci((number /2) + 1).multiply(new BigInteger("2"));
            fn1 =( fn1.subtract(fn));
            result = fn.multiply(fn1);

        }else{                  //F(2n + 1) = F(n)2 + F(n+1)2
            BigInteger fn = getFastFibonacci(number/2)  ;
                fn = fn.multiply(fn);

            BigInteger fn1 = getFastFibonacci((number /2) + 1);
                fn1 = fn1.multiply(fn1);

            result = fn.add(fn1);

        }

        System.out.println(" result "+number+"<>"+result);

        fiboMap.put(number,result);
        return result;
    }

}
