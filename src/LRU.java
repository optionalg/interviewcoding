import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/*
class ListNode<T>
{
	private T           value;
	private ListNode<T> prev;
	private ListNode<T> next;
	
	public ListNode(T v) {
		value = v;
		prev = this;
		next = this;
	}
	
	public T getValue() {
		return value;
	}
	
	public ListNode<T> getPrev() {
		return prev;
	}
	
	public ListNode<T> getNext() {
		return next;
	}
	
	public void setValue(T v) {
		value = v;
	}
	
	public void setPrev(ListNode<T> p) {
		prev = p;
	}
	
	public void setNext(ListNode<T> n) {
		next = n;
	}
}

class LinkedList<T>
{
	private final ListNode<T> head = new ListNode<T>(null);
	private int size = 0;

	public void insert(ListNode<T> location, ListNode<T> node)
	{
		if(location == null || node == null)
			return;
		node.setPrev(location);
		node.setNext(location.getNext());
		location.getNext().setPrev(node);
		location.setNext(node);
		size ++;
	}
	
	public void remove(ListNode<T> node)
	{
		if(node == null || node == head)
			return;
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
	}
	
	public int getSize() {
		return size;
	}
	
	public ListNode<T> getHead() {
		return head;
	}
	
	public ListNode<T> getTail() {
		return head.getPrev();
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		ListNode<T> node = getHead().getNext();
		while(node != getHead())
		{
			builder.append(node.getValue().toString());
			node = node.getNext();
		}
		return builder.toString();
	}
}
*/

public class LRU<T>
{
	private final HashMap<T, Iterator<T>> map  = new HashMap<T, Iterator<T>>();
	private final LinkedList<T>           list = new LinkedList<T>();
	private final int capacity;
	
	public LRU(int size) {
		capacity = size;
	}
	
	@Override
	public String toString() {
		return "LRU, capacity = " + capacity + ", contents: " + list.toString();
	}
	
	/**
	 * @return the most frequent one
	 */
	public T get()
	{
		if(list.size() == 0)
			return null;
		return list.getFirst();
	}
	
	/**
	 * Save the value into the cache
	 */
	public void put(T value)
	{
		Iterator<T> node = map.get(value);
		if(node != null)
		{
			list.remove(node);
			map.remove(value);
		}
		list.addFirst(value);
		map.put(value, node);
		enforceCapacity();
	}
	
	private void enforceCapacity()
	{
		if(list.size() > capacity)
		{
			T lastValue = list.getLast();
			list.removeLast();
			map.remove(lastValue);
		}
	}
	
	public boolean contains(T value) {
		return map.containsKey(value);
	}
	
	public static void main(String[] args)
	{
		LRU<String> lru = new LRU<String>(5);
		lru.put("A");
		lru.put("B");
		lru.put("C");
		lru.put("D");
		lru.put("E");
		lru.put("F");
		System.out.println(lru);
	}

}
