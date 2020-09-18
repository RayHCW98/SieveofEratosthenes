import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
	public static void main(String[] args) {
		CopyOnWriteArrayList<Coordinate> sample = new CopyOnWriteArrayList<Coordinate>();
		CopyOnWriteArrayList<Coordinate> result = new CopyOnWriteArrayList<Coordinate>();
		for (int i = -10; i <= 10; ++i) {
			for (int j = -6; j <= 6; ++j) {
				if (i == 0 && j == 0) {
					continue;
				}
				if ((i == 1 || i == -1) && (j == 0)) {
					continue;
				}
				if ((Math.pow(i, 2) + 6 * Math.pow(j, 2)) > 100) {
					continue;
				}
				sample.add(new Coordinate(i, j));
				result.add(new Coordinate(i, j));
			}
		}
		Collections.sort(sample, new Comparator<Coordinate>() {
			  @Override
			  public int compare(Coordinate c1, Coordinate c2) {
			    return c1.normSquare() - c2.normSquare();
			  }
		});
		Collections.sort(result, new Comparator<Coordinate>() {
			  @Override
			  public int compare(Coordinate c1, Coordinate c2) {
			    return c1.normSquare() - c2.normSquare();
			  }
		});
		for (int i = 0; i < sample.size(); ++i) {
			for (int j = i; j < sample.size(); ++j) {
				Coordinate.addTargetCount(result, sample.get(i).mult(sample.get(j)), sample.get(i), sample.get(j));
			}
		}
		for (int i = 0; i < result.size(); ++i) {
			System.out.print("**********\n");
			System.out.print(result.get(i));
			
		}
		
		/*
		Iterator<Coordinate> iter = result.iterator(); 
		while(iter.hasNext()){
			Coordinate dummy = iter.next();
			if (dummy.normSquare() > 100) {
				Coordinate.removeTarget(result, dummy);
			}
			for (int i = 0; i < sample.size(); ++i) {
				Coordinate.removeTarget(result, dummy.mult(sample.get(i)));
			}
		    
		}
		System.out.print(result);
		System.out.print(result.size());
		*/
	}
}
