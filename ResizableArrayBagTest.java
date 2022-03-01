public class ResizableArrayBagTest{
    public static void main(String[] args){
        /** bag1 and bag2 */
        BagInterface<String> bag1 = new ResizableArrayBag<String>();
        BagInterface<String> bag2 = new ResizableArrayBag<String>();
    } /** end main */

    private static void testDifference(BagInterface<String> bag1, BagInterface<String> bag2){
        bag1.difference(bag2);
        System.out.println("testDifference ");
    } /** end testDifference */

    private static void testIntersection(BagInterface<String> bag1, BagInterface<String> bag2){
        bag1.intersection(bag2);
        System.out.println("testIntersection ");
    } /** end testIntersection */

    private static void testUnion(BagInterface<String> bag1, BagInterface<String> bag2){
        bag1.union(bag2);
        System.out.println("testUnion ");
    } /** end testUnion */

} /** end ResizableArrayBagTest */
