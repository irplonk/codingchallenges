public class MyArrayList<T> {

  private T[] array;
  private int size = 0;
  private static final int INITIAL_LENGTH = 10;

  public MyArrayList() {
    this(INITIAL_LENGTH);
  }

  public MyArrayList(int length) {
    array = (T[]) new Object[length];
  }

  public T get(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return array[index];
  }

  public int size() {
    return size;
  }

  public void add(T element) {
    if (size == array.length) {
      doubleArrayLength();
    }
    array[size++] = element;
  }

  public void add(int index, T element) {
    if (index > size) {
      throw new IndexOutOfBoundsException();
    }
    if(size == array.length) {
      doubleArrayLength();
    }
    for (int i = index + 1; i < size + 1; i++) {
      array[i] = array[i - 1];
    }
    array[index] = element;
    size++;
  }

  public void remove(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }
    for (int i = index; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    array[size--] = null;
  }

  public boolean remove(T element) {
    int index = 0;
    boolean found = false;
    while (index < size && !found) {
      if (element == null ? array[index] == null : array[index].equals(element)) {
        found = true;
      }
      index++;
    }
    remove(index);
    return found;
  }

  public void clear() {
    array = (T[]) new Object[INITIAL_LENGTH];
    size = 0;
  }

  public boolean contains(T element) {
    boolean found = false;
    int index = 0;
    while (index++ < size && !found) {
      if (element == null ? array[index] == null : array[index].equals(element)) {
        found = true;
      }
    }
    return found;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void printContents() {
    System.out.print("[ ");
    for (int i = 0; i < size; i++) {
      System.out.print(array[i]);
      System.out.print(" ");
    }
    System.out.println(" ]");
  }

  private void doubleArrayLength() {
    T[] newArray = (T[]) new Object[array.length * 2];
    for (int i = 0; i < array.length; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }
}