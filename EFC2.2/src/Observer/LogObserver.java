package Observer;

import Tasks.Task;

public class LogObserver implements TaskObserver {

    @Override
    public void onTaskAdded(Task t) {
        System.out.println("[LOG] Nova tarefa adicionada: " + t.getTitle());
    }

    @Override
    public void onTaskUpdated(Task t) {
        System.out.println("[LOG] Tarefa atualizada: " + t.getTitle());
    }

    @Override
    public void onTaskCompleted(Task t) {
        System.out.println("[LOG] Tarefa concluída: " + t.getTitle());
    }
}
