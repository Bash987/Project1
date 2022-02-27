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
        @return Baginterface which is union of bag1 and paramBag
    */
    public BagInterface <T> union(BagInterface <T> paramBag) 
    {

    }

    /**implelemtation of union method
        @param paramBag second bag compared with a bag 
        @return Baginterface which is difference of certain bag and paramBag
    */
    public BagInterface <T> difference(BagInterface <T> paramBag)
    {
}


