public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list; // Using MyArrayList as the underlying data structure

    // Constructor to initialize the min-heap with an empty list
    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    // Inserts an element into the min-heap
    public void insert(T element) {
        list.add(element); // Adds the element to the end of the list
        heapifyUp(list.size() - 1); // Restores the min-heap property by moving the element up as necessary
    }

    // Deletes and returns the minimum element from the min-heap
    public T deleteMin() {
        // Check if the min-heap is empty
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        // Retrieve the minimum element (root of the min-heap)
        T min = list.get(0);
        // Replace the root with the last element and restore the min-heap property
        T last = list.remove(list.size() - 1);
        if (!isEmpty()) {
            list.set(0, last);
            heapifyDown(0); // Restores the min-heap property by moving the root down as necessary
        }
        return min;
    }

    // Checks if the min-heap is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Restores the min-heap property by moving an element up as necessary
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2; // Calculate the parent index
            // If the element is smaller than its parent, swap them
            if (list.get(index).compareTo(list.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex; // Move up to the parent
            } else {
                break; // Stop if the min-heap property is satisfied
            }
        }
    }

    // Restores the min-heap property by moving an element down as necessary
    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1; // Calculate the left child index
        int rightChildIndex = 2 * index + 2; // Calculate the right child index
        int smallest = index; // Assume the current node is the smallest

        // Check if the left child exists and is smaller than the current node
        if (leftChildIndex < list.size() && list.get(leftChildIndex).compareTo(list.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }
        // Check if the right child exists and is smaller than the current node
        if (rightChildIndex < list.size() && list.get(rightChildIndex).compareTo(list.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }
        // If the smallest node is not the current node, swap them and continue heapifying down
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest); // Recursively heapify down the affected subtree
        }
    }

    // Swaps two elements in the list
    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

