
class BubbleSort extends SortingAlgorithm {

	public void sort(SortArray points, SortCanvas c) {

		int i, j;

		for (i = 1; i <= points.length()-1; i++) {
			for (j = points.length()-1; j > i; j--) {
				c.IncCompare();
				if (points.less(j, j - 1)) {
					points.swap(j, j-1);
				}
				c.paintNumbers();
			}
		}

	}

}
