package model;

public class Profit {
    private int count;
    private double price;

    @Override
    public String toString() {
        return "всего " + count +
                " книг на сумму " + price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Profit(int count, double price) {
        this.count = count;
        this.price = price;
    }
}
