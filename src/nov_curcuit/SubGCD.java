package nov_curcuit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sachin on 26/11/17.
 */
public class SubGCD {

    static HashMap<String,BigInteger> knownValues = new HashMap<>();

    public static void main(String[] args) {
        int test = 0;

        try {
            BufferedReader str  = new BufferedReader(new InputStreamReader(System.in));
            test = Integer.parseInt(str.readLine());
            //ArrayList<Integer> array =new ArrayList<>(test);
            int[] array =new int[test];
            String arrStr = str.readLine();
            int x=0;
            for (String string :arrStr.split(" ")) {
                //array.add(Integer.parseInt(string));

                array[x] =Integer.parseInt(string);
                x++;
            }

            BigInteger result = new BigInteger("0");
            boolean overflow=false;
            // process arrayList
            for (int i = 0; i <array.length; i++) {
                for (int j = 0; j <array.length ; j++) {
                    result = result.add(process(array,i,j));

                    if (result.compareTo(new BigInteger("1000000000000000000")) >=0){
                        overflow=true;
                        break;
                    }
                }
                    if (result.compareTo(new BigInteger("1000000000000000000")) >=0){
                        overflow=true;
                        break;
                    }
            }

            if (overflow){
                System.out.println(" -1 ");
            }else {
                System.out.println(result);
            }



        }catch (Exception e){
            e.printStackTrace();
        }

    }

    static BigInteger process(int[] array,int startPoint,int endPoint){

        if (knownValues.containsKey("start"+startPoint+"-"+endPoint+"end")){
            knownValues.get("start"+startPoint+"-"+endPoint+"end");
        }

        BigInteger sum =new BigInteger("0");
        BigInteger tempSum = new BigInteger("0");

        for (int i=startPoint;i<=endPoint;i++){
            tempSum =new BigInteger("0");

            for (int j = i; j <= endPoint; j++) {

                /// logic
                if (gcd(array[i],array[j]) !=1 ) {
                    tempSum = tempSum.add(new BigInteger("1"));
                }

               // System.out.println("for i and j"+i+","+j+" >>>added 1 and temp sum"+tempSum);
            }

            sum=sum.add(tempSum);
        }

        knownValues.put("start"+startPoint+"-"+endPoint+"end",sum);
        return sum;

    }
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }

}
