import java.util.function.*;
import java.util.*;

class Book
{
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages)
    {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle()
    {
        return this.title;
    }
    public String getAuthor()
    {
        return this.author;
    }
    public int getPages()
    {
        return this.pages;
    }

    @Override
    public String toString()
    {
        return this.title + ", " + this.author + ", " + this.pages;
    }
}


public class Sorting {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList(List.of(
                new Book("detective", "Agatha Christie", 100 ),
                new Book("dramatic", "Tolstoy", 80),
                new Book("romantic", "Nuray Namazova", 60)
        ));


        //with lambda
        books.sort((b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
        books.forEach(System.out::println);
        System.out.println();


        //with method reference
        books.sort(Comparator.comparing(Book::getAuthor));
        books.forEach(System.out::println);
        System.out.println();


        books.sort((b1,b2) -> b2.getPages() - b1.getPages());
        books.forEach(System.out::println);
        System.out.println();

        books.sort(
                Comparator.comparing(Book::getAuthor)
                        .thenComparing(Book::getTitle)
        );
        books.forEach(System.out::println);
        System.out.println();
    }




}
