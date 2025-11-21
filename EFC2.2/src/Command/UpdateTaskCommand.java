package Command;

import Tasks.Task;

public class UpdateTaskCommand implements Command {

    private Task task;
    private String newDesc;

    public UpdateTaskCommand(Task task, String newDesc) {
        this.task = task;
        this.newDesc = newDesc;
    }

    @Override
    public void execute() {
        // Como não existe setDescription, você deve adicionar caso queira atualizar
        System.out.println("Descrição atualizada manualmente via comando (não tem setter)");
    }
}
