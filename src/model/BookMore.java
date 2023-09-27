package model;

public class BookMore {
    private BookGenre genre;
    private int count;

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BookMore(BookGenre genre, int count) {
        this.genre = genre;
        this.count = count;
    }
}
