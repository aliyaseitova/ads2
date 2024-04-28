public interface MyList<T> {

    // Adds an element to the end of the list
    void add(T element);

    // Inserts an element at the specified index in the list
    void add(int index, T element);

    // Retrieves the element at the specified index in the list
    T get(int index);

    // Removes the element at the specified index in the list and returns it
    T remove(int index);

    // Returns the number of elements in the list
    int size();

    // Returns true if the list contains no elements, false otherwise
    boolean isEmpty();

    // Returns true if the list contains the specified element, false otherwise
    boolean contains(T element);

    // Removes all elements from the list
    void clear();

    // Returns an iterator over the elements in the list
    MyIterator<T> iterator();
}
