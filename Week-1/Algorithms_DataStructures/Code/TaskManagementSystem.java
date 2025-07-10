class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return "TaskID : " + taskId + ", Name : " + taskName + ", Status : " + status;
    }
}

public class TaskManagementSystem {
    private Task head = null;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println("Task Added: " + taskName);
    }

    public Task searchTask(int taskId) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == taskId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.taskId == taskId) {
            System.out.println(" Task Deleted: " + head.taskName);
            head = head.next;
            return;
        }

        Task prev = head;
        Task current = head.next;

        while (current != null) {
            if (current.taskId == taskId) {
                System.out.println(" Task Deleted: " + current.taskName);
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println(" Task ID " + taskId + " not found.");
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println(" No tasks to display.");
            return;
        }

        System.out.println("\n Task List:");
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();

        system.addTask(1, "Design Module", "Pending");
        system.addTask(2, "Implement Module", "In Progress");
        system.addTask(3, "Test Module", "Pending");

        system.displayTasks();

        System.out.println("\n🔍 Searching for Task 2:");
        Task result = system.searchTask(2);
        System.out.println(result != null ? result : "Task not found.");

        System.out.println("\n Deleting Task 1...");
        system.deleteTask(1);

        system.displayTasks();
    }
}
