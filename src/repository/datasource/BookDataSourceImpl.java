package repository.datasource;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class BookDataSourceImpl implements BookDataSource {
   private List<Book> books=new ArrayList<>();
    private List<Customer> customers=new ArrayList<>();
    private List<Seller> sellers=new ArrayList<>();
    private List<Order> orders=new ArrayList<>();

    public BookDataSourceImpl(){
    initData();
    }
    private void initData(){
        sellers.add(new Seller(1,"Ivanov Ivan", 33));
        sellers.add(new Seller(2, "Petrova Maria",25));
        sellers.add(new Seller(3, "Sidorov Kassir", 44));

        customers.add(new Customer(1,"AS",19));
        customers.add(new Customer(2,"ER", 21));
        customers.add(new Customer(3,"HJ",35));
        customers.add(new Customer(4, "TY", 45));
        customers.add(new Customer(5, "VB", 31));

        books.add(new Book(1,"Tom Soiier","Mark Tven",500, BookGenre.ART));
        books.add(new Book(2,"Piraty","Sinjj Boroda",875,BookGenre.ART));
        books.add(new Book(3,"Very v tebj","Lyboi chel",900,BookGenre.PSYCHOLOGY));
        books.add(new Book(4,"Java","TeamLead",3500,BookGenre.PROGRAMMING));
        books.add(new Book(5,"Python","Vas",3450,BookGenre.PROGRAMMING));
        books.add(new Book(6,"HTML", "King",3325, BookGenre.PROGRAMMING));
        books.add(new Book(7,"Ne vry nnikomy","Teacher",1100,BookGenre.PSYCHOLOGY));
        books.add(new Book(8,"wonderful world","Freddy",790,BookGenre.PSYCHOLOGY));
        books.add(new Book(9,"Vpered v gory", "Pyteshestvennik", 330, BookGenre.ART));
        books.add(new Book(10,"FairyTailes of Old Rabbit", "Old Rabbit", 820, BookGenre.ART));

        orders.add(new Order(1,1,1, new long[]{8,9,10,11}));
        orders.add(new Order(2,1,2,new long[]{1}));
        orders.add(new Order(3,2,3,new long[]{5,6,7}));
        orders.add(new Order(4,2,4,new long[]{1,3,4,5}));
        orders.add(new Order(5,3,5,new long[]{2,5,9}));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public List<Seller> getSellers() {
        return sellers;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }
}
