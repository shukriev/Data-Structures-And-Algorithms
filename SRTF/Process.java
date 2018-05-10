public class Process {
	private int id;
	private	int burstTime;
	private	int arrivalTime;
	private boolean isActive;
	
	public Process(int id, int burstTime, int arrivalTime) {
		setId(id);
		setBurstTime(burstTime);
		setArrivalTime(arrivalTime);
		setIsActive(true);
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}
	
	public int getBurstTime() {
		return this.burstTime;
	}
	
	private void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
	
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	private void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Process [id=" + id + ", burstTime=" + burstTime + ", arrivalTime=" + arrivalTime + ", isActive="
				+ isActive + "]";
	}
}
