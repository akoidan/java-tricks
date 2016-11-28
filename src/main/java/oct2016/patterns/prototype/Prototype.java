package oct2016.patterns.prototype;

public interface Prototype<T> extends Cloneable {
    T clone() throws CloneNotSupportedException;
}
