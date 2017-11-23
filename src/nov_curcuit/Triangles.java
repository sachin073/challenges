package nov_curcuit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by fran on 11/20/17.
 */
public class Triangles {
    static HashMap<BigInteger,BigInteger> knownSteps=null;
    static BigInteger maxStepPerformed = new BigInteger("0");

    public static void main(String[] args) {
        knownSteps=new HashMap<>();
        knownSteps.put(new BigInteger("0"),new BigInteger("1"));
        knownSteps.put(new BigInteger("1"),new BigInteger("5"));
        maxStepPerformed = new BigInteger("1");
        int tests= 0;
        try {
            BufferedReader str  = new BufferedReader(new InputStreamReader(System.in));
            tests = Integer.parseInt(str.readLine());

            while(tests>0){
                String query = str.readLine();

                System.out.println(compute(new BigInteger(query)));

                tests--;
            }
            //System.out.println(knownSteps);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // Sol(n) = 3*Sol(n-1) + 2

    private static BigInteger compute(BigInteger query) {
        BigInteger find = query;

        if(query.compareTo(maxStepPerformed) <= 0 ){
            return knownSteps.get(find );
        }

        BigInteger result= knownSteps.get(maxStepPerformed);

        while (query.compareTo(maxStepPerformed) !=0) {


            result= result.multiply(new BigInteger("3"));
            result = result.add(new BigInteger("2"));

            result= result.mod(new BigInteger("1000000007"));

            maxStepPerformed=maxStepPerformed.add(new BigInteger("1"));
            knownSteps.put(maxStepPerformed,result);
        }

        return knownSteps.get(find );

    /*    if(knownSteps.containsKey(query)){
        //System.out.println(knownSteps.get(query));
        return knownSteps.get(query);
    }else{
        BigInteger result= compute(query.subtract(new BigInteger("1"))).multiply(new BigInteger("3"));
        result= result.add(new BigInteger("2"));
        result= result.mod(new BigInteger("1000000007"));  // modulus before each computation storing
        knownSteps.put(query,result);
        return result;

    }*/
    }

}
