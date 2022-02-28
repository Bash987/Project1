<<<<<<< HEAD
//3 methods union, intersection, and difference 
//implentation of the ADT bag by linked chain 

/**
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full.
    INCOMPLETE DEFINITION; includes definitions for the methods add,
    toArray, isEmpty, and getCurrentSize.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public final class LinkedBag<T> implements BagInterface<T>
{
	private Node firstNode;       // Reference to first node
=======
public final class LinkedBag <T> implements BagInterface <T>
{
    private Node firstNode;       // Reference to first node
>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a
	private int numberOfEntries;

	public LinkedBag()
	{
		firstNode = null;
<<<<<<< HEAD
      numberOfEntries = 0;
	} // end default constructor

	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True. */
=======
        numberOfEntries = 0;
	} // end default constructor

>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
      // Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;  // Make new node reference rest of chain
                                 // (firstNode is null if chain is empty)
      firstNode = newNode;       // New node is at beginning of chain
		numberOfEntries++;
      
		return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.data;
         index++;
         currentNode = currentNode.next;
      } // end while
      
      return result;
      // Note: The body of this method could consist of one return statement,
      // if you call Arrays.copyOf
	} // end toArray
   
	/** Sees whether this bag is empty.
       @return  True if the bag is empty, or false if not. */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	} // end isEmpty
   
	/** Gets the number of entries currently in this bag.
       @return  The integer number of entries currently in the bag. */
	public int getCurrentSize()
	{
		return numberOfEntries;
	} // end getCurrentSize
   
<<<<<<< HEAD
// STUBS:
=======
>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
                was successful, or null. */
	public T remove()
   {
<<<<<<< HEAD
      return null; // STUB
=======
      T result = null;

      if (firstNode != null)
      {
         result = firstNode.data;
         firstNode = firstNode.next;
         numberOfEntries--;
      }

      return result;
>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a
   } // end remove
   
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false otherwise. */
   public boolean remove(T anEntry)
   {
<<<<<<< HEAD
      return false; // STUB
   } // end remove
=======
      boolean result = false;
      Node nodeN = getReferenceTo(anEntry);

      if (nodeN != null)
      {
         nodeN.data = firstNode.data;
         firstNode = firstNode.next;
         numberOfEntries--;

         result = true;
      }
      return result;
   } // end remove

   private Node getReferenceTo(T anEntry)
      {
         boolean found = false;
         Node currentNode = firstNode;
         while (!found && (currentNode != null))
         {
            if (anEntry.equals(currentNode.getData()))
            found = true;

            else
            currentNode = currentNode.getNextNode();
         } // end while
     
      return currentNode;
      } // end getReferenceTo
>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a
	
	/** Removes all entries from this bag. */
	public void clear()
   {
<<<<<<< HEAD
      // STUB
=======
      while (!isEmpty())
      {
         remove();
      }
>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a
   } // end clear
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry)
   {
<<<<<<< HEAD
      return 0; // STUB
=======
      int frequency = 0;
      int counter = 0;
      Node currentNode = firstNode;

      while ((counter < numberOfEntries) && (currentNode != null))
      {
         if (anEntry.equals(currentNode.data))
         {
            frequency++;
         }

         else
         {
            counter++;
            currentNode = currentNode.next;
         }
      }
      return frequency;
>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a
   } // end getFrequencyOf
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to locate.
		 @return  True if the bag contains anEntry, or false otherwise. */
	public boolean contains(T anEntry)
   {
<<<<<<< HEAD
      return false; // STUB
=======
      boolean found = false;
      Node currentNode = firstNode;

      while (!found && (currentNode != null))
      {
         if (anEntry.equals(currentNode.data))
         {
            found = true;
         }
          
         else
         {
            currentNode = currentNode.next;
         }
        
      }
        
      return found;
>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a
   } // end contains

	private class Node
	{
<<<<<<< HEAD
	  private T    data; // Entry in bag
=======
	  private T data; // Entry in bag
>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
<<<<<<< HEAD
	} // end Node
} // end LinkedBag



=======

      private T getData()
      {
         return data;
      }//end get data

      private void setData(T newData)
      {
         data = newData;
      }// end setData

      private Node getNextNode()
      {
         return next;
      }//end getNextNode;

      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      }

	} // end Node
    
   public BagInterface<T> union(BagInterface <T> otherBag)
   {
	   BagInterface<T> unionBag = new LinkedBag<>() ;
        
      if (otherBag == null)
         {
            {
               throw new IllegalStateException("Bag 2 is null");
            }
         }

      //make an array for first bag
      T[] bag1 = this.toArray();

      //add info from bag 1 into bag3 
      for(int i = 0; i < this.getCurrentSize(); i++)
      {
         unionBag.add(bag1[i]);
      }

      //create an array for second bag
      T[] bag2 = otherBag.toArray();

      //add items from bag2 to unionBag
      for (int j = 0; j < otherBag.getCurrentSize(); j++)
      {
         unionBag.add(bag2[j]);
      }

      return unionBag;
    }

   public BagInterface <T> intersection(BagInterface <T> otherBag)
   {
      //sanatize user input
      if (otherBag == null)
      {
         {
            throw new IllegalStateException("Bag 2 is null we cannot use a null bag in this method");
         }
      }

      //prepare data which will be returned
      BagInterface<T> intersectBag = new LinkedBag<>();

      //create temporary bag to house what has already been put into bag3
      BagInterface<T> tempBag = new LinkedBag<>();

      //prepare array to use in loops
      T[] bag = this.toArray();

      //declare variables to get freqency of acertain item in the bags
      int bagFreq1 = 0; //gets frequecy of item in bag 1
      int bagFreq2 = 0; //gets frequecy of item in bag 2

      //gets frequency of a certain item in bag1 and then checks for that in bag2
      for(int i = 0; i < this.getCurrentSize(); i++) //how to stop this loop from looking at same item in different index? contains???
      {
         if (tempBag.contains(bag[i]))
             continue;

         bagFreq1 = getFrequencyOf(bag[i]); 
           
         //checks to see if item is in bag 2 and if it is, will assign amount of item to bagFreq2
         if (otherBag.contains(bag[i]))
         {      
            bagFreq2 = otherBag.getFrequencyOf(bag[i]);

         }

         else
         {
            bagFreq2 = 0;
         }

         //compare to frequency of same item in bag2 and add lowest frequency to bag
         if (bagFreq1 >= bagFreq2 && bagFreq2 != 0)
         {
            for(int k = 0; k < bagFreq2; k++)
            {
               intersectBag.add(bag[i]);
            }

            tempBag.add(bag[i]);
         }

         else if (bagFreq1 < bagFreq2 && bagFreq1 != 0)
         {
            for(int l = 0; l < bagFreq1; l++)
            {
               intersectBag.add(bag[i]);
            }
            tempBag.add(bag[i]);
         }

      }
      //returns bag3 as intersection of bag1 and bag2
      return intersectBag;
    }
    
   public BagInterface <T> difference(BagInterface <T> otherBag)
   {
      //sanatize user input
      if (otherBag == null)
      {
          {
              throw new IllegalStateException("Bag 2 is null we cannot use a null bag in this method");
          }
      }
     
      //prepare data which will be returned
      BagInterface<T> diffBag = new LinkedBag<>();

      //prepare bag to use in loops
      BagInterface<T> tempBag = new LinkedBag<>();

      //prepare arryay to use in loops
      T[] bag1 = this.toArray();

      //declare variables to get freqency of acertain item in the bags
      int bagFreq1 = 0; //gets frequecy of item in bag 1
      int bagFreq2 = 0; //gets frequecy of item in bag 2

      //gets frequency of a certain item in bag1 and then checks for that in bag2
      for(int i = 0; i < this.getCurrentSize(); i++) //how to stop this loop from looking at same item in different index? contains???
      {
         if (tempBag.contains(bag1[i]))
             continue;

         bagFreq1 = getFrequencyOf(bag1[i]); 
         
         //checks to see if item is in bag 2 and if it is, will assign amount of item to bagFreq2
         if (otherBag.contains(bag1[i]))
         {
            bagFreq2 = otherBag.getFrequencyOf(bag1[i]);
         }

         else
         {
            bagFreq2 = 0;
         }

         //compare to frequency of same item in bag2 and add lowest frequency to bag
         if ((bagFreq1 - bagFreq2) > 0)
         {
            for(int k = 0; k < bagFreq2; k++)
            {
               diffBag.add(bag1[i]);
            }

            tempBag.add(bag1[i]);
         }
      }

     return diffBag;
   }

}
>>>>>>> 31ed22f61509181ddf57f7c604be70461a727d5a
