package repository;

import model.BookGenre;
import model.BookMore;
import model.Profit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface BookRepository {
    int getCountSoldBooks();
    double getAllPriceSoldBooks();
    Profit getProfitSeller(long sellerId);
    ArrayList<BookMore> getCountOfSoldBooksByGenre();
    HashMap<BookGenre, Double> getPriceOfSoldBooksByGenre();
    BookGenre getMostPopularGenreLessThanAge(int age);
    BookGenre getMostPopularGenreMoreThanAge(int age);

}
