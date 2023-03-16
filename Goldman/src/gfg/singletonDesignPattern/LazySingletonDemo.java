package gfg.singletonDesignPattern;

class LazySingleton{

    private LazySingleton(){}

    private static LazySingleton instance;

    public static LazySingleton getInstance(){
        if(instance == null){
            return instance = new LazySingleton();
        }else{
            return instance;
        }
    }
}

public class LazySingletonDemo {
    public static void main(String[] args){

        LazySingleton obj1 = LazySingleton.getInstance();
        System.out.println(obj1.hashCode());

        LazySingleton obj2 = LazySingleton.getInstance();
        System.out.println(obj2.hashCode());

    }
}
