package gfg.designpattern;

interface Food{
    void prepareFood();
}

class FoodOne implements Food{

    public void prepareFood() {
        System.out.println(" Food One is preparing ");
    }
}

class FoodTwo implements Food{

    public void prepareFood() {
        System.out.println(" Food Two is preparing ");
    }
}

class FoodFactory{
    public Food getFood(String food){
        if(food == null){
            return null;
        }

        if(food.equalsIgnoreCase("Food One")){
            return new FoodOne();
        } else if (food.equalsIgnoreCase("Food Two")) {
            return new FoodTwo();
        }
        return null;
    }

}
public class factory {
    public static void main(String[] args){

        FoodFactory foodFactory = new FoodFactory();
        Food food = foodFactory.getFood("Food One");
        food.prepareFood();

    }
}
//factory and abstract factory
