public class LinkedBagTest
{
    public static void main(String[] args)
    {
        //Tests on a bag that is empty 
        System.out.println("Creating an empty bag");
        BagInterface<String> aBag = new LinkedBag<>();
        displayBag(aBag);
        testIsEmpty(abag, true);
        String[] testStrings1 = {" ", "B"};
        testFrequency(aBag, testStrings1);
        testContains(abag, testStrings1);
        testRemove(aBag, testStrings1);

        //Adding strings
        String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
            testAdd(aBag, contentsOfBag);


        //Tests on a bag that is not empty
        testIsEmpty(aBag, false);
        String[] testStrings2 = {"A", "B", "C", "D", "Z"};
        testFrequency(aBag, testStrings2);
        testContains(aBag, testStrings2);

        //Removing strings
            String[] testStrings3 = {" ", "B", "A", "C", "Z"};
        testRemove(aBag, testStrings3);

        System.out.println("\nClearing the bag:");
        aBag.clear();
        testIsEmpty(aBag, true);
        displayBag(aBag);
    }//end main 
}