package gfg.designpattern;

class SingleObject {

    private static SingleObject instance = null;
    private SingleObject(){}
    public static SingleObject getInstance(){
        if (instance == null) {
            instance = new SingleObject();
        }
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
}

class SingletonDemo {
    public static void main(String args[])
    {
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}
//lazy loading
// reflection

