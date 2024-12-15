import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== To-Do List Manager ===");
            System.out.println("1.  Add Task");
            System.out.println("2.  View All Tasks");
            System.out.println("3.  View Tasks by Category");
            System.out.println("4.  View Priority Tasks");
            System.out.println("5.  Mark Task as Completed");
            System.out.println("6.  View Completed Tasks");
            System.out.println("7.  Remove Task");
            System.out.println("8.  View Categories");
            System.out.println("9.  View Priority Tasks (Descending Order)");
            System.out.println("10: Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter task priority (1-5, 1 = High Priority): ");
                    int priority = scanner.nextInt();
                    todoList.addTask(title, category, priority);
                    System.out.println("Task added.");
                    break;

                case 2:
                    System.out.println("\nAll Tasks:");
                    todoList.displayTasks();
                    break;

                case 3:
                    System.out.print("Enter category name: ");
                    String categoryName = scanner.nextLine();
                    System.out.println("\nTasks in category '" + categoryName + "':");
                    todoList.displayTasksByCategory(categoryName);
                    break;

                case 4:
                    System.out.println("\nPriority Tasks:");
                    todoList.displayPriorityTasks();
                    break;

                case 5:
                    System.out.print("Enter task number to mark as completed: ");
                    int completeIndex = scanner.nextInt() - 1;
                    if(todoList.markTaskAsCompleted(completeIndex)){
                        System.out.println("Task marked as completed.");
                    };
                    break;

                case 6:
                    System.out.println("\nCompleted Tasks:");
                    todoList.displayCompletedTasks();
                    break;

                case 7:
                    System.out.print("Enter task number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    todoList.removeTask(removeIndex);
                    System.out.println("Task removed.");
                    break;

                case 8:
                    System.out.println("\nAvailable Categories:");
                    todoList.displayCategories();
                    break;

                case 9:
                    todoList.displayPriorityTasksDescending();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
