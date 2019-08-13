package pack;

import java.util.Iterator;

public class MyListIterator<T> implements Iterator<T> {
	private MyList<T> cur;

	private MyList<T> itnext;

	private final MyList<T> list;

	public MyListIterator(final MyList<T> a) {

		this.cur = null;
		this.itnext = a;
		this.list = a;
	}

	public void add(final T v) {

		if (!hasNext()) {
			this.itnext.data = v;
			this.itnext.tail = new MyList<>();
			this.itnext = this.itnext.tail;
		} else {
			MyList<T> aux = this.itnext.copy();
			this.itnext.data = v;
			this.itnext.tail = aux;
			this.cur = this.itnext;
			this.itnext = this.itnext.tail;
		}
	}

	public MyList<T> getCur() {

		return this.cur;
	}

	public MyList<T> getItnext() {

		return this.itnext;
	}

	public MyList<T> getList() {

		return this.list;
	}

	public void goToBegin() {

		this.cur = this.list;
		this.itnext = this.list.tail;

	}

	public void goToEnd() {

		while (this.hasNext()) {
			this.cur = this.itnext;
			this.itnext = this.itnext.tail;
		}

	}

	public boolean hasNext() {

		return !this.itnext.isEmpty();

	}

	public boolean hasPrevious() {

		return this.cur != null;

	}

	public T next() throws MLInvalidAccessException {

		if (!this.hasNext()) {
			throw new MLInvalidAccessException(11);
		}
		this.cur = this.itnext;
		this.itnext = this.itnext.tail;
		return this.cur.data;

	}

	public T previous() throws MLInvalidAccessException {

		if (!this.hasPrevious()) {
			throw new MLInvalidAccessException(12);
		}
		if (this.cur == this.list) {
			this.itnext = this.cur;
			this.cur = null;
		} else {
			MyList<T> listCopy = this.list;
			while (listCopy.tail != this.cur) {
				listCopy = listCopy.tail;
			}
			this.itnext = this.cur;
			this.cur = listCopy;
		}
		return this.itnext.data;
	}

	public void remove() throws MLInvalidAccessException {

		MyList<T> aux = this.list;

		if (this.cur == null || aux.isEmpty()) {
			throw new MLInvalidAccessException(14);
		} else if (aux == this.cur) {
			this.cur.data = this.itnext.data;
			this.cur.tail = this.itnext.tail;
			this.itnext = this.cur;
			this.cur = aux;
		} else {
			while (aux.tail != this.cur) {
				aux = aux.tail;
			}

			this.cur.data = this.itnext.data;
			this.cur.tail = this.itnext.tail;
			this.itnext = this.cur;
			this.cur = aux;
		}
	}

	public void set(final T v) throws MLInvalidAccessException {

		if (this.cur == null) {
			throw new MLInvalidAccessException(13);
		}
		this.cur.data = v;

	}

}
