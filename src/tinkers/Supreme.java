package tinkers;

/**
 * Created by fran on 1/10/18.
 */
public class Supreme {


    private int x ;
    Supreme(){
        this(10);           // Supreme() create a object and this(44) chain it
        x=5;
    }

    Supreme(int x){
        this.x= x;
    }

    private void max(){
        this.x=7;
        //this(77);         #### as it create new object it has to be first.


    }

    public static void main(String[] args) {

    }

}
