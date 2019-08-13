package entities;

import java.util.Iterator;

import exception.MLInvalidAccessException;

public class MyListIterator<T> implements Iterator<T> {

	private MyList<T> itprev;
	private MyList<T> itnext; 
	private MyList<T> list;

	public MyListIterator(MyList<T> a) {
		this.itprev = null;
		this.itnext = a;
		this.list = a;
	}

	@Override
	public boolean hasNext() {
		return !this.itnext.isEmpty();
	}

	@Override
	public T next() throws MLInvalidAccessException {
		if (!hasNext()) {
			throw new MLInvalidAccessException(11);
		}
		this.itprev = this.itnext;
		this.itnext = itnext.tail;
		return this.itprev.data;
	}

	public boolean hasPrevious() {
		return !(this.itprev == null);
	}

	public T previous() throws MLInvalidAccessException {
		if (!hasPrevious()) {
			throw new MLInvalidAccessException(12);
		}
		MyList<T>  current = this.itprev;
		goToBegin();
		while (itnext != current) {
			this.itprev = this.itnext;
			this.itnext = this.itnext.tail;
		}
		return this.itnext.data;
	}

	public void goToBegin() {
		this.itprev = null;
		this.itnext = this.list;
	}

	public void goToEnd() {
		while (hasNext()) {
			this.itprev = this.itnext;
			this.itnext = this.itnext.tail;
		}
	}

	public void set(T v) throws MLInvalidAccessException{
		if (!hasPrevious() && itnext.isEmpty()) {
			throw new MLInvalidAccessException(13);
		}
		if (!hasPrevious()) {
			itnext.data = v;
		}else {
		MyList<T> current = this.itprev;
		goToBegin();
		while (itnext != current) {
			this.itprev = this.itnext;
			this.itnext = this.itnext.tail;
		}
		this.itprev = this.itnext;
		this.itnext = this.itnext.tail;
		itprev.data = v;
		}
		
	}
	
	public void add(T v) {
		//System.out.println(itprev.data);
		if (itprev == null) {
			MyList<T> newList = new MyList<T>();
			newList.data = v;
			newList.tail = list;
			list = newList;
		}else {
	    MyList<T> current = this.itprev;
		goToBegin();
		while (itnext != current) {
			this.itprev = this.itnext;
			this.itnext = this.itnext.tail;
		}
		this.itprev = this.itnext;
		this.itnext = this.itnext.tail;
		MyList<T> newList = new MyList<T>();
		newList.data = v;
		newList.tail = itnext;
		this.itprev.tail = newList;
		}
	}

	@Override
	public void remove() throws MLInvalidAccessException{
		MyList<T> current = this.itprev;
		
		if (!hasPrevious() && itnext.isEmpty()) {
			throw new MLInvalidAccessException(13);
		}
		if (itprev == null) {
			list = list.tail;
		}
		else {
		goToBegin();
			while (this.itnext != current) {
				this.itprev = this.itnext;
				this.itnext = this.itnext.tail;
			}
			if (itnext.tail.isEmpty()) {
				itnext = new MyList<T>();
				itprev.tail = itnext;
			}else {
			this.itprev = this.itnext.tail;
			this.itnext.tail = this.itprev.tail;
			}
		}
	}

}
