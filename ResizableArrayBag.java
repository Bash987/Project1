import java.util.Arrays;
public class ResizableArrayBag <T> implements BagInterface <T> {
    
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;
    private boolean integrityOk;
    private static final int MAX_CAPACITY = 10000;

    private void checkIntegrity()
    {
        if(!integrityOk)
        {
            throw new SecurityException("ArrayBag object is coorupt please investigate.");
        }
    }

    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to make a bag with" +
                                            " capactity that exceeds maximum capavity of: " 
                                            + MAX_CAPACITY);
        }
    }

    private void doubleCapacity()
    {
        int newLength = 2* bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf( bag, newLength);
    }
    
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }


    public ResizableArrayBag(int capacity)
    {
        if (capacity <= MAX_CAPACITY)
        {
            numberOfEntries = 0;

        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];

        bag = tempBag;
        }

        else 
            throw new IllegalStateException("Attempted to make a bag which"
            + " exceeds maximum capacity.");
    }


    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }


    public boolean add( T newEntry)
    {
        checkIntegrity();
        boolean result = true;
        if (isArrayFull())
        {
            doubleCapacity();;
        }

        else
        {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }

        return result;
    }


    public boolean isArrayFull()
    {
        if (numberOfEntries == bag.length)
            return true;
        else
            return false;
    }


    public int getCurrentSize()
    {
        return numberOfEntries;
    }


    public T remove()
    {
        checkIntegrity();
        T result = removeEntry(numberOfEntries -1);
        return result;
    }


    public boolean remove( T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }


    private int getIndexOf(T anEntry)
    {
        int location = -1;
        boolean found = false;
        int index = 0;

        while(!found && (index < numberOfEntries))
        {
            if(anEntry.equals(bag[index]))
            {
                found = true;
                location = index;
            }
            index++;
        }
        
        return location;
    }


    private T removeEntry(int givenIndex)
    {
        T result = null;

        if(!isEmpty() && (givenIndex >0))
        {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries-1] = null;
            numberOfEntries--;
        }

        return result;

    }


    public void clear()
    {
        while (!isEmpty())
            remove();
    }
    

    public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();
        int counter = 0;

        for (int index = 0; index < numberOfEntries; index ++)
        {
            if(anEntry.equals(bag[index]))
            {
                counter++;
            }
        }

        return counter;
    }


    public boolean contains( T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry) > -1;

    }


    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] Array = (T[]) new Object[numberOfEntries];

        for (int index = 0; index < numberOfEntries ; index++)
        {
            Array[index] = bag[index];
        }

        return Array;
    }

    /**implelemtation of union method
        @param paramBag second bag gets merged with first bag 
        @return Baginterface which is union of a specified bag and paramBag
    */
    public BagInterface <T> union(BagInterface <T> paramBag) 
    {
        BagInterface<T> unionBag = new ResizableArrayBag<>();
        
        if (paramBag == null)
        {
            {
                throw new IllegalStateException("Bag 2 is null");
            }
        }

        //add info from bag 1 into bag3 
        for(int i = 0;i < this.getCurrentSize(); i++)
        {
            newBag.add(this.bag[i]);
        }

        //add item from bag2 to bag3
        for (int j = 0; j < paramBag.getCurrentSize(); j++)
        {
            unionBag.add(paramBag.bag[j]);
        }

        return unionBag;
    }

    
    /**implelemtation of union method
        @param paramBag second bag gets merged with first bag 
        @return Baginterface which is union of a specified bag and paramBag
    */
    public BagInterface <T> intersection(BagInterface <T> paramBag)
    {
       
    }


    /**implelemtation of union method
        @param paramBag second bag which will be compared to another specified bag
        @return BagInterface that is the result the differnce of paramBag and another specifed bag
    */
    public BagInterface <T> difference(BagInterface <T> paramBag)
    {
        //sanatize user input
        if (paramBag == null)
        {
            {
                throw new IllegalStateException("Bag 2 is null we cannot use a null bag in this method");
            }
        }

        //prepare data which will be returned
        BagInterface<T> diffBag = new ResizableArrayBag<>();

        //making an bag to hold items we have already checked for
        BagInterface<T> tempBag = new ResizableArrayBag<>();

        //declare variables to get freqency of acertain item in the bags
        int bagFreq1 = 0; //gets frequecy of item in bag 1
        int bagFreq2 = 0; //gets frequecy of item in bag 2

        //gets frequency of a certain item in bag1 and then checks for that in bag2
        for(int i = 0; i < this.getCurrentSize(); i++)
        { 
            if (tempBag.contains(this.bag[i]))
                continue;
            
            bagFreq1 = getFrequencyOf(this.bag[i]); 
            
            //checks to see if item is in bag 2 and if it is, will assign amount of item to bagFreq2
            if (paramBag.contains(this.bag[i]))
            {
                for(int j = 0; j < paramBag.getCurrentSize(); j++)
                {       
                    bagFreq2 = paramBag.getFrequencyOf(this.bag[i]);
                }
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
                    diffBag.add(this.bag[i]);
                }
                    
                tempBag.add(this.bag[i]); //add item to diffBag in to skip repeat value of this.bag[i]
            }

            else if (bagFreq1 < bagFreq2 && bagFreq1 != 0)
            {
                for(int l = 0; l < bagFreq1; l++)
                {
                        diffBag.add(this.bag[i]);
                }

                tempBag.add(this.bag[i]);
            }

        }
        //returns bag3 as intersection of bag1 and bag2
        return diffBag;
    }
}


