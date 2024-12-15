public class Task implements Comparable<Task> {
    private String title;
    private String category;
    private boolean isCompleted;
    private int priority;

    public Task(String title, String category, int priority) {
        this.title = title;
        this.category = category;
        this.isCompleted = false;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getPriority() {
        return priority;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + title + " (Priority: " + priority + ")";
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}
