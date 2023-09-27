package model;

public class Order {
    private long id;
    private long customerId;
    private long sellerId;
    private long[] books; //номера книг которые мы продали

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long[] getBooks() {
        return books;
    }

    public void setBooks(long[] books) {
        this.books = books;
    }

    public Order(long id,  long sellerId,long customerId, long[] books) {
        this.id = id;
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.books = books;
    }
}
