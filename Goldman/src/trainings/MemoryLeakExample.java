package trainings;

import java.util.ArrayList;

public class MemoryLeakExample {
    public static void main(String[] args){
        ArrayList<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());

        }
    }
}
