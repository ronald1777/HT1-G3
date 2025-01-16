public class Licuadora implements LicuadoraInterface {
    int currentElements = 0;
    boolean state = false;
    boolean full = false;
    int speed = 0;

    public void addElement () {
        if (full) {
            currentElements++;
        }
        full = (currentElements > 5) ? true : false;
    }

    public boolean isFull () {
        return full;
    }

    public boolean changeSpeed(boolean increase) {

        if (isFull()) {
            if (increase) {
        
            speed = (speed + 1) > 10 ? 0 : speed + 1;
            return true; 
            // Changed the speed succesfully
        }
        else {
            speed = (speed - 1) < 0 ? 0 : speed - 1;
            return true; 
            // Changed the speed succesfully
            }
        } else {
            return false; 
            //Licuadora isnt full, couldnt change speed
        }
    }

    public int checkSpeed() {
        if (speed == 0) {
            state = false;
            return speed;
        } else {
            state = true;
            return speed;
        }
    }
}
