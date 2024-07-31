import java.util.*;
public class TaskManager{
    private Task head;
    private Task tail;

    public TaskManager() {
        this.head = null;
    }
    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if(head==null)
        {
            head=newTask;
        }
        else{
            Task current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newTask;
        }
        System.out.println("Task " + taskName + " added.");
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        Task current = head;
        Task previous = null;

        while (current != null) {
            if (current.taskId == taskId) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = current.next;
                }
                System.out.println("Task " + taskId + " deleted.");
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Task " + taskId + " not found.");
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Status: " + current.status);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner in=new Scanner(System.in);
        while(true)
        {
            System.out.println(" ------------------------");
            System.out.println("1.ADD TASSK ");
            System.out.println("2.SEARCH TASK");
            System.out.println("3.DELETE TASK");
            System.out.println("4.TRAVERSE TASK");
            System.out.println("---------------------------");
            System.out.println("enter choice: ");
            int ch = in.nextInt();
            in.nextLine(); 
            switch(ch)
            {
            case 1:
            {
                System.out.println("1.Add task");
                System.out.println("Enter task id to be added: ");
                int taskid=in.nextInt();
                in.nextLine(); 
                System.out.println("Enter task name to be added: ");
                String taskName=in.nextLine();
                System.out.println("Enter task status to be addded: ");
                String status=in.nextLine();
                taskManager.addTask(taskid,taskName,status);
                break;
            }
            case 2:
            {
                System.out.println("2.Search task");
                System.out.println("enter task id to search the task: ");
                int srch=in.nextInt();
                Task task = taskManager.searchTask(srch);
                if (task != null) 
                {
                    System.out.println("Found task: " + task.taskName + " with status " + task.status);
                } else
                 {
                    System.out.println("Task not found.");
                }
                break;
            }
            case 3:
            {
                System.out.println("3.Delete task");
                System.out.println("Enter taskId to delete task: ");
                int deltask=in.nextInt();
                taskManager.deleteTask(deltask);
                break;
            }
            case 4:
            {
                System.out.println("4.Traverse task");
                taskManager.traverseTasks();
            }
        }
        }
        
    }
}
