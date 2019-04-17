import java.util.ArrayList;
import java.util.Collections;

public class SchedulerRunner {
	
	public static void main(String[] args){ 
		
		ArrayList<Process> list = new ArrayList<Process>();  
		Scheduler s = new Scheduler(list); 
		
		list.add(new Process(1, 3, 1, 5)); 
		list.add(new Process(2, 5, 2, 6)); 
		list.add(new Process(3, 2, 5, 1)); 
		list.add(new Process(4, 9, 3, 54)); 
		list.add(new Process(5, 10, 7, 32)); 
		list.add(new Process(6, 1, 9, 13)); 
		list.add(new Process(7, 6, 11, 12)); 
		list.add(new Process(8, 4, 12, 9)); 
		list.add(new Process(9, 7, 15, 78)); 
		list.add(new Process(10, 11, 16, 16)); 
		
		
		//FIRST COME FIRST SERVE FCFS 
		System.out.println("First Come First Serve (FCFS)"); 
		//sort list based on arrival time
		Collections.sort(list, new ArrivalTimeSort());
		
		//Initialize empty waitTime and turnAroundTime arrays
		int[]waitTime = new int[list.size()]; 
		int[]turnAroundTime = new int[list.size()]; 
		
		//retrieving burstTime, arrivalTime, and PID from object in arraylist and assigning each to a unique array
		int[] burstTimeArr = new int[list.size()]; 
		int[] arrivalTimeArr = new int[list.size()];
		int[] pidArr = new int[list.size()]; 
		int[] priorityArr = new int[list.size()];
		for (int i =0; i<list.size(); i++){ 
			//add every process' burst time into burst time array
			burstTimeArr[i] = list.get(i).getBurstTime(); 
			//add every process' arrival time into arrival time array
			arrivalTimeArr[i] = list.get(i).getArrivalTime();
			//add every process' PID into PID array
			pidArr[i] = list.get(i).getPid();
			priorityArr[i] = list.get(i).getPriority();
		}
		s.display(burstTimeArr, arrivalTimeArr, waitTime, turnAroundTime, pidArr, priorityArr);
		
		
		//PRIORITY SCHEDULING
		System.out.println("PRIORITY SCHEDULING");
		Collections.sort(list, new PriorityNumberSort()); 
		
		for (int i =0; i<list.size(); i++){ 
			//add every process' burst time into burst time array
			burstTimeArr[i] = list.get(i).getBurstTime(); 
			//add every process' arrival time into arrival time array
			arrivalTimeArr[i] = list.get(i).getArrivalTime();
			//add every process' PID into PID array
			pidArr[i] = list.get(i).getPid();
			//add every process' priority into prioirity array
			priorityArr[i] = list.get(i).getPriority();
		}
		s.display(burstTimeArr, arrivalTimeArr, waitTime, turnAroundTime, pidArr, priorityArr);
		
	
	
		
		
		
	}

}
