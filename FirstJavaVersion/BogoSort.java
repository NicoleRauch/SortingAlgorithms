import java.util.Random;

class BogoSort extends SortingAlgorithm {

	public void sort(SortArray points, SortCanvas c) {
		
		int max = 6;  // too dangerous to take more

		int i;
		
		// remove the unused points from view
		for( i = max + 1; i < points.length(); i++)
			points.put(i, -100);

		c.clearWindow();
		
		Random rand = new Random(new Random().nextInt());
		
		for (i = 1; i <= max; i++) { // init a
			points.put(i, (int)(((double)rand.nextInt(100) 
								/ 20.0 + 1.0) * 20.0));
		}

		while (true) {
			boolean isSorted = true;
			for( i = 1; i < max; i++ ){
				if( points.greater(i, i+1) ){
					// order is broken at one point: set the flag and jump out
					isSorted = false;
					break;
				}
			}
			c.paintNumbers();
			if( isSorted ) { // if the order is ok, stop the algorithm
				break;
			} else {
				rand = new Random(new Random().nextInt());
				for (i = 1; i <= max; i++) {
					points.get(i);
					points.put(i, (int)(((double)rand.nextInt(100) 
											/ 20.0 + 1.0) * 20.0));
				}
				c.paintNumbers();
			}
		}

	}

}
