
class SelectionSort extends SortingAlgorithm {

	public void sort(SortArray points, SortCanvas c) {

		int i, j, min;

		for (i = 1; i < points.length()-1; i++) {
			min = i;
			for (j = i + 1; j <= points.length()-1; j++) {
				if (points.less(j, min))
					min = j;
			}
			if (i != min) {
				points.swap(min,i);
			}
			c.paintNumbers();
		}

	}

}
