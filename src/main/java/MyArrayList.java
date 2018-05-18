import java.util.*;

public class MyArrayList<E> implements List<E> {

//TODO consider init test array in separate static method
//TODO implement grow() method and smth with check of array space
//TODO add break in cycles of your tests
//TODO constructor with collection param
//TODO reduce the size of array after a certain amount of removals

    public static void main(String[] args) {
        List<String> strings = new MyArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add("test0");
        }
        strings.add("test simple");

        List<String> list = new ArrayList<>();

        strings.add("test0");

        for (String s : strings) {
            System.out.println(s);
        }
    }

    private Object[] values;
    private int size;

    public MyArrayList() {
        values = new Object[10];
        size = 0;
    }
    public MyArrayList(int initialCapacity) {
        values = new Object[initialCapacity];
    }
    public MyArrayList(Collection<? extends Object> c) {
        if (c.size() != 0) {
            values = c.toArray();

            if (!Objects.equals(values.getClass(), Object[].class)) {
                values = Arrays.copyOf(values, values.length, Object[].class);
            }
            size = values.length;

        } else {
            values = new Object[10];
            size = 0;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, values[i])) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator(values);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(values, 0, array, 0, size);

        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {

        if (a.length >= size) {
            System.arraycopy(values, 0, a, 0, size);
            Arrays.fill(a, size, a.length - 1, null);
            return a;

        } else {
            return (T[]) Arrays.copyOf(values, size);
        }
    }

    @Override
    public boolean add(E e) {

        if ((size + 1) > values.length) {
            Object[] temp = values;
            values = new Object[(values.length * 3) / 2];
            System.arraycopy(temp, 0, values, 0, size);
        }

        values[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, values[i])) {

                System.arraycopy(values, i + 1, values, i, size - i);
                values[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] coll = c.toArray();

        if (values.length < (size + coll.length)) {
            Object[] temp = values;
            values = new Object[((size + coll.length) * 3) / 2];
            System.arraycopy(temp, 0, values, 0, size);
        }

        System.arraycopy(coll, 0, values, size, coll.length);
        size += coll.length;

        return containsAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] coll = c.toArray();
        Object[] temp = values;

        if (values.length < (size + coll.length)) {
            values = new Object[((size + coll.length) * 3) / 2];
            System.arraycopy(temp, 0, values, 0, index);
        }

        System.arraycopy(coll, 0, values, index, coll.length);
        System.arraycopy(temp, index, values, index + coll.length, size - index);

        return containsAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (Object o : c) {
            for (int i = 0; i < size; i++) {

                if (Objects.equals(o, values[i])) {
                    System.arraycopy(values, i + 1, values, i, size - i);
                    values[--size] = null;
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) values[index];
    }

    @Override
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        values[index] = element;
        return (E) values[index];
    }

    @Override
    public void add(int index, E element) {
        Objects.checkIndex(index, size);
        Object[] temp = values;

        if ((size + 1) >= values.length) {
            values = new Object[(values.length * 3) / 2];
        }

        System.arraycopy(temp, 0, values, 0, index);
        values[index] = element;
        System.arraycopy(temp, index, values, index + 1, temp.length - index);
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);

        Object[] temp = values;
        values = new Object[values.length - 1];
        System.arraycopy(temp, 0, values, 0, index);
        System.arraycopy(temp, index + 1, values, index, temp.length - (index + 1));
        size--;

        return (E) temp[index];
    }

    @Override
    public int indexOf(Object o) {

        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, values[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, values[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        Objects.checkFromToIndex(fromIndex, toIndex, size);

        Object[] subArray = new Object[toIndex - fromIndex];
        System.arraycopy(values, fromIndex, subArray, 0, toIndex - fromIndex);
        return Arrays.asList((E) subArray);
    }

    public E[] grow() {
        return null;
    }
}
