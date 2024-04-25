package queueTesting;

public class ArrayListKingdom<T> implements ListADT<T> {
    private int DEFAULT_CAPACITY = 100;
    private T[] list;
    private int size;

    public ArrayListKingdom() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(int index, T element) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index);
        }

        if (size >= list.length) {
            expandCapacity();
        }

        for (int i = size - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }

        list[index] = element;
        size++;
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index:" + index);
        }
        list[index] = element;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalStateException("index:" + index);
        }
        return list[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index:" + index);
        }

        T result = list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;

        return result;
    }

    @Override
    public T remove(T element) {
        int index = indexOf(element);

        if (index == -1) {
            throw new IllegalStateException();
        }

        return remove(index);
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T element) {
        return (indexOf(element) != -1);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return true;
    }

    public String toString() {
        String result = "{";
        for (int i = 0; i < size(); i++) {
            result += list[i];
            if (i != size() - 1) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }

    private void expandCapacity() {
        @SuppressWarnings("unchecked")
        T[] tmp = (T[]) new Object[list.length * 2];
        for (int i = 0; i < size; i++) {
            tmp[i] = list[i];
        }
        list = tmp;
    }
}
