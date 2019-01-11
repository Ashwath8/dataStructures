import java.util.Iterator;
import java.util.LinkedList;

public class Hashing<K, V> implements Iterable<K> {
    int numElements, tableSize;
    double maxLoadFactor;
    LinkedList<HashElement<K, V>>[] hArray;

    // Initializing the Hash Object
    public Hashing(int tableSize) {
        this.tableSize = tableSize;
        hArray = (LinkedList<HashElement<K, V>>[]) new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hArray[i] = new LinkedList<HashElement<K, V>>();
        }
        maxLoadFactor = 0.75;
        numElements = 0;
    }

    public boolean add(K key, V value) {
        if (loadFactor() > maxLoadFactor) {
            resize(tableSize * 2);
        }
        HashElement<K, V> hashElement = new HashElement(key, value);
        int hashval = key.hashCode();
        hashval = hashval & 0x7FFFFFFF;
        hashval = hashval % tableSize;
        hArray[hashval].add(hashElement);
        numElements++;
        return true;

    }

    public double loadFactor() {
        return numElements / tableSize;
    }

    public void resize(int newTableSize) {
        LinkedList<HashElement<K, V>>[] newArray = (LinkedList<HashElement<K, V>>[]) new LinkedList[newTableSize];
        for (int i = 0; i < newTableSize; i++) {
            newArray[i] = new LinkedList<HashElement<K, V>>();
        }
        for (K key : this) {
            V value = getValue(key);
            HashElement<K, V> he = new HashElement<K, V>(key, value);
            int hashval = key.hashCode();
            hashval = hashval & 0x7FFFFFFF % tableSize;
            newArray[hashval].add(he);
        }
        hArray = newArray;
        tableSize = newTableSize;
    }

    public V getValue(K key) {
        // Getting the index in the hash array
        int hashval = key.hashCode() & 0x7FFFFFFF % tableSize;
        for (HashElement<K, V> he : hArray[hashval]) {
            if (((Comparable<K>) key).compareTo(he.key) == 0) {
                return he.value;
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new HashIteratorHelper();
    }


    class HashIteratorHelper<T> implements Iterator<T> {
        T[] keys;
        int position;

        public HashIteratorHelper() {
            keys = (T[]) Object[numElements];
            int p = 0;
            for (int i = 0; i < tableSize; i++) {
                LinkedList<HashElement<K, V>> list = hArray[i];
                for (HashElement<K, V> h : list) {
                    keys[p++] = (T) h.key;
                }
            }
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < keys.length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            return keys[position++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class HashElement<K, V> implements Comparable<HashElement<K, V>> {
        K key;
        V value;

        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(HashElement<K, V> o) {
            return (((Comparable<K>) this.key).compareTo(o.key));
        }

        @Override
        public String toString() {
            return this.key + " " + this.value;
        }
    }
}

