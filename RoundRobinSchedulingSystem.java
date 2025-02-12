
// Process Node Class (Circular Linked List)
class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

// Round Robin Scheduling using Circular Linked List
class RoundRobinScheduler {
    private ProcessNode head = null;
    private ProcessNode tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular link
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    // Remove a process after execution
    private void removeProcess(ProcessNode prev, ProcessNode process) {
        if (head == process && head == tail) { // Single process case
            head = tail = null;
        } else if (head == process) { // Removing head
            tail.next = head.next;
            head = head.next;
        } else {
            prev.next = process.next;
            if (process == tail) { // Removing tail
                tail = prev;
            }
        }
    }

    // Simulate Round Robin Scheduling
    public void executeProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        int totalProcesses = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        ProcessNode current = head;
        ProcessNode prev = tail; // To track previous node for removal

        System.out.println("\nStarting Round Robin Scheduling (Time Quantum: " + timeQuantum + ")");
        while (head != null) {
            System.out.println("\nExecuting Processes:");
            displayProcesses();

            int executedTime = Math.min(current.burstTime, timeQuantum);
            current.burstTime -= executedTime;
            totalWaitingTime += totalProcesses * executedTime;
            totalTurnaroundTime += executedTime;

            System.out.println("Process " + current.processId + " executed for " + executedTime + " units.");

            if (current.burstTime == 0) { // Process completed
                System.out.println("Process " + current.processId + " completed execution.");
                removeProcess(prev, current);
                current = prev.next; // Move to next process
            } else {
                prev = current;
                current = current.next; // Move to next process
            }

            totalProcesses++;
        }

        // Calculate and display average waiting and turnaround times
        double avgWaitingTime = (double) totalWaitingTime / totalProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;

        System.out.println("\nRound Robin Scheduling Completed!");
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    // Display all processes in circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }

        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + " | Burst Time: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

// Main Class
public class RoundRobinSchedulingSystem {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Time quantum = 4

        // Adding processes
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 12, 2);

        // Display initial process queue
        scheduler.displayProcesses();

        // Execute Round Robin Scheduling
        scheduler.executeProcesses();
    }
}

