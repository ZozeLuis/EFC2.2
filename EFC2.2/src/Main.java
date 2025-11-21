import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import TaskManager.TaskManager;
import Tasks.*;
import Observer.*;
import Command.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Singleton
        TaskManager tm = TaskManager.getInstance();

        // Observer global
        tm.addObserver(new LogObserver());

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar tarefa simples");
            System.out.println("2 - Criar tarefa urgente");
            System.out.println("3 - Criar tarefa com deadline");
            System.out.println("4 - Listar tarefas");
            System.out.println("5 - Completar tarefa");
            System.out.println("6 - Atualizar descrição da tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int op = Integer.parseInt(sc.nextLine());

            if (op == 0) break;

            switch (op) {

                case 1: {
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Descrição: ");
                    String d = sc.nextLine();
                    System.out.print("Prioridade (1-3): ");
                    int p = Integer.parseInt(sc.nextLine());

                    Task task = new SimpleTask(t, d, p);

                    tm.executeCommand(new AddTaskCommand(task));
                    break;
                }

                case 2: {
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Descrição: ");
                    String d = sc.nextLine();

                    Task task = new UrgentTask(t, d);

                    tm.executeCommand(new AddTaskCommand(task));
                    break;
                }

                case 3: {
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Descrição: ");
                    String d = sc.nextLine();
                    System.out.print("Prioridade (1-3): ");
                    int p = Integer.parseInt(sc.nextLine());
                    System.out.print("Deadline (AAAA-MM-DD): ");
                    String dateStr = sc.nextLine();

                    Task task = new DeadLineTask(t, d, p, LocalDate.parse(dateStr));

                    tm.executeCommand(new AddTaskCommand(task));
                    break;
                }

                case 4: {
                    List<Task> list = tm.getTaskList();
                    System.out.println("\n--- LISTA DE TAREFAS ---");
                    for (int i = 0; i < list.size(); i++) {
                        Task task = list.get(i);
                        System.out.println(i + " - " + task.getTitle() + 
                                           " (prio " + task.getPriority() + ") " +
                                           (task.isCompleted() ? "[OK]" : ""));
                    }
                    break;
                }

                case 5: {
                    System.out.print("ID da tarefa: ");
                    int id = Integer.parseInt(sc.nextLine());

                    List<Task> tasks = tm.getTaskList();

                    if (id < 0 || id >= tasks.size()) {
                        System.out.println("ID inválido!");
                        break;
                    }

                    Task task = tasks.get(id);

                    tm.executeCommand(new CompleteTaskCommand(task));
                    tm.completarTarefa(task);
                    break;
                }

                case 6: {
                    System.out.print("ID da tarefa: ");
                    int id = Integer.parseInt(sc.nextLine());

                    List<Task> tasks = tm.getTaskList();

                    if (id < 0 || id >= tasks.size()) {
                        System.out.println("ID inválido!");
                        break;
                    }

                    Task task = tasks.get(id);

                    System.out.print("Nova descrição: ");
                    String desc = sc.nextLine();

                    tm.executeCommand(new UpdateTaskCommand(task, desc));
                    tm.atualizarTarefa(task);
                    break;
                }

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
