package gfg.strategyDesignPattern;

public class Item {
    private String productCode;
    private int price;

    public Item(String productCode, int cost){
        this.productCode=productCode;
        this.price=cost;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getPrice() {
        return price;
    }
}
