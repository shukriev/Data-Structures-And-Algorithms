import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
	static int numberOfSteps = 0;
	static Stack<Integer> sorce = new Stack<Integer>();
	static Stack<Integer> spare = new Stack<Integer>();
	static Stack<Integer> destination = new Stack<Integer>();
	
	static void hanoi(int bottomDisk, Stack<Integer> sorce,
			Stack<Integer> spare, Stack<Integer> destination) {
		if (bottomDisk > 0) {
			hanoi(bottomDisk - 1, sorce, destination, spare);
			destination.push(sorce.pop());

			numberOfSteps++;
			printRods(bottomDisk);
			hanoi(bottomDisk - 1, spare, sorce, destination);

		}
	}
	
	static void crateDisks(int n) {
		for (int i = n; i > 0; i--) {
			sorce.push(i);
		}
	}
	
	static void printRods(int bottomDisk) {
		System.out.printf("In step #%d, move disk %d   \n", numberOfSteps,
				bottomDisk);
		System.out.println("Sorce: " + sorce.toString());
		System.out.println("spare: " + spare.toString());
		System.out.println("Destination: " + destination.toString());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of disks");
		int numberOfDisk = sc.nextInt();
		crateDisks(numberOfDisk);

		hanoi(numberOfDisk, sorce, spare, destination);
		System.out.println(numberOfSteps);
	}

}
