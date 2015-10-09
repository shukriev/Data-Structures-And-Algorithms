import java.util.ArrayList;
import java.util.List;

public class PathsBetweenCellsInMatrix {
	static List<Character> directions = new ArrayList<Character>();
	
	public static void findPathInMatric(char[][] matrix, int x, int y, char ch) {
		int count = 0;
		int row = x;
		int col = y;
		
		if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) {
			return;
		}
		
		if(matrix[row][col] == 'e'){
			
			printDirections();
			System.out.println();
			System.out.println("EXIT");
			return;
		}
		
		if(matrix[row][col] != ' '){
			return;
		}
		
		System.out.println(ch);
		matrix[row][col] = 'x';
		directions.add(ch);
		
		findPathInMatric(matrix, x, y + 1, 'R');
		findPathInMatric(matrix, x + 1, y, 'D');
		findPathInMatric(matrix, x, y - 1, 'L');
		findPathInMatric(matrix, x - 1, y, 'U');
		
		matrix[row][col] = ' ';
		directions.remove(directions.size() - 1);
	}
	
	static void printDirections() {

		for (Character ch : directions) {
			System.out.print(ch);
		}
	}
	
	public static void main(String[] args) {
		char[][] matrix = { { ' ', ' ', ' ', ' ' }, { ' ', '*', '*', ' ' },
				{ ' ', '*', '*', ' ' }, { ' ', '*', 'e', ' ' },
				{ ' ', ' ', ' ', ' ' } };
		findPathInMatric(matrix, 0, 0, 's');
	}

}
