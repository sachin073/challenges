package thoughtWorks.Year_2019;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sachin on 6/4/19.
 */
public class GameOfStairs {
    static     String inp="";
    static BufferedReader inpReader= new BufferedReader(new InputStreamReader(System.in));


    static List<Integer> queue= null;

    public static void main(String[] args) throws Exception{
        inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));

            inp = inpReader.readLine();
            int test = Integer.parseInt(inp);

            while (test>0){
                queue = new ArrayList<Integer>(){
                    @Override
                    public boolean add(Integer o) {
                        return super.add(o);
                    }
                };
                inp = inpReader.readLine();

                int size = Integer.parseInt(inp);

                int[] blocks = new int[size];
                 inp = inpReader.readLine();
                int i=0;
                for (String s :inp.split(" ")) {
                        blocks[i]= Integer.parseInt(s);
                        i++;
                }

                int[] query = new int[size];
                inp = inpReader.readLine();
                i=0;
                for (String s :inp.split(" ")) {
                    query[i]= Integer.parseInt(s);
                    i++;
                }



                int [] stortedArray= new int[size];

                for (int j = 0; j < size; j++) {

                    int index=0;

                    if (j==0){
                        stortedArray[j]=blocks[j];
                    }else {

                        int index2=0;
                        for (int k = 0; k <size; k++) {
                            if (stortedArray[k]>blocks[j]){
                                break;
                            }
                            index2++;
                        }

                        Integer temp = stortedArray[index];
                        stortedArray[index]=blocks[j];

                        for (int k = index+1; k < j; k++) {
                            Integer temp2 = stortedArray[k];
                            stortedArray[k]=temp;
                            temp=stortedArray[k+1];
                        }
                        stortedArray[j+1]=temp;

                    }


                    System.out.print(stortedArray[query[j]-1]);

                }
                System.out.println();
            test--;
            }

    }

    static Integer getElementByIndex(int index){
        // better DS needed

        return queue.get(index-1);
    /*

        Iterator<Integer> iterator = queue.iterator();
        int i=0;
        while (iterator.hasNext() ){
            Integer number=iterator.next();
            if (index-1==i){
                return number;
            }
            i++;
        }
        return null;*/
    }

}
