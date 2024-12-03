public class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getBox() {
        T temp = this.content;
        this.content = null;
        return temp;
    }

    public void setBox(T content) {
        if (isFull()) throw new IllegalArgumentException("Коробка не пуста. Сначала достаньте объект из коробки с помощью getBox()");
        this.content = content;
    }

    public boolean isFull() {
        if (this.content == null) return false;
        return true;
    }
}
