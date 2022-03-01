/**
A test of the constructors and the methods add and toArray,
as defined in the first draft of the class ArrayBag.
*/
public class ArrayBagDemo1
{

    public static void main(String[] args)
{
    // Adding to an initially empty bag with sufficient capacity
    System.out.println("Testing an initially empty bag with" +
         " sufficient capacity:");
    
    BagInterface<String> aBag = new ArrayBag<>();
    String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
    testAdd(aBag, contentsOfBag1);
15
16 // Filling an initially empty bag to capacity
17 System.out.println("\nTesting an initially empty bag that " +
18 " will be filled to capacity:");
19 aBag = new ArrayBag<>(7);
20 String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D",
21 "another string"};
22 testAdd(aBag, contentsOfBag2);
23 } // end main
24
25 // Tests the method add.
26 private static void testAdd(BagInterface<String> aBag,
27 String[] content)
28 {
29 System.out.print("Adding the following strings to the bag:");
30 for (int index = 0; index < content.length; index++)
31 {
32 if (aBag.add(content[index]))
33 System.out.print(content[index] + " ");
34 else
35 System.out.print("\nUnable to add " + content[index] +
36 " to the bag.");
37 } // end for
38 System.out.println();
39
40 displayBag(aBag);
41 } // end testAdd
42
43 // Tests the method toArray while displaying the bag.
44 private static void displayBag(BagInterface<String> aBag)
45 {
46 System.out.println("The bag contains the following string(s):");
47 Object[] bagArray = aBag.toArray();
48 for (int index = 0; index < bagArray.length; index++)
49 {
50 System.out.print(bagArray[index] + " ");
51 } // end for
52
53 System.out.println();
54 } // end displayBag
55 } // end ArrayBagDemo1 