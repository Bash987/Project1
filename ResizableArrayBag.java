import java.util.Arrays;
public class ResizableArrayBag <T> implements BagInterface <T> {
    
    private T[] bag;
    private static final int Default_Capacity = 25;
    private int numberOfEntries;
    private boolean integrityOk;
    private static final int Max_Capacity = 1000;

    private void checkIntegrity()
    {
        if(!integrityOk)
        {
            throw new SecurityException("ArrayBag object is coorupt please investigate.");
        }
    }

    private void checkCapacity(int capacity)
    {
        if (capacity > Max_Capacity)
        {
            throw new IllegalStateException("Attempt to make a bag with" +
                                            " capactity that exceeds maximum capavity of: " 
                                            + Max_Capacity);
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
        this(Default_Capacity);
    }


    public ResizableArrayBag(int capacity)
    {
        if (capacity <= Max_Capacity)
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


    public int CurrentSize()
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
}
