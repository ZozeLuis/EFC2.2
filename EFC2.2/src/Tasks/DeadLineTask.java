package Tasks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Observer.TaskObserver;

public class DeadLineTask implements Task{
	private String title;
	private String description;
	private boolean completed;
	private int priority;
	private LocalDate deadline;
	private List<TaskObserver> observers = new ArrayList<>();

	
	public DeadLineTask(String t, String d, int p, LocalDate dl) {
		this.title = t;
		this.description = d;
		this.completed = false;
		this.priority = p;
		this.deadline = dl;
	}
	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public void complete() {
		// TODO Auto-generated method stub
		this.completed = true;
		System.out.println("Tarefa urgente concluída \\(^-^)/");
		
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return this.completed;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return this.priority;
	}
	
	@Override
	public void addObservers(TaskObserver observer) {
		// TODO Auto-generated method stub
		this.observers.add(observer);
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (TaskObserver obs: observers) {
			obs.onTaskCompleted(this);
		}
		
	}

}
