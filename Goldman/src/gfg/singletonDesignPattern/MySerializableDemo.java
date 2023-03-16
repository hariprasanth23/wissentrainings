package gfg.singletonDesignPattern;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class LazySingletonSerializable extends MyClone implements Serializable {

    private static LazySingletonSerializable instance;

    private LazySingletonSerializable(){
        if(instance != null){
            throw new IllegalStateException(" Object cant be created");
        }
    }

    protected Object readResolve(){
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static LazySingletonSerializable getInstance(){
        if(instance == null){
            return instance = new LazySingletonSerializable();
        }else{
            return instance;
        }
    }
}

public class MySerializableDemo{
    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {

        LazySingletonSerializable instance1 = LazySingletonSerializable.getInstance();
        System.out.println(instance1.hashCode());

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        out.writeObject(instance1);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.ser"));
        LazySingletonSerializable instance2 = (LazySingletonSerializable) in.readObject();
        in.close();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }
}

