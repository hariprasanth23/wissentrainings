package trainings;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
class Test implements Cloneable{
    public void testReference(){
        System.out.println("Testing reference");
    }
}

public class ReferenceExample{
    public static void main(String[] args) throws CloneNotSupportedException {
        // Strong reference
        String str = "Hello, world!";



//        SoftReference<String> softRef = new SoftReference<>(str);
//        str = null;
//        System.out.println("Soft Reference-->"+softRef.get());



//        Test test = new Test();
//        test.testReference();
//        WeakReference<Test> weakRef1 = new WeakReference<>(test);
//        test = null;
//        System.out.println("Weak Reference-->"+test);
//        test = weakRef1.get();
//        test.testReference();


//        ReferenceQueue<String> queue = new ReferenceQueue<>();
//        PhantomReference<String> phantomRef = new PhantomReference<>(str, queue);
//        str = null;
//        System.out.println(phantomRef.get());
    }
}
