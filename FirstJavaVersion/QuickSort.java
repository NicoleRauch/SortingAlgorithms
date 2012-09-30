
class QuickSort extends SortingAlgorithm {

	SortArray work;
	SortCanvas c;

	public void sort(SortArray points, SortCanvas canvas) {
		work = points;
		c = canvas;
		
		quickSort(1, points.length() - 1);
	}

	void quickSort(int first, int last) // Vorl. S. 55
	{
		int q;
		if (first < last) {
			q = partition(first, last);
			quickSort(first, q);
			quickSort(q + 1, last);
		}
	}

	int partition(int first, int last) // subroutine for QuickSort
	{
		int i = first - 1;
		int j = last + 1;
		while (true) {
			do {
				j--;
			} while (work.greater(j, first));
			do {
				i++;
			} while (work.less(i, first));
			c.paintNumbers();
			if (i < j) {
				work.swap(i, j);
				c.paintNumbers();
			} else {
				return j;
			}
		}
	}

}
