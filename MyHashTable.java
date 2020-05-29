import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Enumeration;

public class MyHashTable<K,V> {

  private MyHashTableEntry<K,V>[] hashTable;
  private int size = 0;
  private static final int INITIAL_SIZE = 10;

  public MyHashTable() {
    this(INITIAL_SIZE);
  }

  public MyHashTable(int size) {
    this.hashTable = new MyHashTableEntry[size];
  }

  public void clear() {
    this.hashTable = new MyHashTableEntry[INITIAL_SIZE];
    this.size = 0;
  }

  public V get(K key) {
    int hashCode = hashCode(key);
    MyHashTableEntry<K,V> current = hashTable[hashCode];
    V value = null;
    while (current != null && value == null) {
      if (current.key.equals(key)) {
        value = current.value;
      }
      current = current.next;
    }
    return value;
  }

  public void put(K key, V value) {
    int hashCode = hashCode(key);
    MyHashTableEntry<K,V> current = hashTable[hashCode];
    if (current == null) {
      hashTable[hashCode] = new MyHashTableEntry<>(key, value);
      size++;
    } else {
      while (current.next != null && current.key != key) {
        current = current.next;
      }
      if (current.key == key) {
        current.value = value;
      } else {
        current.next = new MyHashTableEntry<>(key, value);
        size++;
      }
    }
  }

  public V remove(K key) { 
    int hashCode = hashCode(key);
    MyHashTableEntry<K,V> current = hashTable[hashCode];
    MyHashTableEntry<K,V> prev = null;
    while (current != null && current.key != key) {
      prev = current;
      current = current.next;
    }
    if (current == null) {
      return null;
    }
    V value = current.value;
    if (prev != null) {
      prev.next = current.next;
    } else {
      hashTable[hashCode] = current.next;
    }
    size--;
    return value;
  }

  public int size() {
    return this.size;
  }

  public Enumeration<K> keys() {
    List<K> listOfKeys = new ArrayList<>(this.size());
    for (int i = 0; i < hashTable.length; i++) {
      MyHashTableEntry<K,V> current = hashTable[i];
      while (current != null) {
        listOfKeys.add(current.key);
        current = current.next;
      }
    }

    return new Enumeration<K>() {
      List<K> keys = listOfKeys;
      int currentIndex = 0;

      public boolean hasMoreElements() {
        return currentIndex < keys.size();
      }

      public K nextElement() {
        return keys.get(currentIndex++);
      }
    };
  } 

  private int hashCode(K key) {
    return key.hashCode() % hashTable.length;
  }

  private class MyHashTableEntry<K,V> {
    K key;
    V value;
    MyHashTableEntry<K,V> next;

    public MyHashTableEntry(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}