import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConnectedAreasInAMatrix {
	static int count = 0;
	static List<Area> listAreas = new ArrayList<Area>();
	static char[][] matrix = { { ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' },
			{ ' ', ' ', ' ', ' ', '*', ' ', '*', ' ', ' ' } };

	static char[][] matrix2 = {
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' , ' '},
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ' },
			{ '*', ' ', ' ', '*', '*', '*', '*', '*', ' ' , ' '},
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' , ' '},
			{ '*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ' , ' '}};
	
	public static void discoverMaze(char[][] matrixMaze) {
		for (int x = 0; x < matrixMaze.length; x++) {
			for (int y = 0; y < matrixMaze[0].length; y++) {
				if (x >= matrixMaze.length || y >= matrixMaze[x].length) {
					continue;
				}
				
				if (matrixMaze[x][y] == ' ') {
					findArea(matrixMaze, x, y);
					listAreas.add(new Area(x, y, count));
					count = 0;
				}
			}
		}
	}
	
	public static void findArea(char[][] matrixMaze, int x, int y) {
		int row = x;
		int col = y;
		
		if (row < 0 || col < 0 || row >= matrixMaze.length || col >= matrixMaze[row].length) {
			return;
		}
		
		if(matrixMaze[row][col] != ' ') {
			return;
		}
		
		matrixMaze[row][col] = 'x';
		count++;
		
		findArea(matrixMaze, x, y + 1);
		findArea(matrixMaze, x + 1, y);
		findArea(matrixMaze, x, y - 1);
		findArea(matrixMaze, x - 1, y);
	}
	
	public static void main(String[] args) {
		discoverMaze(matrix);
		
		listAreas.sort(new Comparator<Area>() {

			@Override
			public int compare(Area o1, Area o2) {
				if (o1.getSize() > o2.getSize()) {
					return -1;
				} else if (o1.getSize() < o2.getSize()) {
					return 1;
				} else {
					if (o1.getPositionX() > o2.getPositionX()) {
						return -1;
					} else if (o1.getPositionY() < o2.getPositionY()) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});
		for (Area element : listAreas) {
			System.out.println(element.toString());
		}
		
	}

}
