import java.io;
import java.util; 
public class bagDriver
{
    public static void main(String[] args)
    {

        System.out.println("Creating an empty bag");
        BagInterface<String> aBag = new LinkedBag<>();

        aBag.add("apples");
        aBag.add("walnuts");
        aBag.add("milk");
        aBag.add("water");
        aBag.add("cookies");
        aBag.add("pear");
        
        System.out.println(Arrays.toString(aBag.toArray()));

        System.out.println("Creating an empty bag");
        BagInterface<String> bBag = new LinkedBag<>();

        bBag.add("oranges");
        bBag.add("walnuts");
        bBag.add("tea");
        bBag.add("water"); 

        System.out.println(Arrays.toString(bBag.toArray())); 
        
        System.out.println("Creating an empty bag");
        BagInterface<String> cBag = new ResizableArrayBag<>();

        cBag.add("oranges");
        cBag.add("walnuts");
        cBag.add("tea");
        cBag.add("water"); 
        cBag.add("garlic");
        cBag.add("pasta"); 

        cBag.add("flowers");

        cBag.add("flowers"); 

        System.out.println(Arrays.toString(cBag.toArray()));

        System.out.println("Creating an empty bag");
        BagInterface<String> dBag = new ResizableArrayBag<>();

        dBag.add("oranges");
        dBag.add("walnuts");
        dBag.add("tea");
        dBag.add("oranges");

        System.out.println(aBag.toArray());
        
        System.out.println(Arrays.toString(dBag.toArray()));      
        System.out.println("union of bag a and bag b");
        System.out.println(Arrays.toString(aBag.union(bBag).toArray()));        
        System.out.println("union of bag b and bag c");
        System.out.println(Arrays.toString(bBag.union(cBag).toArray()));       
        System.out.println("union of bag c and bag d");
        System.out.println(Arrays.toString(cBag.union(dBag).toArray()));
        System.out.println("union of bag d and bag a");
        System.out.println(Arrays.toString(dBag.union(aBag).toArray()));

        System.out.println("union of bag a and bag b");
        System.out.println(Arrays.toString(aBag.intersection(bBag).toArray()));        
        System.out.println("union of bag b and bag c");
        System.out.println(Arrays.toString(bBag.intersection(cBag).toArray()));        
        System.out.println("union of bag c and bag d");
        System.out.println(Arrays.toString(cBag.intersection(dBag).toArray()));        
        System.out.println("union of bag d and bag a");
        System.out.println(Arrays.toString(dBag.intersection(aBag).toArray()));

        System.out.println("union of bag a and bag b");
        System.out.println(Arrays.toString(aBag.difference(bBag).toArray()));       
        System.out.println("union of bag b and bag c");
        System.out.println(Arrays.toString(bBag.difference(cBag).toArray()));        
        System.out.println("union of bag c and bag d");
        System.out.println(Arrays.toString(cBag.difference(dBag).toArray()));       
        System.out.println("union of bag d and bag a");
        System.out.println(Arrays.toString(dBag.difference(aBag).toArray()));
    }
}
