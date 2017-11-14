import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DictionaryArray<K, V> implements DictionaryInterface<K, V> {

	public class DictionaryNode {
		public K key;
		public V value;

		public DictionaryNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
		public void setKey(K key) {
			this.key = key;
		}

	}

	private DictionaryNode[] array;
	private int size;
	public DictionaryArray()
	{
		size = array.length;
	}

	public V add(K key, V value) {
		boolean insert = true;
		// replaces
		for (int i = 0; i < size; i++) {
			if (array[i].getKey().equals(key)) {
				array[i].setValue(value);
				insert = false;
				return value;
			}
		}
		// adds new entry
		if (insert) {
			if (size == array.length) {
				int newSize = array.length * 2;
				array = Arrays.copyOf(array, newSize);
			}
			array[size++] = new DictionaryNode(key, value);
		}
		return value;
	}

	public V remove(K key) {
		DictionaryArray<K, V>.DictionaryNode temp = null;
		for (int i = 0; i < size; i++) {
			if (array[i].getKey().equals(key)) {
				temp = array[i];
				array[i] = null;
			}
			size--;
			for (int j = i; j < size; j++) {
				array[j] = array[j + 1];
			}
		}
		return temp.getValue();
	}

	public V getValue(K key) {
		for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                if (array[i].getKey().equals(key)) {
                    return array[i].getValue();
                }
            }
        }
		return null;
	}

	public boolean contains(K key) {
		boolean res = false;
		for(int i =0; i < size; i++)
		{
			if (array[i].getKey().equals(key))
			{
				res = true;
			}			
		}
		return res;
	}

	public Iterator<K> getKeyIterator() {
		List<K> iter = new ArrayList<K>();
		for(DictionaryNode d : array) {
			iter.add(d.getKey());
		}
		return iter.iterator();
	}

	public Iterator<V> getValueIterator() {
		List<V> iter = new ArrayList<V>();
		for(DictionaryNode d : array) {
			iter.add(d.getValue());
		}
		return iter.iterator();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		K temp = null;
		for (int i = 0; i < size; i++) {
			array[i].setKey(temp);
		}

	}

}
