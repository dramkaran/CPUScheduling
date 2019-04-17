import java.util.Comparator;

public class ArrivalTimeSort implements Comparator<Process> {
  @Override
  //sort list by arrival time
	public int compare(Process p1, Process p2) {
    	return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
    
    }
}