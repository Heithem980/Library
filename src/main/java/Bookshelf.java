import java.util.ArrayList;
import java.util.Scanner;

public class Bookshelf {

    private int id;
    private boolean available;
    private String name;
    private String author;
    private String genre;
    private String releaseDate;
    private int userRatings;


    public static ArrayList <Bookshelf> books = new ArrayList<Bookshelf>();
    public static ArrayList <Integer> borrowedBooksID = new ArrayList<Integer>();



    public Bookshelf(int id, boolean available, String name, String author, String genre, String releaseDate, int userRatings) {
        this.id = id;
        this.available = available;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.userRatings = userRatings;
    }

    public static void addBook(Bookshelf book) {

        books.add(book);
    }

    public static String getBookNameById(int id) {

        for (Bookshelf book : books) {

            if (book.id == id) {

                return book.name;
            }

        }

        return "Book not found";
    }




    public static String searchByName(String userInput) {

        //Scanner input = new Scanner(System.in);

        Bookshelf searchedBook = null;


        for (Bookshelf book : books) {

            if (book.name.contains(userInput.toLowerCase())) {

                searchedBook = book;
            }

        }


        assert searchedBook != null;
        System.out.println("Book found: " + searchedBook.name );

        return searchedBook.name;
    }


    public static String searchByAuthor(String userInput) {

        Bookshelf searchedBook = null;


        for (Bookshelf book : books) {

            if (book.author.contains(userInput.toLowerCase())) {

                searchedBook = book;
            }

        }


        assert searchedBook != null;
        System.out.println("Book found: " + searchedBook.name );

        return searchedBook.name;

    }

    public static String searchByGenre(String userInput) {

        Bookshelf searchedBook = null;


        for (Bookshelf book : books) {

            if (book.genre.contains(userInput.toLowerCase())) {

                searchedBook = book;
            }

        }


        assert searchedBook != null;
        System.out.println("Book found: " + searchedBook.name );

        return searchedBook.name;

    }

    public static String searchByReleaseDate(String userInput) {

        Bookshelf searchedBook = null;


        for (Bookshelf book : books) {

            if (book.releaseDate.contains(userInput.toLowerCase())) {

                searchedBook = book;
            }

        }


        assert searchedBook != null;
        System.out.println("Book found: " + searchedBook.name );

        return searchedBook.name;
    }

    public static String searchByRating(int userInput) {

        Bookshelf searchedBook = null;


        for (Bookshelf book : books) {

            if (book.userRatings == userInput) {

                searchedBook = book;
            }

        }


        assert searchedBook != null;
        System.out.println("Book found: " + searchedBook.name );

        return searchedBook.name;


    }

    public static Boolean borrowBook(String userInput) {


        for (Bookshelf book : books) {

            if (book.name.contains(userInput.toLowerCase())) {

                if (book.available = true) {
                    book.available = false;
                    borrowedBooksID.add(book.id);
                    return false;
                }else{
                    return true;}


            }

        }

        return true;
    }

    public static void reviewBook(int id, String comment) {

            if(borrowedBooksID.contains(id)) {

                BookReviews.leaveReview(id, comment);
            }






    }
}
