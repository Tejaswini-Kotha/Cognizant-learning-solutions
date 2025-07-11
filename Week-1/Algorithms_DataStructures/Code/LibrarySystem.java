import java.util.*;

class Book {
    int id;
    String title;
    String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "ID -> " + id + " | Title -> " + title + " | Author -> " + author;
    }
}

public class LibrarySystem {

    public static Book searchLinear(List<Book> books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public static Book searchBinary(List<Book> books, String title) {
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books.get(mid).title.compareToIgnoreCase(title);
            if (cmp == 0) return books.get(mid);
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(101, "5 am Club", "Robin Sharma"));
        books.add(new Book(102, "Diary of Anna", "Anne Frank"));
        books.add(new Book(103, "Python Guide", "Guido van Rossum"));

        System.out.println(" Linear Search Result for 'Diary of Anna':");
        Book result1 = searchLinear(books, "Diary of Anna");
        System.out.println(result1 != null ? result1 : "Book not found");

        Collections.sort(books, Comparator.comparing(b -> b.title));

        System.out.println("\n Binary Search Result for 'Diary of Anna':");
        Book result2 = searchBinary(books, "Diary of Anna");
        System.out.println(result2 != null ? result2 : "Book not found");
    }
}
