package com.example.market_app;

public class Item {

    private int price;
    private String haircut;
    private int pic;

    public Item(int price, int pic, String haircut)
    {
        this.price=price;
        this.haircut=haircut;
        this.pic=pic;
    }

    public int getPrice() {
        return price;
    }

    public String getHaircut() {
        return haircut;
    }

    public int getPic() {
        return pic;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setHaircut(String haircut) {
        this.haircut = haircut;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
