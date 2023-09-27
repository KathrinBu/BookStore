import model.*;
import repository.BookRepository;
import repository.BookRepositoryImpl;
import repository.datasource.BookDataSource;
import repository.datasource.BookDataSourceImpl;


public class Main {

    public static void main(String[] args) {
        BookDataSource bookDataSource = new BookDataSourceImpl();
        BookRepository bookRepository = new BookRepositoryImpl(bookDataSource);
        Holder holder = new Holder(bookRepository, bookDataSource);
        holder.show();
    }
}
