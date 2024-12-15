import java.util.*;

public class TodoList {
    private List<Task> tasks; // To store all tasks dynamically
    private Map<String, List<Task>> categorizedTasks; // To categorize tasks
    private PriorityQueue<Task> priorityTasks; // To manage tasks by priority
    private LinkedList<Task> completedTasksHistory; // To track completed tasks

    public TodoList() {
        tasks = new ArrayList<>();
        categorizedTasks = new HashMap<>();
        priorityTasks = new PriorityQueue<>();
        completedTasksHistory = new LinkedList<>();
    }

    public void addTask(String title, String category, int priority) {
        Task newTask = new Task(title, category, priority);
        tasks.add(newTask);

        // Add to category map
        categorizedTasks.putIfAbsent(category, new ArrayList<>());
        categorizedTasks.get(category).add(newTask);

        // Add to priority queue
        priorityTasks.offer(newTask);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index);

            // Remove from category map
            categorizedTasks.get(removedTask.getCategory()).remove(removedTask);

            // Remove from priority queue
            priorityTasks.remove(removedTask);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public boolean markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();

            // Add to completed tasks history
            completedTasksHistory.add(task);
            return true;
        } else {
            System.out.println("Invalid task number.");
            return false;
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i)); // Task number is displayed here
            }
        }
    }

    public void displayTasksByCategory(String category) {
        if (categorizedTasks.containsKey(category)) {
            List<Task> categoryTasks = categorizedTasks.get(category);
            if (categoryTasks.isEmpty()) {
                System.out.println("No tasks in this category.");
            } else {
                for (int i = 0; i < categoryTasks.size(); i++) {
                    System.out.println((i + 1) + ". " + categoryTasks.get(i)); // Task number is displayed here
                }
            }
        } else {
            System.out.println("Category not found.");
        }
    }

    public void displayPriorityTasks() {
        if (priorityTasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Priority Tasks:");
            PriorityQueue<Task> tempQueue = new PriorityQueue<>(priorityTasks); // Create a temporary queue for display
            while (!tempQueue.isEmpty()) {
                System.out.println(tempQueue.poll()); // Retrieve tasks in priority order
            }
        }
    }

    public void displayCompletedTasks() {
        if (completedTasksHistory.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            for (Task task : completedTasksHistory) {
                System.out.println(task);
            }
        }
    }

    public void displayCategories() {
        if (categorizedTasks.isEmpty()) {
            System.out.println("No categories available.");
        } else {
            for (String category : categorizedTasks.keySet()) {
                System.out.println("- " + category);
            }
        }
    }

    public void displayPriorityTasksDescending() {
        if (priorityTasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Priority Tasks (Descending):");
            // Extract tasks into a list
            List<Task> taskList = new ArrayList<>(priorityTasks);
            // Sort the list in descending order
            taskList.sort((task1, task2) -> Integer.compare(task2.getPriority(), task1.getPriority()));
            // Display the sorted tasks
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }

}
