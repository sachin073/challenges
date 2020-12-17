package Circuit_2019.jan19;

import file_input_package.LogFormatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 * Created by sachin on 26/1/19.
 */
public class ShiftLetters {

    String inp=null;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] diff = null;
    static char[] inpBuffer =null;
    static long counter=0;
    static int allowedDiff=0;
    static PrintWriter out;
    static Logger logger = Logger.getLogger("ShiftLetters");
    static int[] x =null;
    public static void main(String[] args) throws Exception{
        reader = new BufferedReader(new FileReader("src/file_input_package/input.txt"));
        FileHandler fileHandler = new FileHandler("src/file_input_package/dump.txt",false);
        fileHandler.setFormatter(new LogFormatter());
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);

        inpBuffer = reader.readLine().toCharArray();
        diff = new int[inpBuffer.length-1];
        allowedDiff = Integer.parseInt(reader.readLine());
        x = new int[inpBuffer.length];

        int demo=0;
        for (char i :inpBuffer) {
            x[demo]=demo;
            demo++;
        }
        recur_cal();
        logger.info(""+"\n");
        logger.info(Arrays.toString(inpBuffer));

        logger.info(counter+"");
//        out.close();
    }

    public static void recur_cal() {
        logger.info("round");
        logger.info(counter+"");
        logger.info(Arrays.toString(inpBuffer));
        logger.info(Arrays.toString(x));
        calDiff();
        logger.info(Arrays.toString(diff));
        if (decreaseDifference()) {
            return;
        }
        logger.info(Arrays.toString(inpBuffer));
        logger.info(Arrays.toString(x)+"\n");
        recur_cal();
    }


    public static void calDiff() {

        for (int i = 0; i < inpBuffer.length-1; i++) {
            diff[i] = diff(inpBuffer[i] , inpBuffer[i+1]);
        }

    }

    static int diff(char a , char b){
        int sign = 0;
        //logger.info("left "+a+"  right "+b);
        a= (char) (a-96);
        b= (char) (b-96);

        int costToMakeAtoB = 0;
        int costToMakeBtoa = 0;
        if (a>b){
            costToMakeAtoB = -((26 - a) + b);
        }else {
            costToMakeAtoB = -(b - a);
        }

        if (b>a){
            costToMakeBtoa = (26 - b) + a;
        }else {
            costToMakeBtoa = a - b;
        }
        //logger.info(" costToMakeAtoB "+costToMakeAtoB+" ,  costToMakeBtoa "+costToMakeBtoa);
        if (Math.abs(costToMakeAtoB) < costToMakeBtoa){
            return costToMakeAtoB;
        }else
            return Math.abs(costToMakeBtoa);
    }


    public static boolean decreaseDifference() {

        int nonZeroDiff = 0;
        boolean done=true;
        for (int i = 0; i < diff.length; i++) {
            if (Math.abs(diff[i]) > 0) {
                nonZeroDiff++;
            }

            if (nonZeroDiff > allowedDiff ) {
                done =false;
                break;
            }
        }

        if (!done) {
            int minDiffIndex=-1;
            char minValue = 'z' ;
            int min=99999999;
            for (int i = 0; i < diff.length; i++) {

                if (min >= Math.abs(diff[i]) && Math.abs(diff[i])>0) {
                    min = Math.abs(diff[i]);
                    char left = inpBuffer[i];
                    char right = inpBuffer[i+1];
                    minDiffIndex=i;
/*
                    if (left < right && minValue >= left) {
                        minValue = left;
                    }else if (left > right && minValue >= right){
                        minValue = right;
                        minDiffIndex=i;
                    }
*/
                }
            }
            logger.info(minDiffIndex+" ");

            if (diff[minDiffIndex] > 0) {
                //inc right
                inpBuffer[minDiffIndex+1]=(char) increment_c(inpBuffer[minDiffIndex+1]);
                counter++;
            }else if(diff[minDiffIndex] < 0){
                //inc left
                inpBuffer[minDiffIndex]= (char) increment_c(inpBuffer[minDiffIndex]);
                counter++;
            }

        }
        return done;
    }

    static char increment_c(char a){
        int x = a;
        x=x-96;
        x++;
        if (x>26){
            x=x-26;
        }
        x= x+96;
        return (char) x;
    }
}
