package listi;

public interface IList<T> {
	public T get(int index);
	public void set(int index, T obj);
	public void add(int index, T obj);
	public int indexOf(T obj);
	public T remove(int index);
	public boolean remove(T obj);
	
}
