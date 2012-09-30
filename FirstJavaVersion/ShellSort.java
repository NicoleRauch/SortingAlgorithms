
abstract class ShellSort extends SortingAlgorithm {

	SortArray points;
	SortCanvas c;

	void shellSort(int factor) {

		int j, offset = 1;
		boolean exchange;

		while (offset <= points.length()-1) {
			offset *= factor;
			offset--;
		}

		while (offset > 1) { // offset-reduction-loop
			offset++;
			offset /= factor; // reduce offset
			do {
				exchange = false;
				for (j = points.length()-1; j > offset; j--) {
					if (points.less(j, j - offset)) {
						points.swap(j, j - offset);
						exchange = true;
					}
					c.paintNumbers();
				} // for j
			} while (exchange); // check if there have been exchanges
		} // while offset
	}

}
