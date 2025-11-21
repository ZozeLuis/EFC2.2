package Tasks;
import Observer.*;

public interface Task {
	public String getTitle();
	public String getDescription();
	public void complete();
	public boolean isCompleted();
	public int getPriority();
	
	void addObservers(TaskObserver observer);
	void notifyObservers();
	
}
