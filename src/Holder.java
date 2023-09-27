import model.BookGenre;
import model.BookMore;
import model.Seller;
import repository.BookRepository;
import repository.datasource.BookDataSource;

import java.util.ArrayList;
import java.util.HashMap;

public class Holder {
    private final BookRepository repository;
    private final BookDataSource bookDataSource;

    public Holder(BookRepository repository, BookDataSource bookDataSource) {
        this.repository = repository;
        this.bookDataSource = bookDataSource;
    }
    public void show(){
        String info=String.format("Общее количество проданных книг %d на сумму %f",repository.getCountSoldBooks(), repository.getAllPriceSoldBooks());
        System.out.println(info);
        System.out.println("====================");
        //сколько книг продал каждый продавец
        for (Seller s: bookDataSource.getSellers()) {
            System.out.println(s.getName()+" продал(а) " + repository.getProfitSeller(s.getId()).toString());
        }
        System.out.println("=================");
        //общая стоимость книг по определенному жанру в одном заказе
        ArrayList<BookMore> countSoldBooks=repository.getCountOfSoldBooksByGenre();
        HashMap<BookGenre, Double> priceSoldBooks=repository.getPriceOfSoldBooksByGenre();
        String soldBooksGenre="По жанру %s продано %d книг общей стоимостью %f";
        for (BookMore bm:countSoldBooks) {
            double pr=priceSoldBooks.get(bm.getGenre());
            System.out.println(
                    String.format(soldBooksGenre,
                            bm.getGenre().name(),bm.getCount(),pr));
        }
        System.out.println("==================");
        //самый популярный жанр у людей до 30 лет и после 30 лет
        int age=30;
        String less="Покупатели до %d лет выбирают жанр %s";
        String more="Покупатели после %d лет выбирают жанр %s";
        System.out.println(
                String.format(less,age,repository.getMostPopularGenreLessThanAge(age)));
        System.out.println(
                String.format(more,age,repository.getMostPopularGenreMoreThanAge(age)));
    }
}
