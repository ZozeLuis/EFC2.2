package TaskManager;

import java.util.*;
import Tasks.*;
import Observer.*;
import Command.*;

public final class TaskManager {

    private static TaskManager instance;

    // Lista de tarefas
    private List<Task> taskList = new ArrayList<>();

    // Lista de observadores
    private List<TaskObserver> observers = new ArrayList<>();

    // Histórico de comandos executados
    private List<Command> history = new ArrayList<>();


    // Singleton
    private TaskManager() {}

    public static TaskManager getInstance() {
        if (instance == null)
            instance = new TaskManager();
        return instance;
    }


    // ------------------------------
    // OBSERVER
    // ------------------------------

    public void addObserver(TaskObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(TaskObserver obs) {
        observers.remove(obs);
    }

    private void notifyTaskAdded(Task t) {
        for (TaskObserver obs : observers) {
            obs.onTaskAdded(t);
        }
    }

    private void notifyTaskUpdated(Task t) {
        for (TaskObserver obs : observers) {
            obs.onTaskUpdated(t);
        }
    }

    private void notifyTaskCompleted(Task t) {
        for (TaskObserver obs : observers) {
            obs.onTaskCompleted(t);
        }
    }


    // ------------------------------
    // COMANDO
    // ------------------------------

    public void executeCommand(Command c) {
        c.execute();
        history.add(c);
    }


    // ------------------------------
    // OPERAÇÕES NO TASKMANAGER
    // ------------------------------

    public void adicionarTarefa(Task t) {
        taskList.add(t);
        notifyTaskAdded(t);
    }

    public void atualizarTarefa(Task t) {
        notifyTaskUpdated(t);
    }

    public void completarTarefa(Task t) {
        t.complete();
        notifyTaskCompleted(t);
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}
