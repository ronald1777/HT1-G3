public class Licuadora {
    int currentElements = 0;
    boolean state = false;
    boolean full = false;
    int speed = 0;

    public void addElement () {
        if (full) {
            currentElements++;
        }
        full = currentElements > 5 ? true : false;
    }

    public boolean isFull () {
        return full;
    }
}