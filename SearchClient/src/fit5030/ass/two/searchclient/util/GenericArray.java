package fit5030.ass.two.searchclient.util;

import java.lang.reflect.*;
import java.util.LinkedList;

public class GenericArray<T> {
	private T[] array;

	@SuppressWarnings("unchecked")
	public GenericArray(Class<T> type, int size) {
		array = (T[]) Array.newInstance(type, size);
	}

	@SuppressWarnings("unchecked")
	public GenericArray(Iterable<T> collection) {
		LinkedList<T> l = new LinkedList<T>();
		Class<?> c = null;
		for (T item : collection) {
			l.add(item);
			c = item.getClass();
		}
		if (c == null)
			this.array = null;
		else {
			array = (T[]) Array.newInstance(c, l.size());
			array = l.toArray(array);
		}
	}

	public void put(int index, T item) {
		array[index] = item;
	}

	public T get(int index) {
		return array[index];
	}

	public T[] getArray() {
		return this.array;
	}
}