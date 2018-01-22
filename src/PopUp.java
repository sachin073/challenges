import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sachin on 24/12/17.
 * Pop-Up Orientation
 In web application development, it is often required to draw a pop-up window on top of a web page when the user clicks on an icon on the page that brings up the pop-up.
 You are given a web page with width
 x and height
 y, a pop-up window with width
 l and height
 m, and an icon at distance
 a from the left of the page and distance
 b from the bottom of the page.
 Your program should output the orientation in which the pop-up can be rendered fully, relative to the icon, within the page dimensions. The orientation of pop up should be such that it lies completely within the page.

 There are4 possible orientations: bottom-right, bottom-left, top-right and top-left, in the same order of preference. In other words, you should first attempt to render the pop-up bottom-right, and if that is not possible, try bottom-left, and so on.

 Note: Icon location and pop-up size are such that the pop-up can always be fully rendered within the page.

 Sample Input
 4
 1024 768 200 300 200 600
 1024 768 200 300 1000 600
 1024 768 200 300 200 200
 1024 768 200 300 900 100


 Sample Output
 bottom-right
 bottom-left
 top-right
 top-left
      |
      |
 -----|-------
      |
      |

 */
public class PopUp {


    public static void main(String[] args) {

        BufferedReader inpReader  = new BufferedReader(new InputStreamReader(System.in));
        try {
         int tests =Integer.parseInt(inpReader.readLine());

         while (tests > 0){
             String temp[] = inpReader.readLine().split(" ");

            int pageWidth,pageHeight,popUpWidth,popUpHeight,xLocOfbutton,yLocOfButton;

             pageWidth = Integer.parseInt(temp[0]);
             pageHeight = Integer.parseInt(temp[1]);
             popUpWidth = Integer.parseInt(temp[2]);
             popUpHeight = Integer.parseInt(temp[3]);
             xLocOfbutton = Integer.parseInt(temp[4]);
             yLocOfButton = Integer.parseInt(temp[5]);

             boolean found =false;
             if (  popUpHeight <= yLocOfButton && ( (pageWidth -xLocOfbutton) >= popUpWidth)){
                 System.out.println("bottom-right");
                 found =true;
             }else if (popUpHeight <= yLocOfButton && popUpWidth <= xLocOfbutton){
                 System.out.println("bottom-left");
                 found =true;
             }else if ( ((pageWidth -yLocOfButton) >= popUpHeight ) && ( (pageWidth - xLocOfbutton) >= popUpWidth) ){
                 System.out.println("top-right");
                 found =true;
             }else if ( ((pageWidth - yLocOfButton) >= popUpHeight ) && (xLocOfbutton >= popUpWidth)){
                 System.out.println("top-left");
                 found =true;
             }

             if (found){
                 tests--;
                 continue;
             }
             if ( popUpWidth <= yLocOfButton && ( (pageWidth -xLocOfbutton) >= popUpHeight)){
                 System.out.println("bottom-right");
             }else if (popUpWidth <= yLocOfButton && popUpHeight <= xLocOfbutton){
                 System.out.println("bottom-left");
             }else if ( ((pageWidth -yLocOfButton) >= popUpWidth ) && ( (pageWidth - xLocOfbutton) >= popUpHeight) ){
                 System.out.println("top-right");
             }else if ( ((pageWidth - yLocOfButton) >= popUpWidth ) && (xLocOfbutton >= popUpHeight)){
                 System.out.println("top-left");
             }
             tests--;

         }


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
