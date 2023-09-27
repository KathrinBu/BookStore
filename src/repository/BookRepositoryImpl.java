package repository;

import model.*;
import repository.datasource.BookDataSource;

import java.util.ArrayList;
import java.util.HashMap;

public class BookRepositoryImpl implements BookRepository{
    private final BookDataSource bookDataSource;

    public BookRepositoryImpl(BookDataSource dataSource) {
        this.bookDataSource = dataSource;
    }

    public BookGenre getMostPopularGenreLessThanAge(int age){
        ArrayList<Long> customersIds=new ArrayList<>();
        for (Customer c:bookDataSource.getCustomers()) {
            if (c.getAge()<age) {
                customersIds.add(c.getId());
            }
        }
        return getMostPopularBookGenre(customersIds);
    }
    public BookGenre getMostPopularGenreMoreThanAge(int age){
        ArrayList<Long> customersIds=new ArrayList<>();
        for (Customer c:bookDataSource.getCustomers()) {
            if (c.getAge()>age) {
                customersIds.add(c.getId());
            }
        }
        return getMostPopularBookGenre(customersIds);
    }

    private BookGenre getMostPopularBookGenre(ArrayList<Long> customersIds) {
        int countArt=0;
        int countPr=0;
        int countPs=0;
        for (Order o:bookDataSource.getOrders()) {
            if (customersIds.contains(o.getCustomerId())){
                countArt+=getCountSoldBooksByGenre(o,BookGenre.ART);
                countPr+=getCountSoldBooksByGenre(o,BookGenre.PROGRAMMING);
                countPs+=getCountSoldBooksByGenre(o,BookGenre.PSYCHOLOGY);
            }
        }
        ArrayList<BookMore> res=new ArrayList<>();
        res.add(new BookMore(BookGenre.ART, countArt));
        res.add(new BookMore(BookGenre.PROGRAMMING,countPr));
        res.add(new BookMore(BookGenre.PSYCHOLOGY, countPs));
        res.sort((o1, o2) -> o2.getCount()- o1.getCount()); //сортируем по убыванию (те наибольший элемент будет первый в списке)
        return res.get(0).getGenre();
    }


    public ArrayList<BookMore> getCountOfSoldBooksByGenre(){
        ArrayList<BookMore> result=new ArrayList<>();
        int countArt=0;
        int countPr=0;
        int countPs=0;
        for (Order or: bookDataSource.getOrders()) {
            countArt+=getCountSoldBooksByGenre(or,BookGenre.ART);
            countPr+=getCountSoldBooksByGenre(or,BookGenre.PROGRAMMING);
            countPs+=getCountSoldBooksByGenre(or,BookGenre.PSYCHOLOGY);
        }
        result.add(new BookMore(BookGenre.ART, countArt));
        result.add(new BookMore(BookGenre.PROGRAMMING,countPr));
        result.add(new BookMore(BookGenre.PSYCHOLOGY, countPs));
        return result;
    }

    public int getCountSoldBooksByGenre(Order order,BookGenre bookGenre){
        int count=0;
        for (long bookId: order.getBooks()) {
            Book book=getBookById(bookId);
            if (book !=null && book.getBookGenre()==bookGenre){
                count++;
            }
        }
        return count;
    }

    public HashMap<BookGenre,Double> getPriceOfSoldBooksByGenre(){
        HashMap<BookGenre,Double> result=new HashMap<>();
        double priceArt=0;
        double pricePr=0;
        double pricePs=0;
        for (Order or: bookDataSource.getOrders()) {
            priceArt+=getPriceSoldBooksByGenre(or,BookGenre.ART);
            pricePr+=getPriceSoldBooksByGenre(or,BookGenre.PROGRAMMING);
            pricePs+=getPriceSoldBooksByGenre(or,BookGenre.PSYCHOLOGY);
        }
        result.put(BookGenre.ART,priceArt);
        result.put(BookGenre.PROGRAMMING,pricePr);
        result.put(BookGenre.PSYCHOLOGY,pricePs);
        return result;
    }

    public double getPriceSoldBooksByGenre(Order order,BookGenre bookGenre){
        double price=0;
        for (long bookId: order.getBooks()) {
            Book book=getBookById(bookId);
            if (book !=null && book.getBookGenre()==bookGenre){
                price+=book.getPrice();}
        }
        return price;
    }

    public Profit getProfitSeller(long sellerId){
        int count=0;
        double price=0;
        for (Order o: bookDataSource.getOrders()) {
            if (o.getSellerId()==sellerId){
                price+=getPriceSoldBooksInOrder(o);
                count+=o.getBooks().length;
            }
        }
        return new Profit(count,price);
    }

    public double getAllPriceSoldBooks(){
        double price=0;
        for (Order or: bookDataSource.getOrders()) {
            price+=getPriceSoldBooksInOrder(or);
        }
        return price;
    }

    public double getPriceSoldBooksInOrder(Order order){
        double price=0;
        for (long bookId: order.getBooks()) {
            Book book=getBookById(bookId);
            if (book !=null){
                price+=book.getPrice();}
        }
        return price;
    }

    public int getCountSoldBooks(){
        int count=0;
        for (Order o: bookDataSource.getOrders()) {
            count+=o.getBooks().length;
        }
        return count;
    }


    public Book getBookById(long id){
        Book current=null;
        for (Book b: bookDataSource.getBooks()) {
            if (b.getId()==id){
                current=b;
                break;
            }

        }
        return current;
    }
}
