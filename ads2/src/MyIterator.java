public interface MyIterator<T> {

    // Returns true if the iteration has more elements, false otherwise
    boolean hasNext();

    // Returns the next element in the iteration
    T next();
}

