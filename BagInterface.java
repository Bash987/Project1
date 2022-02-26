public interface BagInterface <T>
{
    public int CurrentSize();

    public boolean isEmpty();

    public boolean add(T newEntry);

    public T remove();
    
    public boolean remove(T anEntry);

    public void clear();

    public int getFrequencyOf(T anEntry);

    public boolean contains(T anEntry);

    public T[] toArray();
    
    public BagInterface<T> union(BagInterface <T> otherBag); // union interface method

    public BagInterface <T> intersection(BagInterface <T> otherBag); // intersection interface method
    
    public BagInterface <T> difference(BagInterface <T> otherBag); // difference interface method
}
