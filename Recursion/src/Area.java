import java.util.Comparator;


public class Area implements Comparator<Area>{
	private int positionX;
	private int positionY;
	private int size;

	public Area(int x, int y, int size) {
		setPositionX(x);
		setPositionY(y);
		setSize(size);
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positiony) {
		this.positionY = positiony;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Position X/Y: " + getPositionX() + "/" + getPositionY()
				+ " size: " + getSize();

	}

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
}
