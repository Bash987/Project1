public class ResizableArrayBagTest{
    public static void main(String[] args){
        /** a bag that is not full */
        BagInterface<String> aBag = new ResizableArrayBag<String>();

        /** tests on an empty bag */
        testIsFull(aBag, false);

        /** adding strings */
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "C"};
        testAdd(aBag, contentsOfBag1);
        testIsFull(aBag, false);

        /** a bag that will be full */
        aBag = new ResizableArrayBag<String>(7);
        System.out.println("\nA new empty bag:");

        /** tests on an empty bag */
        testIsFull(aBag, false);

        /** adding strings */
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D"};
        testAdd(aBag, contentsOfBag2);
        testIsFull(aBag, true);

        /** tests on an empty bag */
        testIsFull(aBag, false);

        /** bag1 and bag2 */
        BagInterface<String> bag1 = new ResizableArrayBag<String>();
        BagInterface<String> bag2 = new ResizableArrayBag<String>();
    } /** end main */

    /** tests the method isFull */
    /** correctResult indicates what isFull should return */

    private static void testIsFull(BagInterface<String> aBag, boolean correctResult){
        System.out.print("\nTesting the method isFull with ");
        if(correctResult){
            System.out.println("a full bag");
        }else {
            System.out.println("a bag that is not full");
        }

        System.out.print("isFull finds the bag ");
        if(correctResult && aBag.isFull()){
            System.out.println("full: OK.");
        }else if(correctResult){
            System.out.println("not full, but it is full: ERROR.");
        }else if(!correctResult && aBag.isFull()){
            System.out.println("full, but it is full: ERROR.");
        }else{
            System.out.println("not full: OK.");
        }
    } /** end testIsFull */

    private static void displayBag(BagInterface<String> aBag){
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++){
            System.out.print(bagArray[index] + " ");
        }// end for
        System.out.println();
    } /** end displayBag */

    /** tests the method add */
    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.println("Adding to the bag: ");
        for (int index = 0; index < content.length; index++){
            aBag.add(content[index]);
            System.out.print(content[index] + " ");
        } /** end for */
        System.out.println();

        displayBag(aBag);
    } /** end testAdd */

    private static void testDifference(BagInterface<String> bag1, BagInterface<String> bag2){
        bag1.difference(bag2);
        System.out.println("testDifference ");
        displayBag(bag1);
    } /** end testDifference */

    private static void testIntersection(BagInterface<String> bag1, BagInterface<String> bag2){
        bag1.intersection(bag2);
        System.out.println("testIntersection ");
        displayBag(bag1);
    } /** end testIntersection */

    private static void testUnion(BagInterface<String> bag1, BagInterface<String> bag2){
        bag1.union(bag2);
        System.out.println("testUnion ");
        displayBag(bag1);
    } /** end testUnion */

} /** end ResizableArrayBagTest */
