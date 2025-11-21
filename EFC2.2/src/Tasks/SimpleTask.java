	package Tasks;
	
	import java.util.*;
	
	import Observer.TaskObserver;
	
	public class SimpleTask implements Task {
	
	    private String title;
	    private String description;
	    private boolean completed;
	    private int priority;
	
	    // Observadores específicos da tarefa
	    private List<TaskObserver> observers = new ArrayList<>();
	
	
	    public SimpleTask(String t, String d, int priority) {
	        this.title = t;
	        this.description = d;
	        this.priority = priority;
	    }
	
	    @Override
	    public String getTitle() {
	        return this.title;
	    }
	
	    @Override
	    public String getDescription() {
	        return this.description;
	    }
	
	    @Override
	    public void complete() {
	        this.completed = true;
	        System.out.println("Tarefa simples concluída!");
	        notifyObservers();
	    }
	
	    @Override
	    public boolean isCompleted() {
	        return this.completed;
	    }
	
	    @Override
	    public int getPriority() {
	        return this.priority;
	    }
	
	
	    @Override
	    public void addObservers(TaskObserver observer) {
	        this.observers.add(observer);
	    }
	
	    @Override
	    public void notifyObservers() {
	        for (TaskObserver obs : observers) {
	            obs.onTaskCompleted(this);
	        }
	    }
	
	}
