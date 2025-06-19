package shinythinking.model;

import shinythinking.io.LocalIO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskModel implements Serializable {
    private List<Task> tasks;
    private Task candidate;

    public TaskModel() {
        tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
