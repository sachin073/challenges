package tinkers;

import java.util.List;

/**
 * Created by fran on 2/13/18.
 */
public class Tink extends Supreme{

    public static Tink ti = new Tink();

    static int x =10;

/*

https://stackoverflow.com/questions/1998544/method-has-the-same-erasure-as-another-method-in-type
    void method1(List<Integer> a){
        System.out.println(" aaa");
    }
*/



    public Tink(){
        System.out.println("call");
    }
}
