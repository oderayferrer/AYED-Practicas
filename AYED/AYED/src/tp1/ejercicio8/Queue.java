package tp1.ejercicio8;

import java.util.*;

public class Queue<T> extends Sequence{
	protected List<T> data;
	
	public Queue() {
		super();
		this.data = new LinkedList<T>();
	}

	public void enqueue(T dato) {
		data.add(dato);
	}
	
	public T dequeue() {
		return data.remove(0);
	}
	
	public T head() {
		return data.get(0);
	}
	
	@Override
	public int size() {
		return data.size();
	}
	
	@Override
	public boolean isEmpty() {
		return data.size() == 0;
	}
	
	public String toString() {
		String s = " ";
		for (T d : data ) {
			s = s + d +" \n";
		}
		return s;
	}
	
	
}
