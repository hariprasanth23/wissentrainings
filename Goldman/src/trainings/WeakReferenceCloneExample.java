package trainings;

import java.lang.ref.WeakReference;

class WeakReferenceOne{
    int x, y;
}

class WeakReferenceTwo implements Cloneable {
    int a;
    int b;
    WeakReferenceOne c = new WeakReferenceOne();
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}


public class WeakReferenceCloneExample {
    public static void main(String args[])
            throws CloneNotSupportedException
    {
        WeakReferenceTwo t1 = new WeakReferenceTwo();
        t1.a = 10;
        t1.b = 20;
        t1.c.x = 30;
        t1.c.y = 40;

        WeakReferenceTwo t2 = (WeakReferenceTwo)t1.clone();

        WeakReference<WeakReferenceTwo> weakRef2 = new WeakReference<>(t2);
        System.out.println("weakRef2-->"+weakRef2);
        weakRef2 = null;
        weakRef2.get();
        System.out.println("weakRef2-->"+weakRef2.get());

        t2.a = 100;
        t2.c.x = 300;
        System.out.println(t1.a + " " + t1.b + " " + t1.c.x + " " + t1.c.y);
        System.out.println(t2.a + " " + t2.b + " " + t2.c.x + " " + t2.c.y);
    }
}
