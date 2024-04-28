public class Main {

    public static void main(String[] args) {

        // Using MyArrayList
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(5); // Adding element 5 to the list
        arrayList.add(10); // Adding element 10 to the list
        arrayList.add(1, 7); // Inserting element 7 at index 1 in the list
        System.out.println("MyArrayList: " + arrayList.get(1)); // Printing the element at index 1

        // Using MyLinkedList
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Hello"); // Adding "Hello" to the linked list
        linkedList.add("World"); // Adding "World" to the linked list
        linkedList.add(1, "Java"); // Inserting "Java" at index 1 in the linked list
        System.out.println("MyLinkedList: " + linkedList.get(1)); // Printing the element at index 1

        // Using MyStack
        MyStack<Character> stack = new MyStack<>();
        stack.push('a'); // Pushing 'a' onto the stack
        stack.push('b'); // Pushing 'b' onto the stack
        System.out.println("MyStack top: " + stack.peek()); // Printing the top element of the stack

        // Using MyQueue
        MyQueue<Double> queue = new MyQueue<>();
        queue.offer(3.14); // Adding 3.14 to the queue
        queue.offer(2.71); // Adding 2.71 to the queue
        System.out.println("MyQueue front: " + queue.peek()); // Printing the front element of the queue

        // Using MyMinHeap
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(10); // Inserting 10 into the min heap
        minHeap.insert(5); // Inserting 5 into the min heap
        System.out.println("MyMinHeap min: " + minHeap.deleteMin()); // Deleting and printing the minimum element from the min heap
    }
}
