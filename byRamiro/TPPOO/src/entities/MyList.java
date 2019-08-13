package entities;

import exception.MLInvalidAccessException;

public class MyList<T> {
	public T data;
	public MyList<T> tail;

	public MyList() {
		this.data = null;
		this.tail = null;
	}

	public MyList(T v) {
		this.data = v;
		this.tail = new MyList<T>();
	}

	public MyList(T[] v) {
		if (v == null) {
			this.data = null;
			this.tail = null;
		} else {
			MyList<T> list = this;
			for (int i = 0; i < v.length; i++) {
				list.data = v[i];
				list.tail = new MyList<T>();
				list = list.tail;
			}
		}
	}

	public boolean isEmpty() { // retourne vrai si la MyList est vide.
		return (this.data == null) && (this.tail == null);
	}

	public Integer size() {
		int counter = 0;
		MyList<T> w = this;
		while (!w.isEmpty()) {
			counter++;
			w = w.tail;
		}
		return counter;
	}

	public Object[] toArray() { // retourne le tableau d’Object correspondant à la MyList.
		Object[] objectArray = new Object[size()];
		MyList<T> w = this;
		int i = 0;
		while (!w.isEmpty()) {
			objectArray[i] = w.data;
			i++;
			w = w.tail;
		}
		return objectArray;
	}

	public MyList<T> copy() { // retourne une copie (deep clone) de la MyList.
		MyList<T> temp = new MyList<T>();
		MyList<T> old = this;
		MyList<T> newList = temp;
		while (!old.isEmpty()) {
			newList.data = old.data;
			newList.tail = new MyList<T>();
			newList = newList.tail;
			old = old.tail;
		}
		return temp;
	}

	public T head() throws MLInvalidAccessException { 		// retourne la valeur de « data » du premier nœud.
		if (this.isEmpty()) {
			throw new MLInvalidAccessException(1);
		}else {
			return this.data;
		}
	}

	public MyList<T> tail() { // retour la MyList sans le premier nœud. public T
		return this.tail;
	}

	public T end() throws MLInvalidAccessException { // retourne la valeur de « data » du dernier nœud.
		MyList<T> w = this;
		while (!w.tail.isEmpty()) {
			w = w.tail;
		}
		if (w.isEmpty()) {
			throw new MLInvalidAccessException(2);
		}
		return w.data;
	}

	public void append(T e) { 		// crée un nœud avec « data »=e à la fin de la MyList.
		MyList<T> w = this;
		if (w.isEmpty()) {
			throw new MLInvalidAccessException(2);
		}
		while (!w.isEmpty()) {
			w = w.tail;
		}
		w.data = e;
		w.tail = new MyList<T>();
		
	}

	public void concat(MyList<T> lc) { // fait la concatenation de lc à fin de la // MyList.
		MyList<T> w = this;
		if (w.isEmpty()) {
			throw new MLInvalidAccessException(2);
		}
		if (lc == w) {
			MyList<String> newList = (MyList<String>) lc.copy();
			while (!w.isEmpty()) {
				w = w.tail;
			}
			w.data = (T) newList.data;
			w.tail = (MyList<T>) newList.tail;
			
		} else {
		while (!w.isEmpty()) {
			w = w.tail;
		}
		w.data = lc.data;
		w.tail = lc.tail;
		}
	}

	public MyListIterator<T> myListIterator() { // méthode pour initialiser l’iterateur MyListIterator.
		return new MyListIterator<T>(this);
	}

}
