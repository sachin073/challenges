package Circuit_2019.Dec18_circuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sachin on 3/1/19.

 Alice and Bob are playing a game of picking coins. They are given a large pile of  coins and an integer .
 In the  move of any player, coins are picked from the pile.
 A player who is not able to make the move during his turn loses.
 You are required to predict the winner of the game.

 Note: In every turn, Alice plays first followed by Bob.

 INP
 4
 10 3
 14 2
 18 10
 37 5

 Out
 Bob
 Bob
 Alice
 Alice


 Explanation
 Test Case 1
 In the first move: Alice first removes 3 coins, then Bob also removes 3 coins.
 In the second move: Alice has to remove 9 coins but since only 4 are available, Alice loses and Bob wins.


 */
public class PickCoins {

    static String input;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{

        reader = new BufferedReader(new FileReader("src/file_input_package/input.txt"));
        int test = Integer.parseInt(reader.readLine());
        while (test>0){
            input = reader.readLine();
            long coins=Long.parseLong(input.split(" ")[0]);
            long number=Long.parseLong(input.split(" ")[1]);
            long turn=1;
            String player="Alice";
            BigInteger coinStack= new BigInteger(coins+"");
            if (number==1){
                if (coins%2==0){
                    System.out.println("Bob");
                }   else {
                    System.out.println("Alice");
                }
                test--;
                continue;
            }

            for (; ; ) {
                BigInteger coinsToRemove = getMultiple(number,turn);
                boolean canRemove=true;
                for (int i = 0; i <2 ; i++) {
                    if (i==1){
                        player="Bob";
                    }else {
                        player="Alice";
                    }
                    if (coinStack.compareTo(coinsToRemove) < 1 ){
                        canRemove = false;
                        break;
                    }
                    coinStack = removeCoins(coinStack,coinsToRemove);
                }

                if (!canRemove){
                    break;
                }
                turn++;
            }

            if (player.equals("Bob")){
                System.out.println("Alice");
            }else {
                System.out.println("Bob");
            }

            test--;
        }

    }


    static BigInteger getMultiple(long number,long n){
        BigInteger multiple=new BigInteger("1");
        for (int i = 0; i < n; i++) {
            multiple=multiple.multiply(new BigInteger(number+""));
        }
        return multiple;
    }

    static BigInteger removeCoins(BigInteger coinStack,BigInteger remove){
        return coinStack.subtract(remove);
    }

}
