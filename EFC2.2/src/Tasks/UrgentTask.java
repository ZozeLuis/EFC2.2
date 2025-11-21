package Tasks;

import java.util.ArrayList;
import java.util.List;

import Observer.TaskObserver;

public class UrgentTask implements Task{

	private String title;
	private String description;
	private boolean completed;
	private int priority = 3;
	private List<TaskObserver> observers = new ArrayList<>();

	
	public UrgentTask(String t, String d) {
		this.title = t;
		this.description = d;
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
