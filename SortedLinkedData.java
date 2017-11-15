import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SortedLinkedData<K, V> implements DictionaryInterface<K, V> {

	private int size;
	private Node head;

	public SortedLinkedData() {
		size = 0;
		head = null;
	}

	public V add(K key, V value) {
		boolean result = false;
		while (head.next != null) { // replaces
			if (head.key == key) {
				result = true;
				return head.value;
			}
			head = head.next;
		}
		if (head == null) { // first entry
			head.key = key;
			head.value = value;
		}
		if (!result) { // add
			Node node = new Node();
			head.next = node;
			node.key = key;
			node.value = value;
			node.next = null; // adds at end
			size++;
		}
		return null;
	}

	public V remove(K key) {
		V temp = null;
		while (head.next != null) {
			if (head.key == key) {
				temp = head.value;
				head.key = null;
			}
			head = head.next;
		}
		return temp;
	}

	public V getValue(K key) {
		while (head.next != null) {
			if (head.key == key)
				return head.value;
		}
		head = head.next;
		return null;
	}

	public boolean contains(K key) {
		boolean result = false;
		while (head.next != null) {
			if (head.key == key)
				result = true;
		}
		return result;
	}

	public Iterator<K> getKeyIterator() {
		List<K> iter = new ArrayList<K>();
		while (head.next != null) {
			iter.add(head.key);
		}

		return iter.iterator();
	}

	public Iterator<V> getValueIterator() {
		List<V> iter = new ArrayList<V>();
		while (head.next != null) {
			iter.add(head.value);
		}

		return iter.iterator();
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		while (head.next != null) {
			head.key = null;
			head.value = null;
			head = head.next;
			head.next = null;
		}

	}

	public class Node {
		private K key;
		private V value;
		private Node next;

		public Node() {
			next = null;
		}

	}
}
