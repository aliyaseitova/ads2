public class MyStack<T> {
    private MyArrayList<T> list; // Using MyArrayList as the underlying data structure

    // Constructor to initialize the stack with an empty list
    public MyStack() {
        list = new MyArrayList<>();
    }

    // Pushes an element onto the stack
    public void push(T element) {
        list.add(element); // Adds the element to the end of the list (top of the stack)
    }

    // Removes and returns the element at the top of the stack
    public T pop() {
        // Check if the stack is empty
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Removes and returns the last element of the list (top of the stack)
        return list.remove(list.size() - 1);
    }

    // Returns the element at the top of the stack without removing it
    public T peek() {
        // Check if the stack is empty
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Returns the last element of the list (top of the stack)
        return list.get(list.size() - 1);
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Returns the size of the stack
    public int size() {
        return list.size();
    }
}

