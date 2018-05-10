import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ProcessTable {
	private List<Process> processes = new LinkedList<>();
	private List<Integer> waitingTime;
	private int remainingTime[];
	private Frame mainFrame;
	
	// Load new process
	public void load(int id, int burstTime, int arrivalTime) {
		this.processes.add(new Process(id, burstTime, arrivalTime));
	}

	// Call Dispatcher
	public DefaultTableModel dispatch() {
		System.out.println("====================== Dispatch =======================");
		System.out.println(
				"Processes " + " Burst time " + " Waiting time " + " Turn around time" + "     Is Active Process");

		if (waitingTime.size() > 0) {
			int turnAroundTime[] = new int[processes.size()];
			int total_wt = 0, total_tat = 0;
			String[][] data = new String[processes.size()][6];

			for (int i = 0; i < processes.size(); i++) {
				if (i < waitingTime.size()) {
					turnAroundTime[i] = processes.get(i).getBurstTime() + waitingTime.get(i);
				}
			}

			// Calculate total waiting time and
			// total turnaround time
			for (int i = 0; i < processes.size(); i++) {
				if (i < waitingTime.size()) {
					total_wt = total_wt + waitingTime.get(i);
					total_tat = total_tat + turnAroundTime[i];

					data[i][0] = "" + processes.get(i).getId();
					data[i][1] = "" + processes.get(i).getBurstTime();
					data[i][2] = "" + processes.get(i).getArrivalTime();
					data[i][3] = "" + waitingTime.get(i);
					data[i][4] = "" + turnAroundTime[i];
					data[i][5] = "" + processes.get(i).getIsActive();

					System.out.println(" " + processes.get(i).getId() + "\t\t" + processes.get(i).getBurstTime()
							+ "\t\t " + waitingTime.get(i) + "\t\t" + turnAroundTime[i] + "\t\t"
							+ processes.get(i).getIsActive());
				}else {
					break;
				}
			}

			String column[] = { "Process Id", "Burst Time", "Arrival Time", "Waiting Time", "Turn Around Time",
					"Is Active Process" };

			DefaultTableModel model = new DefaultTableModel(data, column);
			return model;
		}

		return null;
	}

	public void finish(int id) {
		processes.stream().filter(p -> p.getId() == id).findFirst().get().setIsActive(false);
	}

	// List all active processes;
	public void show() {
		this.processes.forEach(p -> System.out.println(p));
	}

	public String[][] processList() {
		String[][] result = new String[processes.size()][3];
		for (int i = 0; i < processes.size(); i++) {
			result[i][0] = "" + processes.get(i).getId();
			result[i][1] = "" + processes.get(i).getArrivalTime();
			result[i][2] = "" + processes.get(i).getBurstTime();
		}
		return result;
	}
	// Method to find the waiting time for all

	public void process() {
		int complete = 0;
		int time = 0;
		int minm = Integer.MAX_VALUE;
		int shortest = 0;
		int finish_time = 0;
		boolean check = false;

		waitingTime = new ArrayList<>();
		remainingTime = new int[processes.size()];

		// Copy the burst time into remainingTime[]
		for (int i = 0; i < processes.size(); i++) {
			remainingTime[i] = processes.get(i).getBurstTime();
		}

		while (true) {
			if(complete == processes.size()) {
//				System.out.println("Is Alive: " + Thread.currentThread().isAlive());
//				System.out.println("State: " + Thread.currentThread().getState());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}

			// Find process with minimum
			// remaining time among the
			// processes that arrives till the
			// current time`
			for (int j = 0; j < processes.size(); j++) {				
				if (processes.get(j).getIsActive() == true && (processes.get(j).getArrivalTime() <= time) && (remainingTime[j] < minm) && remainingTime[j] > 0) {
					minm = remainingTime[j];
					shortest = j;
					check = true;
				}
			}

			if (check == false) {
				time++;
				continue;
			}

			// Reduce remaining time by one
			remainingTime[shortest]--;

			// Update minimum
			minm = remainingTime[shortest];
			if (minm == 0)
				minm = Integer.MAX_VALUE;

			// If a process gets completely
			// executed
			if (remainingTime[shortest] == 0) {

				// Increment complete
				complete++;

				// Find finish time of current
				// process
				finish_time = time + 1;

				// Calculate waiting time
				waitingTime.add(finish_time - processes.get(shortest).getBurstTime()
						- processes.get(shortest).getArrivalTime());

				if (shortest < waitingTime.size() && waitingTime.get(shortest) < 0) {
					waitingTime.set(shortest, 0);
					// waitingTime[shortest] = 0;
				}

				finish(processes.get(shortest).getId());

				// After finish notify dispatcher model;
				if (mainFrame != null && mainFrame.dispatchTable != null && dispatch() != null) {
					mainFrame.dispatchTable.setModel(dispatch());
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// Increment time
			time++;
			dispatch();
		}
	}

	public void notifyData() {
		
		remainingTime = new int[processes.size()];
		
		for (int i = 0; i < processes.size(); i++) {
			remainingTime[i] = processes.get(i).getBurstTime();

		}
		
	}
	
	public int returnNextId() {
		return processes.get(processes.size() - 1).getId() + 1;
	}

	public void setFrame(Frame frame) {
		mainFrame = frame;
	}
}
