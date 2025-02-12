
// Task Node Class (Circular Linked List)
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Task Scheduler using Circular Linked List
class TaskScheduler {
    private TaskNode head;
    private TaskNode tail;
    private TaskNode currentTask; // Pointer to track current task

    // Add a task at the beginning
    public void addTaskAtFirst(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular link
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular nature
        }
    }

    // Add a task at the end
    public void addTaskAtLast(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular nature
        }
    }

    // Add a task at a specific position
    public void addTaskAtIndex(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 1) {
            addTaskAtFirst(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        int count = 1;

        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode; // If inserted at last position
        }
    }

    // Remove a task by Task ID
    public void removeTask(int taskId) {
        if (head == null) return;

        TaskNode temp = head, prev = null;

        // Check if head itself holds the taskId
        if (temp.taskId == taskId) {
            if (head == tail) { // If only one node is present
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head; // Maintain circular link
            }
            return;
        }

        // Traverse the list
        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.taskId != taskId);

        if (temp == head) {
            System.out.println("Task not found!");
            return;
        }

        prev.next = temp.next;
        if (temp == tail) {
            tail = prev; // If deleting the last node
        }
    }

    // View the current task and move to the next task in circular order
    public void viewAndMoveToNextTask() {
        if (currentTask == null) {
            currentTask = head;
        }

        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " | Priority: " + currentTask.priority + " | Due Date: " + currentTask.dueDate);
            currentTask = currentTask.next; // Move to next task
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks starting from head
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        System.out.println("Tasks in Scheduler:");
        do {
            System.out.println("Task ID: " + temp.taskId + " | Task: " + temp.taskName + " | Priority: " + temp.priority + " | Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println("Task Found: " + temp.taskName + " | Priority: " + temp.priority + " | Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}

// Main Class
public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addTaskAtFirst(1, "Submit Report", 2, "2025-02-15");
        scheduler.addTaskAtLast(2, "Team Meeting", 1, "2025-02-12");
        scheduler.addTaskAtFirst(3, "Code Review", 3, "2025-02-13");
        scheduler.addTaskAtIndex(4, "Project Deadline", 1, "2025-02-20", 2);

        // Display tasks
        scheduler.displayTasks();
        System.out.println("------------------------------------------------");

        // Searching tasks by priority
        scheduler.searchTaskByPriority(1);
        System.out.println("------------------------------------------------");

        // Viewing current task and moving to next
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();
        System.out.println("------------------------------------------------");

        // Removing a task
        scheduler.removeTask(2);
        scheduler.displayTasks();
    }
}

