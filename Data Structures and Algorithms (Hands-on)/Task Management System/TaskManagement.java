public class TaskManagement {
    // Node Class
    class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // Add Task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task Added Successfully.");
    }

    // Search Task
    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Traverse Tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No Tasks Available.");
            return;
        }
        System.out.println("\nTask List:");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task List Empty.");
            return;
        }

        // Delete first node
        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task Deleted Successfully.");
            return;
        }

        Node temp = head;
        while (temp.next != null &&
               temp.next.task.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Task Not Found.");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Task Deleted Successfully.");
    }

    // Main Method
    public static void main(String[] args) {
        TaskManagement tm = new TaskManagement();
        Task t1 =
                new Task(
                        101,
                        "Design Homepage",
                        "Pending");
        Task t2 =
                new Task(
                        102,
                        "Develop Login Module",
                        "In Progress");
        Task t3 =
                new Task(
                        103,
                        "Database Integration",
                        "Completed");

        // Add Tasks
        System.out.println("ADDING TASKS");
        tm.addTask(t1);
        tm.addTask(t2);
        tm.addTask(t3);
        tm.traverseTasks();

        // Search Task
        System.out.println("\nSEARCH TASK");
        Task result = tm.searchTask(102);
        if (result != null) {
            System.out.println("Task Found:");
            System.out.println(result);
        }
        else {
            System.out.println("Task Not Found.");
        }

        // Delete Task
        System.out.println("\nDELETE TASK");
        tm.deleteTask(102);
        tm.traverseTasks();
    }
}
