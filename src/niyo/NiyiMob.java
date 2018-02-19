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

        try {
            inpReader = new BufferedReader(new FileReader("src/file_input_package/input.txt"));
            int test = Integer.parseInt(inpReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String,HashMap<String,ArrayList<Phone> >> windowsPhone= new HashMap<>();
        HashMap<String,HashMap<String,ArrayList<Phone>>> ios= new HashMap<>();
        HashMap<String,HashMap<String,ArrayList<Phone>>> android= new HashMap<>();


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


        /**
         * good = max rate and min price
         * */
        @Override
        public int compare(Phone m1, Phone m2)
        {
            if (m1.getRating()/m1.getPrice() < m2.getRating()/m2.getPrice())
                return -1;
            if (m1.getRating()/m1.getPrice() > m2.getRating()/m2.getPrice())
                return 1;
            else
                return 0;
        }


        @Override
        public String toString() {
            return " ["+getPrice()+" >>"+getRating()+"] ";
        }
    }



   static public class SortedList<E> extends AbstractList<E>{
        List<E> list = new ArrayList<>();

        Comparator<E> comparator;
        public SortedList(Comparator<E> comparator) {
            this.comparator=comparator;
            // TODO Auto-generated constructor stub
        }

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
                Collections.sort(list,this.comparator);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return false;
            }
            return true;
        }

    }



}
