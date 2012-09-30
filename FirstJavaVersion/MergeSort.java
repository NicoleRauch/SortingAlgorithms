
class MergeSort extends SortingAlgorithm {

	SortArray p;
	SortCanvas c;

	public void sort(SortArray points, SortCanvas canvas) {
		p = points;
		c = canvas;
		mergesort(1, points.length() - 1);
	}

	void mergesort(int start, int length) { // Vorl. S. 24

		//		VOID MergeSort( const PPOINTL start, INT length )       

		int first, second;
		int[] h;
		int i = 0;

		if (length <= 1)
			return; // nothing to do

		h = new int[length];
		first = start;
		second = start + length / 2;
		mergesort(first, length / 2);
		mergesort(second, length - length / 2);
		while (i < length) { // sort first and second into h
			if ((first < start + length / 2) && (second < start + length)) {
				// none of the fields is empty
				c.IncCompare();
				if (p.less_equal(first, second)) {
					h[i] = p.get(first);
//					c.paintOne(i+start, h[i], Color.black);
					first++;
				} else {
					h[i] = p.get(second);
//					c.paintOne(i+start, h[i], Color.black);
					second++;
				}
				i++;
			} else { // one of the fields is empty
				if (first < start + length / 2) { // first is not empty
					while (i < length) {
						h[i] = p.get(first);
//						c.paintOne(i+start, h[i], Color.black);
						first++;
						i++;
					}
				} else { // second is not empty
					while (i < length) {
						h[i] = p.get(second);
//						c.paintOne(i+start, h[i], Color.black);
						second++;
						i++;
					}
				}
			} // else - one of the fields is empty
			c.paintNumbers();
		} // while i < length
		for (i = 0; i < length; i++) { // copy h into start
			p.put(i+start, h[i]);
		}
		c.paintNumbers();

	}

}
