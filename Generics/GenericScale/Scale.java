package GenericScale;

public class Scale<T extends Comparable<T>> {
    T firstElement;
    T secondElement;

    public Scale(T firstElement, T secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public T getHeavier() {
        if (this.firstElement.compareTo(this.secondElement) > 0) {
            return this.firstElement;
        }
        if (this.firstElement.compareTo(this.secondElement) < 0) {
            return this.secondElement;
        }
        return null;
    }
}
