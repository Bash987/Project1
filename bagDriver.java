public class BagDriver
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

        System.out.println("Creating an empty bag");
        BagInterface<String> bBag = new LinkedBag<>();

        bBag.add("oranges");
        bBag.add("walnuts");
        bBag.add("tea");
        bBag.add("water"); 

        System.out.println("Creating an empty bag");
        BagInterface<String> cBag = new ResizableArrayBag<>();

        cBag.add("oranges");
        cBag.add("walnuts");
        cBag.add("tea");
        cBag.add("water"); 
        cBag.add("garlic");
        cBag.add("pasta"); 
        cBag.add("flowers");

        System.out.println("Creating an empty bag");
        BagInterface<String> dBag = new ResizableArrayBag<>();

        dBag.add("oranges");
        dBag.add("walnuts");
        dBag.add("tea");
        dBag.add("oranges");

        System.out.println(aBag.toArray());
    }
}