import java.util.Stack;

class QueueUsingStacks {
    private final Stack<Integer> input; // Used for enqueue operation
    private final Stack<Integer> output; // Used for dequeue operation

    public QueueUsingStacks() {
        input = new Stack<>();//for enqueue
        output = new Stack<>();//for dequeue
    }

    // Enqueue operation (Always O(1))
    public void enqueue(int x) {
        input.push(x);
    }

    // Dequeue operation (O(1) amortized, O(n) worst case when transferring elements)
    public int dequeue() {
        peek();
        return output.pop();
    }

    // Peek operation (Returns front element without removing)
    public int peek() {
        if (output.isEmpty()) {
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }    
        return output.peek();    
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());    // 2
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.dequeue()); // 4
    }
}





















// import java.util.Stack;

// class QueueUsingStacks {
//     private Stack<Integer> stack1; // Used for enqueue operation
//     private Stack<Integer> stack2; // Used for dequeue operation

//     public QueueUsingStacks() {
//         stack1 = new Stack<>();//for enqueue
//         stack2 = new Stack<>();//for dequeue
//     }

//     // Enqueue operation (Always O(1))
//     public void enqueue(int x) {
//         stack1.push(x);
//     }

//     // Dequeue operation (O(1) amortized, O(n) worst case when transferring elements)
//     public int dequeue() {
//         if (isEmpty()) {
//             throw new RuntimeException("Queue is empty!");
//         }

//         if (stack2.isEmpty()) {
//             // Transfer elements from stack1 to stack2 (Reverse order)
//             while (!stack1.isEmpty()) {
//                 stack2.push(stack1.pop());
//             }
//         }
//         return stack2.pop(); // Pop the front element
//     }

//     // Peek operation (Returns front element without removing)
//     public int peek() {
//         if (isEmpty()) {
//             throw new RuntimeException("Queue is empty!");
//         }

//         if (stack2.isEmpty()) {
//             while (!stack1.isEmpty()) {
//                 stack2.push(stack1.pop());
//             }
//         }
//         return stack2.peek();
//     }

//     // Check if queue is empty
//     public boolean isEmpty() {
//         return stack1.isEmpty() && stack2.isEmpty();
//     }

//     public static void main(String[] args) {
//         QueueUsingStacks queue = new QueueUsingStacks();
        
//         queue.enqueue(1);
//         queue.enqueue(2);
//         queue.enqueue(3);
        
//         System.out.println(queue.dequeue()); // 1
//         System.out.println(queue.peek());    // 2
//         queue.enqueue(4);
//         System.out.println(queue.dequeue()); // 2
//         System.out.println(queue.dequeue()); // 3
//         System.out.println(queue.dequeue()); // 4
//     }
// }
