package pack;

public class MyList<T> {

	T data;

	MyList<T> tail;

	// Liste vide
	public MyList() {

		this.data = null;
		this.tail = null;
	}

	public MyList(final T v) {

		this.data = v;
		this.tail = new MyList<>();
	}

	public MyList(final T[] v) {

		if (v == null) {
			this.data = null;
			this.tail = null;
		} else {
			MyList<T> list = this;
			for (int i = 0; i < v.length; i++) {
				list.data = v[i];
				list.tail = new MyList<>();
				list = list.tail;
			}
		}
	}

	public void append(final T e) {

		MyList<T> lastData = this;
		while (lastData.tail.data != null) {
			lastData = lastData.tail;
		}

		lastData.tail.tail = new MyList<>();
		lastData.tail.data = e;

	}

	public void concat(final MyList<T> lc) {

		if (this.isEmpty()) {
			MyList<T> ld = lc.copy();
			this.data = ld.data;
			this.tail = ld.tail;
		} else {
			this.tail.concat(lc);
		}
	}

	public MyList<T> copy() {

		MyList<T> listR = new MyList<>();

		if (!this.isEmpty()) {
			MyList<T> listWT = this;
			MyList<T> listWR = listR;
			for (int i = 0; i < this.size(); i++) {
				listWR.data = listWT.data;
				listWR.tail = new MyList<>();
				listWR = listWR.tail;
				listWT = listWT.tail;
			}
		}
		return listR;
	}

	public T end() throws MLInvalidAccessException{
		
		if (this.tail == null) {
			throw new MLInvalidAccessException(2);
		}

		MyList<T> lastData = this;
		while (lastData.tail.data != null) {
			lastData = lastData.tail;

		}
		return lastData.data;
	}

	public T getData() {

		return this.data;
	}

	public MyList<T> getTail() {

		return this.tail;
	}

	public T head() throws MLInvalidAccessException{
		if (this.data == null) {
			throw new MLInvalidAccessException(1);
		}

		return this.data;

	}

	public boolean isEmpty() {

		return this.tail == null && this.data == null;
	}

	public MyListIterator<T> MyListIterator() {

		return new MyListIterator<>(this);

	}

	public int size() {

		int taille = 0;
		MyList<T> list = this;
		while (!list.isEmpty()) {
			taille++;
			list = list.tail;
		}
		return taille;

	}

	public MyList<T> tail() {

		MyList<T> list = this.tail;
		return list;

	}

	public Object[] toArray() {

		Object[] arrList = new Object[this.size()];

		MyList<T> list = this;
		for (int i = 0; i < this.size(); i++) {
			arrList[i] = list.data;
			list = list.tail;
		}
		return arrList;

	}

}
