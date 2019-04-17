import java.util.ArrayList;
import java.util.Collections;

public class Scheduler{
	
	private ArrayList list;
	

	public Scheduler(ArrayList list){ 
		this.list = list; 		
	} 

	//calculate wait time for each process
	public void findWaitTime(int burstTime[], int waitTime[], int arrivalTime[])  
	{  
		//currTime is the time before the process begins execution
	    int currTime[] = new int[list.size()];  
	    
	    //no wait time for the first process
	    currTime[0] = 0;  
	    waitTime[0] = 0;  
	  
	    // calculate wait time  
	    for (int i = 1; i < list.size() ; i++) {  
	        
	    	//get the time process begins execution by adding all previous process' burst time
	        currTime[i] = currTime[i-1] + burstTime[i-1];  
	  
	        //waiting time for each process equals the summation of all previous burst times - process's arrival time  
	        waitTime[i] = currTime[i] - arrivalTime[i];  
	  
	        //if wait time is less than 0, that process is in the ready queue, so wait time becomes 0
	        if (waitTime[i] < 0)  
	            waitTime[i] = 0;  
	    }  
	}  
	  
	//calculate turn around time  
	public void findTurnAroundTime(int burstTime[], int waitTime[], int turnAroundTime[])  
	{  
	  
	    for (int i = 0; i < list.size(); i++)  
	        turnAroundTime[i] = burstTime[i] + waitTime[i];  
	}  
	  
	//calculate average wait time and turn around time
	public void findAverageTime(int burstTime[], int arrivalTime[], int waitTime[], int turnAroundTime[]){  
	
	    int totalWaitTime = 0; 
	    int totalTurnAroundTime = 0;  
	    
	    //calculate total wait time and total turn over time by adding all in the list
	    for (int i = 0 ; i < list.size(); i++){  
	        //total wait time
	    	totalWaitTime = totalWaitTime + waitTime[i];  
	    	//total turn around time
	        totalTurnAroundTime = totalTurnAroundTime + turnAroundTime[i];    
	    } 
	    //calculate average WT and TAT
	    double averageWaitTime = totalWaitTime/list.size();
        String strDoubleWT = String.format("%.2f", averageWaitTime);	  
        
        double averageTurnAroundTime = totalTurnAroundTime/list.size(); 
        String strDoubleTAT = String.format("%.2f", averageTurnAroundTime);
	
        System.out.println("Average Wait Time: " + strDoubleWT); 
        System.out.println("Average Turn Around Time: " + strDoubleTAT);
        
	}  
	
	//display processes
	public void display(int burstTime[], int arrivalTime[], int waitTime[], int turnAroundTime[], int pid[], int priorityArr[]){ 
	   
		//find wait time of each process 
	    findWaitTime(burstTime, waitTime, arrivalTime);  
	  
	    //find turn around time of each process 
	    findTurnAroundTime(burstTime, waitTime, turnAroundTime);  
	  
	    // Display processes along with all details  
	    System.out.printf("%15s%15s%15s%15s%15s%15s%15s\n", "Process PID " , " Priority Number ", " Arrival Time " , " Completion Time " , " Burst Time " , " Wait Time " , " Turn Around Time "); 
	    
	    for (int i = 0 ; i < list.size() ; i++)  
	    {  
	    	//calculate completion time
	        int finishTime = turnAroundTime[i] + arrivalTime[i];  
	        
	        System.out.printf("%15d%15d%15d%15d%15d%15d%15d\n", pid[i], priorityArr[i], arrivalTime[i], finishTime, burstTime[i], waitTime[i], turnAroundTime[i]);
	    }
	    //display average wait time and turn around time
	    findAverageTime(burstTime, arrivalTime, waitTime, turnAroundTime);
	}
}


