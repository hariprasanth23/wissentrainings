package multithreading.getAndSetName;

class ThreadName extends Thread{

}

public class ThreadNameDemo {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        System.out.println(new ThreadName().getName());
        Thread.currentThread().setName("Hari Thread");
        System.out.println(Thread.currentThread().getName());
    }
}
