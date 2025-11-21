package Command;

import TaskManager.TaskManager;
import Tasks.Task;

public class AddTaskCommand implements Command {

    private Task task;

    public AddTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        TaskManager.getInstance().adicionarTarefa(task);
    }
}
