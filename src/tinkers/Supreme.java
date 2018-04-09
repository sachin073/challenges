package tinkers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by fran on 1/10/18.
 */
public class Supreme {


    private int x ;
    Supreme(){
        this(10);           // Supreme() create a object and this(44) chain it
        x=5;
    }

    void method1(List<String> a){
        System.out.println(" aaa");
    }

    Supreme(int x){
        this.x= x;
    }

    private void max(){
        this.x=7;
        //this(77);         #### as it create new object it has to be first.


    }

    private static void dum(Tink tx){
        tx=Tink.ti;
    }


    public static void main(String[] args) {


/*        BaseInterface bi = new BaseInterface() {
            @Override
            public String getMyName() {
                return "22";
            }
        };*/

    Tink.x=2;


        // Tink t= Tink.ti;
            //System.out.println(t.x);
    }

}
