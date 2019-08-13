package myCompositeList;

class MyList<T> {
	private boolean IsEmpty;
	private T data;
	private MyList<T> tail;

	public MyList() {
		this.IsEmpty = true;
		this.data = null;
		this.tail = null;
	}

	public MyList(boolean isEmpty, T data, MyList<T> tail) {
		super();
		IsEmpty = isEmpty;
		this.data = data;
		this.tail = tail;
	}

	public MyList(T data) {
		this.IsEmpty = false;
		this.data = data;
		this.tail = new MyList<T>();
	}

	public MyList(T[] data) {
		if (data == null) {
			this.IsEmpty = true;
			this.data = null;
			this.tail = null;
		} else {
			MyList<T> list = this;
			for (int i = 0; i < data.length; i++) {
				list.IsEmpty = false;
				list.data = data[i];
				list.tail = new MyList<T>();
				list = list.tail;
			}
		}

	}

}
