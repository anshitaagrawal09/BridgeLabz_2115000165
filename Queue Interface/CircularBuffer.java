import java.util.Arrays;
class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;
    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }
    // Insert element into buffer
    public void enqueue(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;
        if (count == size) {
            front = (front + 1) % size;  // Overwrite oldest element
        } else {
            count++;
        }
    }
    // Remove oldest element
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Buffer is empty!");
        int value = buffer[front];
        front = (front + 1) % size;
        count--;
        return value;
    }
    // Get the front element
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Buffer is empty!");
        return buffer[front];
    }
    // Check if buffer is empty
    public boolean isEmpty() {
        return count == 0;
    }
    // Check if buffer is full
    public boolean isFull() {
        return count == size;
    }
    // Print buffer contents
    public void printBuffer() {
        System.out.print("Buffer: ");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        cb.printBuffer(); // Output: [1, 2, 3]
        cb.enqueue(4); // Overwrites oldest element (1)
        cb.printBuffer(); // Output: [2, 3, 4]
        System.out.println("Dequeued: " + cb.dequeue()); // Output: 2
        cb.printBuffer(); // Output: [3, 4]
        cb.enqueue(5);
        cb.printBuffer(); // Output: [3, 4, 5]
    }
}
