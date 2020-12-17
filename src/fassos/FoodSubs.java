package fassos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sachin on 12/1/19.

 You want to buy a food subscription package for the upcoming month. You know exactly the days on which you will eat.
 This month has 30 days and there are 3 types of packages that available :

 1-Day Package - 199 valid for one day.
 7-Day Package - 699 valid for 7 consecutive days.
 30-Day Package - 2499 valid for all 30 days of the month.
 You want to pay as little as possible. You will be given a sorted (in increasing order)
 array A of dates when you will be eating. For example, given:

 You can buy 7-Day and 1-day subscription. The two 1-day subscriptions should be used on days 29 and 30.
 The 7-day subscription should be used on the first seven days of the month.
 The total cost is 1097 and there is no other possible way of paying less.

 Write a function:

 function solution (A) { } that, given an array  consisting of  integers that specifies days on which you will eat,
 returns the minimum amount of money that you have to spend on food subscription for the month.

 Input Format
 An array  of  days where you would be eating.

 Output Format
 The minimum amount of money that you have to spend.

 Constraints

 is an integer within the range ;
 Each element of array is an integer within the range
 Array  is sorted in increasing order
 The element of  is all distinct.


70% success :)
 */
public class FoodSubs {

    static     String inp="";
    static BufferedReader inpReader= new BufferedReader(new InputStreamReader(System.in));


    static Map<String,List<Integer>> weekStats=new HashMap<>();
    static Integer[] days ;

    static final int DAY_PAY= 199;
    static final int WEEK_PAY= 699;
    static final int MONTHS_PAY= 2499;

    public static void main(String[] args) throws Exception{


        inpReader = new BufferedReader(new FileReader("src/file_input_package/input.txt"));

        int size = Integer.parseInt(inpReader.readLine());
        days = new Integer[size];

        String[] temp = inpReader.readLine().split(" ");
        int i=0;
        Map<Integer,String> daysMapped= new HashMap<>();
        for (String str :temp) {
            days[i]= Integer.parseInt(str);
            daysMapped.put(days[i],"none");
            i++;
        }
        i = 0;
        for (int j = 0; j < days.length; j++) {
            nthEntryTo7Days(j);
        }
        Map<String,List<Integer>> weekMapped= new HashMap<>();
        while (daysMapped.size()>3) {

            //find max in map
            String maxKey = "";
            int max = 0;
            for (Map.Entry<String, List<Integer>> listEntry : weekStats.entrySet()) {
                List<Integer> list = listEntry.getValue();
                if (max < list.size()) {
                    maxKey = listEntry.getKey();
                    max = list.size();
                }
            }
            List<Integer> integerList =weekStats.get(maxKey);
            weekMapped.put(maxKey,integerList);
            weekStats.remove(maxKey);
            removeFromMapList(integerList);

            daysMapped.keySet().removeAll(integerList);
        }


        int payment =DAY_PAY *daysMapped.size();
        payment +=WEEK_PAY*weekMapped.size();
        if (payment<MONTHS_PAY){
            System.out.println(payment);
        }else {
            System.out.println(MONTHS_PAY);
        }
/*
        for (Map.Entry<String,List<Integer>> list:weekMapped.entrySet()){
            System.out.println(list.getKey()+" :: "+list.getValue());
        }

        for (Map.Entry<Integer,String> list:daysMapped.entrySet()){
            System.out.println(list.getKey());
        }
*/

    }

    static void nthEntryTo7Days(int index){
        int start=days[index];
        List<Integer> daysInWeek=new ArrayList<>();
        daysInWeek.add(days[index]);
        weekStats.put(index+"_start",daysInWeek);

        for (int i = index+1; i <index+7 && i <days.length-1 ; i++) {

            if (days[i]<start+7){
                daysInWeek.add(days[i]);
            }
        }
        if (daysInWeek.size()<4){
            weekStats.remove(index+"_start");
        }
    }

    static void removeFromMapList(List<Integer> toRemove){
        for (Map.Entry<String,List<Integer>> entry:weekStats.entrySet()){
            List<Integer> list= entry.getValue();
            list.removeAll(toRemove);
        }

    }
}
