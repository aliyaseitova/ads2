import java.util.NoSuchElementException;

public class MyQueue<T> {
    private MyLinkedList<T> list; // Using MyLinkedList as the underlying data structure

    // Constructor to initialize the queue with an empty list
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    // Adds an element to the end of the queue
    public void offer(T element) {
        list.add(element); // Adds the element to the end of the list (end of the queue)
    }

    // Removes and returns the element at the front of the queue
    public T poll() {
        // Check if the queue is empty
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        // Removes and returns the first element of the list (front of the queue)
        return list.remove(0);
    }

    // Returns the element at the front of the queue without removing it
    public T peek() {
        // Check if the queue is empty
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        // Returns the first element of the list (front of the queue)
        return list.get(0);
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Returns the size of the queue
    public int size() {
        return list.size();
    }
}

