import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    // Node class to represent elements in the linked list
    private static class Node<T> {
        T data; // Data of the node
        Node<T> next; // Reference to the next node

        // Constructor to initialize a node with data
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Reference to the first node in the linked list
    private int size; // Size of the linked list

    // Constructor to initialize an empty linked list
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Adds an element to the end of the linked list
    public void add(T element) {
        // Create a new node with the given element
        Node<T> newNode = new Node<>(element);
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse the list to find the last node and append the new node
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++; // Increment the size of the list
    }

    // Inserts an element at the specified index in the linked list
    public void add(int index, T element) {
        // Check if the index is within bounds
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // If inserting at the beginning, update the head
        if (index == 0) {
            Node<T> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        } else {
            // Find the node before the specified index
            Node<T> previous = getNode(index - 1);
            // Create a new node with the given element
            Node<T> newNode = new Node<>(element);
            // Insert the new node into the list
            newNode.next = previous.next;
            previous.next = newNode;
        }
        size++; // Increment the size of the list
    }

    // Removes the element at the specified index in the linked list and returns it
    public T remove(int index) {
        // Check if the index is within bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // If removing the first element, update the head
        if (index == 0) {
            T removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        } else {
            // Find the node before the specified index
            Node<T> previous = getNode(index - 1);
            // Get the data of the node to be removed
            T removedData = previous.next.data;
            // Remove the node from the list
            previous.next = previous.next.next;
            size--;
            return removedData;
        }
    }

    // Retrieves the element at the specified index in the linked list
    public T get(int index) {
        // Check if the index is within bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Get the node at the specified index and return its data
        return getNode(index).data;
    }

    // Retrieves the node at the specified index in the linked list
    private Node<T> getNode(int index) {
        Node<T> current = head;
        // Traverse the list until reaching the specified index
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Returns the size of the linked list
    public int size() {
        return size;
    }

    // Returns true if the linked list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns true if the linked list contains the specified element, false otherwise
    public boolean contains(T element) {
        Node<T> current = head;
        // Traverse the list to find the element
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Removes all elements from the linked list
    public void clear() {
        head = null;
        size = 0;
    }

    // Returns an iterator over the elements in the linked list
    public MyIterator<T> iterator() {
        return new LinkedListIterator();
    }

    // Internal iterator implementation for the linked list
    private class LinkedListIterator implements MyIterator<T> {
        private Node<T> current; // Current node in the iteration

        // Constructor to initialize the iterator
        public LinkedListIterator() {
            current = head;
        }

        // Returns true if the iterator has more elements, false otherwise
        public boolean hasNext() {
            return current != null;
        }

        // Returns the next element in the iteration
        public T next() {
            // Check if there is a next element
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            // Get the data of the current node and move to the next node
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}

