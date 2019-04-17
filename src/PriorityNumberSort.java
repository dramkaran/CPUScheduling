import java.util.Comparator;

public class PriorityNumberSort implements Comparator<Process> {
  @Override
  //sort list by priority number
	public int compare(Process p1, Process p2) {
    	return Integer.compare(p1.getPriority(), p2.getPriority());
    
    }
}