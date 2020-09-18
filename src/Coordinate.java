import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Coordinate {
	int x;
	int y;
	int count;
	CopyOnWriteArrayList<Coordinate> factor;
	public Coordinate(int xx, int yy) {
		x = xx;
		y = yy;
		count = 0;
		factor = new CopyOnWriteArrayList<Coordinate>();
	}
	public int normSquare() {
		return (int) (Math.pow(x, 2) + 6 * Math.pow(y, 2));
	}
	
	public boolean equals(Coordinate c) {
		return (x == c.x) && (y == c.y);
	}
	
	public Coordinate mult(Coordinate c) {
		return new Coordinate(x * c.x - 6 * y * c.y, x * c.y + y * c.x);
	}
	public void addCount() {
		this.count = this.count + 1;
	}
	public void addFactor(Coordinate f1, Coordinate f2) {
		this.factor.add(f1);
		this.factor.add(f2);
	}
	
	static void removeTarget(CopyOnWriteArrayList<Coordinate> arr, Coordinate c) {
		for (int i = 0; i < arr.size(); ++i) {
			if (c.equals(arr.get(i))) {
				arr.remove(i);
				return;
			}
		}
	}
	static void addTargetCount(CopyOnWriteArrayList<Coordinate> arr, Coordinate c, Coordinate f1, Coordinate f2) {
		for (int i = 0; i < arr.size(); ++i) {
			if (c.equals(arr.get(i))) {
				arr.get(i).addCount();
				arr.get(i).addFactor(f1, f2);
				return;
			}
		}
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ") " + "{" + count + "}" +  factor + "\n";
	}
}
