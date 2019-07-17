package javaSource.lang.genericity.util;

public class InfoImpl<T> implements Info<T> {

    private T value;

    public InfoImpl(T value) {
        setValue(value);
    }

    @Override
    public T getVal() {
        return this.getValue();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
