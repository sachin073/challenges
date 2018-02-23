package niyo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by fran on 2/19/18.
 *
 * windows 2        32       100    100
 * OS      ram      storage  price  rating
 */
public class NiyiMob {


    static String inp="";
    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int test=0;
        try {
            inpReader = new BufferedReader(new FileReader("src/file_input_package/input.txt"));
             test = Integer.parseInt(inpReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, HashMap<String,SortedList<Phone>> > windowsPhone= new HashMap<>();
        HashMap<String, HashMap<String,SortedList<Phone>> > ios= new HashMap<>();
        HashMap<String, HashMap<String,SortedList<Phone>> > android= new HashMap<>();




        while (test>0) {
            try {
                inp = inpReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] inpArr = inp.split(" ");

            if ("windows".equals(inpArr[0])){
                fillShelve(windowsPhone,inpArr);

            }else if ("ios".equals(inpArr[0])){
                fillShelve(ios,inpArr);

            }else if ("android".equals(inpArr[0])){
                fillShelve(android,inpArr);

            }
            test--;
        }

        System.out.println(windowsPhone);

        //take input
        //get max value mobile
        try {
            test = Integer.parseInt(inpReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (test>0) {
            try {
                inp = inpReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] inpArr = inp.split(" ");

            if ("windows".equals(inpArr[0])){
                getShelvePhone(windowsPhone,inpArr);

            }else if ("ios".equals(inpArr[0])){
                getShelvePhone(ios,inpArr);

            }else if ("android".equals(inpArr[0])){
                getShelvePhone(android,inpArr);

            }
            test--;
        }



    }


    private static void fillShelve(Map<String, HashMap<String,SortedList<Phone>>> shelve,String[] inpArr){
        HashMap<String,SortedList<Phone>> ramMatch = shelve.get(inpArr[1]);

        if (ramMatch != null){ // get match ram phone
            SortedList<Phone> storageMatch = ramMatch.get(inpArr[2]);

            if (storageMatch !=null){ //get match storage phone

                SortedList<Phone> priceList = storageMatch;
                priceList.add( new Phone( Integer.parseInt(inpArr[3]),Integer.parseInt(inpArr[4])));
            }else {

                storageMatch = new SortedList<>();
                storageMatch.add(new Phone( Integer.parseInt(inpArr[3]),Integer.parseInt(inpArr[4])));
                ramMatch.put(inpArr[2],storageMatch);

            }
        }else {

            SortedList<Phone> tempList = new SortedList<>();
            tempList.add( new Phone( Integer.parseInt(inpArr[3]),Integer.parseInt(inpArr[4])));

            HashMap<String,SortedList<Phone>> tempMap = new HashMap<>();
            tempMap.put(inpArr[2],tempList);

            shelve.put(inpArr[1],tempMap);
        }

    }

    private static void getShelvePhone(Map<String, HashMap<String,SortedList<Phone>>> shelve,String[] inpArr){
        HashMap<String,SortedList<Phone>> ramMatch = shelve.get(inpArr[1]);
        Phone phone=null;
        if (ramMatch != null){ // get match ram phone
            SortedList<Phone> storageMatch = ramMatch.get(inpArr[2]);

            if (storageMatch !=null){ //get match storage phone

                SortedList<Phone> priceList = storageMatch;
                //priceList.add( new Phone( Integer.parseInt(inpArr[3]),Integer.parseInt(inpArr[4])));

                for (Phone ph :priceList) {
                    if (ph.getPrice()<Integer.parseInt(inpArr[3])){
                        phone=ph;
                    }else {
                        break;
                    }
                }
            }
        }
        if (phone !=null){
            System.out.println(phone);
        }else
            System.out.println("phone not found");
    }


    static class Phone implements Comparator<Phone>{

        private int rating;
        private int price;

        public int getRating() {
            return rating;
        }

        public int getPrice() {
            return price;
        }

        Phone(int price,int rating){
            this.rating=rating;
            this.price = price;
        }

        /**
         * good = max rate and min price
         * */
        @Override
        public int compare(Phone m1, Phone m2)
        {
            if(m1.getPrice()<m2.getPrice()){
                return -1;
            }else if(m1.getPrice()>m2.getPrice()){
                return 1;
            }else {
                if (m1.getRating() / m1.getPrice() < m2.getRating() / m2.getPrice())
                    return -1;
                if (m1.getRating() / m1.getPrice() > m2.getRating() / m2.getPrice())
                    return 1;
                else
                    return 0;
            }
        }

        @Override
        public String toString() {
            return " ["+getPrice()+" >>"+getRating()+"] ";
        }
    }



   static public class SortedList<E extends Comparator> extends AbstractList<E>{
        List<E> list = new ArrayList<>();

        @Override
        public E get(int index) {
            // TODO Auto-generated method stub
            return list.get(index);
        }

        @Override
        public int size() {
            // TODO Auto-generated method stub
            return list.size();
        }


        @Override
        public boolean add(E e) {
            try {
                list.add(e);
                Collections.sort(list,e);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return false;
            }
            return true;
        }

    }



}
