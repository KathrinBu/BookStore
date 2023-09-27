package repository.datasource;

import model.Book;
import model.Customer;
import model.Order;
import model.Seller;

import java.util.ArrayList;
import java.util.List;

public interface BookDataSource {
    List<Book> getBooks();
    List<Customer> getCustomers();
    List<Seller> getSellers();
    List<Order> getOrders();
}
