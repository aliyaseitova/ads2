import java.util.NoSuchElementException;

// Implementing the MyList interface to create a custom ArrayList
public class MyArrayList<T> implements MyList<T> {
    // Internal array to store elements
    private Object[] array;
    // Size of the ArrayList
    private int size;
    // Default capacity for the ArrayList
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor to initialize the ArrayList with default capacity
    public MyArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Adds an element to the end of the ArrayList
    public void add(T element) {
        // If the ArrayList is full, increase its capacity
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        // Add the element to the end of the ArrayList
        array[size++] = element;
    }

    // Inserts an element at the specified index in the ArrayList
    public void add(int index, T element) {
        // Check if the index is within bounds
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // If the ArrayList is full, increase its capacity
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, index);
            newArray[index] = element;
            System.arraycopy(array, index, newArray, index + 1, size - index);
            array = newArray;
        } else {
            // Shift elements to make space for the new element
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
        }
        size++;
    }

    // Removes the element at the specified index in the ArrayList and returns it
    public T remove(int index) {
        // Check if the index is within bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Get the element to be removed
        T removedElement = get(index);
        // Shift elements to fill the gap left by the removed element
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        // Set the last element to null and decrement size
        array[size - 1] = null;
        size--;
        return removedElement;
    }

    // Retrieves the element at the specified index in the ArrayList
    public T get(int index) {
        // Check if the index is within bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Return the element at the specified index
        return (T) array[index];
    }

    // Sets the element at the specified index in the ArrayList
    public void set(int index, T element) {
        // Check if the index is within bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Set the element at the specified index
        array[index] = element;
    }

    // Returns the size of the ArrayList
    public int size() {
        return size;
    }

    // Returns true if the ArrayList is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns true if the ArrayList contains the specified element, false otherwise
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Removes all elements from the ArrayList
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // Returns an iterator over the elements in the ArrayList
    public MyIterator<T> iterator() {
        return new ArrayListIterator();
    }

    // Internal iterator implementation for the ArrayList
    private class ArrayListIterator implements MyIterator<T> {
        // Current index of the iterator
        private int currentIndex = 0;

        // Returns true if the iterator has more elements, false otherwise
        public boolean hasNext() {
            return currentIndex < size;
        }

        // Returns the next element in the iteration
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            // Return the element at the current index and move to the next index
            return get(currentIndex++);
        }
    }
}

