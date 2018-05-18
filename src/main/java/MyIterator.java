import java.util.Iterator;

public class MyIterator<T> implements Iterator {

    private T[] objects;
    private int index = 0;

    public MyIterator(T[] objects) {
        this.objects = objects;
    }

    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    @Override
    public T next() {
        return objects[index++];
    }

}
