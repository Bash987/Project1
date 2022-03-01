public class LinkedBagTest
{
    public static void main(String[] args)
    {
        /** Tests on a bag that is empty */
        System.out.println("Creating an empty bag");
        BagInterface<String> aBag = new LinkedBag<>();
        displayBag(aBag);
        testIsEmpty(abag, true);
        String[] testStrings1 = {" ", "B"};
        testFrequency(aBag, testStrings1);
        testContains(abag, testStrings1);
        testRemove(aBag, testStrings1);

        /**Adding strings*/
        String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
            testAdd(aBag, contentsOfBag);


        /**Tests on a bag that is not empty*/
        testIsEmpty(aBag, false);
        String[] testStrings2 = {"A", "B", "C", "D", "Z"};
        testFrequency(aBag, testStrings2);
        testContains(aBag, testStrings2);

        /**Removing strings*/
        String[] testStrings3 = {" ", "B", "A", "C", "Z"};
        testRemove(aBag, testStrings3);

        System.out.println("\nClearing the bag:");
        aBag.clear();
        testIsEmpty(aBag, true);
        displayBag(aBag);
        
        private static void testDifference(BagInterface<String> bag1, BagInterface<String> bag2){
            bag1.difference(bag2);
            System.out.println("testDifference ");
            displayBag(bag1);
    
        } /** end testDifference*/
    
        private static void testIntersection(BagInterface<String> aBag, BagInterface<String> bag2){
            bag1.intersection(bag2);
            System.out.println("testIntersection ");
            displayBag(bag1);
        } /** end testIntersection*/
    
        private static void testUnion(BagInterface<String> aBag, BagInterface<String> bag2){
            bag1.union(bag2);
            System.out.println("testUnion ");
            displayBag(bag1);
        } /** end testUnion */
      /** end ResizableArrayBagTest */
    } /** end main */
} 
